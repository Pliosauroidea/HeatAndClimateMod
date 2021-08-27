package defeatedcrow.hac.machine.block;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.api.climate.ClimateAPI;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.energy.ITorqueProvider;
import defeatedcrow.hac.api.energy.ITorqueReceiver;
import defeatedcrow.hac.core.energy.TileTorqueBase;
import defeatedcrow.hac.core.fluid.FluidDictionaryDC;
import defeatedcrow.hac.main.api.ISidedTankChecker;
import defeatedcrow.hac.main.block.fluid.DCLimitedTank;
import defeatedcrow.hac.main.config.MainCoreConfig;
import defeatedcrow.hac.main.packet.DCMainPacket;
import defeatedcrow.hac.main.packet.MessageSingleTank;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class TileBoilerTurbine extends TileTorqueBase implements ITorqueProvider, IInventory, ISidedTankChecker {

	public DCLimitedTank inputT = new DCLimitedTank(5000, "water", "steam");

	// process
	public int currentBurnTime = 0;
	public int maxBurnTime = -1;
	protected int currentClimate = DCHeatTier.NORMAL.getID();

	private int lastTier = 0;
	private int lastBurn = 0;

	@Override
	public void updateTile() {
		super.updateTile();

		if (!world.isRemote) {
			// 水の取り込み
			this.checkSideTank();

			// HeatTier更新
			DCHeatTier heat = ClimateAPI.calculator.getAverageTemp(world, pos);
			currentClimate = heat.getID();

			IBlockState state = world.getBlockState(getPos());
			if (!DCState.getBool(state, DCState.POWERED)) {

				// 燃焼処理
				boolean f = false;
				int red = this.getRequiredWater(heat);
				if (red > 0) {
					// 水を減らす
					FluidStack flu = inputT.getFluid();
					if (flu != null && inputT.getFluidAmount() >= red) {
						inputT.drain(red, true);
						f = true;
					}
				}

				if (f) {
					this.currentBurnTime = 1;
					if (MainCoreConfig.sound_boiler > 0D)
						world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, (float) MainCoreConfig.sound_boiler, 0.7F);
				} else {
					this.currentBurnTime = 0;
				}

				if (currentBurnTime > 0) {
					this.currentTorque += this.getProvideTorque(heat);
				}

				// provider
				for (EnumFacing side : getOutputSide()) {
					this.provideTorque(world, getPos().offset(side), side, false);
				}

				// DCLogger.debugLog("current torque: " + currentTorque);
				// DCLogger.debugLog("sent torque: " + prevTorque);
				// DCLogger.debugLog("current burntime: " + currentBurnTime);
				// DCLogger.debugLog("current temp: " + currentClimate);

			}
		}

	}

	private int last = 0;
	private int count = 0;

	@Override
	protected void onServerUpdate() {
		if (count <= 0) {
			if (inputT.getFluidAmount() != last) {
				last = inputT.getFluidAmount();

				DCMainPacket.INSTANCE.sendToAll(new MessageSingleTank(pos, inputT.getFluidIdName(), inputT
						.getFluidAmount()));
			}
			count = 10;
		} else {
			count--;
		}
	}

	public boolean isActive() {
		return this.currentBurnTime > 0;
	}

	public int getCurrentBurnTime() {
		return this.currentBurnTime;
	}

	public int getMaxBurnTime() {
		return this.maxBurnTime;
	}

	public void setCurrentBurnTime(int i) {
		this.currentBurnTime = i;
	}

	public void setMaxBurnTime(int i) {
		this.maxBurnTime = i;
	}

	@Override
	public float maxTorque() {
		return 128.0F;
	}

	@Override
	public float getGearTier() {
		return 16.0F;
	}

	/* 燃焼判定 */

	public boolean hasSteam() {
		if (FluidDictionaryDC.matchFluidName(inputT.getFluidType(), "steam") && inputT.getFluidAmount() >= 10) {
			return true;
		}
		return false;
	}

	public int getRequiredWater(DCHeatTier tier) {
		if (hasSteam()) {
			return 10;
		}
		switch (tier) {
		case OVEN:
			return 1;
		case KILN:
			return 10;
		case SMELTING:
			return 20;
		case UHT:
			return 50;
		default:
			return 0;
		}
	}

	public int getBurnTime() {
		if (hasSteam()) {
			return 4;
		}
		FluidStack f = inputT.getFluid();
		if (f != null && f.getFluid() != null && inputT.getFluidAmount() > 0) {
			if (f.getFluid() == FluidRegistry.WATER) {
				DCHeatTier tier = DCHeatTier.getTypeByID(currentClimate);
				switch (tier) {
				case OVEN:
					return 20;
				case KILN:
					return 4;
				case SMELTING:
					return 2;
				case UHT:
					return 1;
				default:
					return 0;
				}
			}
		}
		return 0;
	}

	public float getProvideTorque(DCHeatTier tier) {
		if (hasSteam()) {
			return 32.0F;
		}
		switch (tier) {
		case OVEN:
			return 8.0F;
		case KILN:
			return 32.0F;
		case SMELTING:
			return 64.0F;
		case UHT:
			return 128.0F;
		default:
			return 0F;
		}
	}

	/* 隣接tankから燃料液体を吸い取る */
	@Override
	public void checkSideTank() {
		for (EnumFacing face : EnumFacing.HORIZONTALS) {
			int cap = inputT.getCapacity();
			int amo = inputT.getFluidAmount();
			int mov = 50; // 50mBずつ

			if (amo >= cap) {
				break;
			}

			TileEntity tile = world.getTileEntity(getPos().offset(face));
			if (tile != null && !(tile instanceof ISidedTankChecker) && tile
					.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, face.getOpposite())) {
				IFluidHandler tank = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, face
						.getOpposite());
				if (tank != null && tank.getTankProperties() != null && tank.getTankProperties().length > 0) {
					FluidStack target = tank.getTankProperties()[0].getContents();
					if (target != null && inputT.canFillTarget(target)) {
						int i = Math.min(mov, cap - amo);
						FluidStack ret = tank.drain(i, false);
						int fill = inputT.fill(ret, false);
						if (fill > 0) {
							ret = tank.drain(fill, true);
							inputT.fill(ret, true);
							tile.markDirty();
							this.markDirty();
							break;
						}
					}
				}
			}
		}
	}

	protected void onProcess() {

	}

	/* ITorqueProvider */

	@Override
	public boolean isInputSide(EnumFacing side) {
		return false;
	}

	@Override
	public boolean isOutputSide(EnumFacing side) {
		return getOutputSide().contains(side);
	}

	@Override
	public List<EnumFacing> getOutputSide() {
		List<EnumFacing> ret = Lists.newArrayList();
		ret.add(getBaseSide());
		return ret;
	}

	@Override
	public float getAmount() {
		return this.getCurrentTorque();
	}

	@Override
	public boolean canProvideTorque(World world, BlockPos outputPos, EnumFacing output) {
		TileEntity tile = world.getTileEntity(outputPos);
		float amo = this.getCurrentTorque();
		if (tile != null && tile instanceof ITorqueReceiver && amo > 0F)
			return ((ITorqueReceiver) tile).canReceiveTorque(amo, output.getOpposite());
		return false;
	}

	@Override
	public float provideTorque(World world, BlockPos outputPos, EnumFacing output, boolean sim) {
		float amo = this.getCurrentTorque();
		if (canProvideTorque(world, outputPos, output)) {
			ITorqueReceiver target = (ITorqueReceiver) world.getTileEntity(outputPos);
			float ret = target.receiveTorque(amo, output, sim);
			return ret;
		}
		return 0;
	}

	/* NBT, Packet */

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return true;
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return false;
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return (T) inputT;
		else if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return null;
		return super.getCapability(capability, facing);
	}

	@Override
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
	}

	/* Packet,NBT */

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		this.currentBurnTime = tag.getInteger("BurnTime");
		this.maxBurnTime = tag.getInteger("MaxTime");
		this.currentClimate = tag.getByte("Climate");

		inputT = (DCLimitedTank) inputT.readFromNBT(tag, "Tank");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setInteger("BurnTime", this.currentBurnTime);
		tag.setInteger("MaxTime", this.maxBurnTime);
		tag.setByte("Climate", (byte) this.currentClimate);

		inputT.writeToNBT(tag, "Tank");
		return tag;
	}

	@Override
	public NBTTagCompound getNBT(NBTTagCompound tag) {
		super.getNBT(tag);

		tag.setInteger("BurnTime", this.currentBurnTime);
		tag.setInteger("MaxTime", this.maxBurnTime);
		tag.setByte("Climate", (byte) this.currentClimate);

		inputT.writeToNBT(tag, "Tank");
		return tag;
	}

	@Override
	public void setNBT(NBTTagCompound tag) {
		super.setNBT(tag);

		this.currentBurnTime = tag.getInteger("BurnTime");
		this.maxBurnTime = tag.getInteger("MaxTime");
		this.currentClimate = tag.getByte("Climate");

		inputT = (DCLimitedTank) inputT.readFromNBT(tag, "Tank");
	}

	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		this.writeToNBT(nbtTagCompound);
		return new SPacketUpdateTileEntity(pos, -50, nbtTagCompound);
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	/* fieldがIInventoryにしかないとかいうクソ仕様のため、GUI表示用にダミーInventoryをつける。インベントリは実際無い */

	@Override
	public String getName() {
		return "dcs.gui.device.boiler_turbine";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStack.EMPTY;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return getWorld().getTileEntity(this.pos) != this ? false : player.getDistanceSq(this.pos
				.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	@Override
	public int getField(int id) {
		switch (id) {
		case 0:
			return this.currentBurnTime;
		case 1:
			return this.maxBurnTime;
		case 2:
			return this.currentClimate;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.currentBurnTime = value;
			break;
		case 1:
			this.maxBurnTime = value;
			break;
		case 2:
			this.currentClimate = value;
			break;
		default:
			return;
		}
	}

	@Override
	public int getFieldCount() {
		return 3;
	}

	@Override
	public void clear() {}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
