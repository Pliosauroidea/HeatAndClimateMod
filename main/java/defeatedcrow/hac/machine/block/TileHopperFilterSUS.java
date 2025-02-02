package defeatedcrow.hac.machine.block;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.api.blockstate.EnumSide;
import defeatedcrow.hac.core.base.DCInventory;
import defeatedcrow.hac.core.base.DCLockableTE;
import defeatedcrow.hac.core.util.DCUtil;
import defeatedcrow.hac.machine.gui.ContainerHopperFilterSUS;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class TileHopperFilterSUS extends DCLockableTE implements IHopper, ISidedInventory {

	protected DCInventory inv = new DCInventory(10);
	private int cooldown = -1;
	private int lastCount = 0;
	private boolean lastUni = false;
	private boolean unifier = false;

	public int getCoolTime() {
		return 0;
	}

	public boolean isFilterd(int slot) {
		return slot < 5;
	}

	public boolean isUnifierMode() {
		return unifier;
	}

	public void switchUnifierMode() {
		unifier = !unifier;
	}

	@Override
	public void onServerUpdate() {
		if (cooldown <= 0) {
			cooldown = getCoolTime();
			if (isActive()) {
				extractItem();
				if (!suctionItem()) {
					suctionDrop();
				}
			}
		} else {
			cooldown--;
		}
	}

	@Nullable
	protected EnumFacing getCurrentFacing() {
		if (this.world != null && this.pos != null) {
			IBlockState state = this.world.getBlockState(pos);
			if (state != null && state.getBlock() instanceof BlockHopperFilterSUS) {
				EnumSide side = DCState.getSide(state, DCState.SIDE);
				if (side != null && side != EnumSide.DOWN && side != EnumSide.UP)
					return side.getFacing();
			}
		}
		return EnumFacing.NORTH;
	}

	protected EnumFacing getExtractSide() {
		return EnumFacing.DOWN;
	}

	protected EnumFacing getInsertSide() {
		return EnumFacing.UP;
	}

	private boolean isActive() {
		IBlockState state = this.world.getBlockState(pos);
		if (state != null && state.getBlock() instanceof BlockHopperFilterSUS) {
			boolean flag = DCState.getBool(state, DCState.POWERED);
			return flag;
		}
		return true;
	}

	protected boolean extractItem() {
		EnumFacing pass = getCurrentFacing();
		EnumFacing down = getExtractSide();

		// down
		if (down != null) {
			TileEntity tile = world.getTileEntity(pos.offset(down));
			if (tile != null && tile.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, down.getOpposite())) {
				IItemHandler target = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, down
						.getOpposite());
				if (target != null) {
					boolean b = false;
					for (int i = 0; i < this.getFilterInventory(); i++) {
						ItemStack item = inv.getStackInSlot(i);
						int min = 1;
						if (!DCUtil.isEmpty(item)) {
							if (item.getItem().getItemStackLimit(item) == 1) {
								min = 0;
							}
							if (DCUtil.getSize(item) > min) {
								ItemStack ins = item.copy();
								ins.setCount(1);
								for (int j = 0; j < target.getSlots(); j++) {
									ItemStack ret = target.insertItem(j, ins, true);
									if (DCUtil.isEmpty(ret)) {
										target.insertItem(j, ins, false);
										this.decrStackSize(i, 1);
										this.markDirty();
										tile.markDirty();
										return true;
									}
								}
							}
						}
					}
				}
			}
		}

		// pass
		TileEntity tile = world.getTileEntity(pos.offset(pass));
		if (tile != null && tile.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, pass.getOpposite())) {
			IItemHandler target = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, pass.getOpposite());
			if (target != null) {
				boolean b = false;
				for (int i = this.getFilterInventory(); i < this.getSizeInventory(); i++) {
					ItemStack item = inv.getStackInSlot(i);
					if (!DCUtil.isEmpty(item)) {
						if (DCUtil.getSize(item) > 0) {
							ItemStack ins = item.copy();
							ins.setCount(1);
							for (int j = 0; j < target.getSlots(); j++) {
								ItemStack ret = target.insertItem(j, ins, true);
								if (DCUtil.isEmpty(ret)) {
									target.insertItem(j, ins, false);
									this.decrStackSize(i, 1);
									this.markDirty();
									tile.markDirty();
									return true;
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	protected boolean suctionItem() {
		EnumFacing face = getCurrentFacing() == EnumFacing.UP ? EnumFacing.DOWN : EnumFacing.UP;
		TileEntity tile = world.getTileEntity(pos.offset(face));
		if (tile != null && tile.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN)) {
			IItemHandler target = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
			if (target != null) {
				for (int i = 0; i < target.getSlots(); i++) {
					ItemStack item = target.extractItem(i, 1, true);
					if (!DCUtil.isEmpty(item) && insertItem(item)) {
						target.extractItem(i, 1, false);
						tile.markDirty();
						this.markDirty();
						return true;
					}
				}
			}
		}
		return false;
	}

	protected boolean suctionDrop() {
		double x1 = getPos().getX() - 0D;
		double x2 = getPos().getX() + 1D;
		double y1 = getPos().getY() + 0.5D;
		double y2 = getPos().getY() + 2D;
		double z1 = getPos().getZ() - 0D;
		double z2 = getPos().getZ() + 1D;
		if (getCurrentFacing() == EnumFacing.UP) {
			y1 = getPos().getY() - 2D;
			y2 = getPos().getY() + 0.5D;
		}
		List<EntityItem> list = this.world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x1, y1, z1, x2, y2,
				z2));
		if (list == null || list.isEmpty())
			return false;

		for (int i = 0; i < list.size(); ++i) {
			EntityItem entity = list.get(i);
			if (entity != null) {
				EntityItem drop = entity;
				if (!DCUtil.isEmpty(drop.getItem())) {
					ItemStack item = drop.getItem().copy();
					item.setCount(1);
					if (!DCUtil.isEmpty(item) && insertItem(item)) {
						drop.getItem().splitStack(1);
						this.markDirty();
						if (DCUtil.isEmpty(drop.getItem())) {
							drop.setDead();
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	protected boolean insertItem(ItemStack target) {
		if (!DCUtil.isEmpty(target)) {
			// Filter target
			boolean same = false;
			for (int j = 0; j < this.getFilterInventory(); j++) {
				ItemStack cur = this.getStackInSlot(j);
				if (DCUtil.isSameItem(target, cur, true)) {
					same = true;
				} else if (unifier && DCUtil.hasSameDic(target, cur)) {
					same = true;
				}
			}

			if (same) {
				for (int j = 0; j < this.getFilterInventory(); j++) {
					ItemStack cur = this.getStackInSlot(j);
					if (this.isItemStackable(target, cur) > 0) {
						this.incrStackInSlot(j, target);
						return true;
					} else if (this.isItemUnifiable(target, cur) > 0) {
						ItemStack split = cur.copy();
						split.setCount(target.getCount());
						this.incrStackInSlot(j, split);
						return true;
					}
				}
				return false;
			} else {
				for (int j = this.getFilterInventory(); j < this.getSizeInventory(); j++) {
					ItemStack cur = this.getStackInSlot(j);
					if (this.isItemStackable(target, cur) > 0) {
						this.incrStackInSlot(j, target);
						return true;
					}
				}
			}
		}
		return false;
	}

	/* === 追加メソッド === */

	public static int isItemStackable(ItemStack target, ItemStack current) {
		if (DCUtil.isSameItem(target, current, true)) {
			int i = current.getCount() + target.getCount();
			if (i > current.getMaxStackSize()) {
				i = current.getMaxStackSize() - current.getCount();
				return i;
			}
			return target.getCount();
		}

		return 0;
	}

	public int isItemUnifiable(ItemStack target, ItemStack current) {
		if (unifier && DCUtil.hasSameDic(target, current)) {
			int i = current.getCount() + target.getCount();
			if (i > current.getMaxStackSize()) {
				i = current.getMaxStackSize() - current.getCount();
				return i;
			}
			return target.getCount();
		}

		return 0;
	}

	public void incrStackInSlot(int i, ItemStack input) {
		inv.incrStackInSlot(i, input);
	}

	/* === IInventory === */

	public int getFilterInventory() {
		return 5;
	}

	@Override
	public int getSizeInventory() {
		return 10;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inv.getStackInSlot(i);
	}

	@Override
	public ItemStack decrStackSize(int i, int num) {
		return inv.decrStackSize(i, num);
	}

	@Override
	public ItemStack removeStackFromSlot(int i) {
		return inv.removeStackFromSlot(i);
	}

	// インベントリ内のスロットにアイテムを入れる
	@Override
	public void setInventorySlotContents(int i, ItemStack stack) {
		inv.setInventorySlotContents(i, stack);
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (getWorld().getTileEntity(this.pos) != this || player == null)
			return false;
		else
			return Math.sqrt(player.getDistanceSq(pos)) < 256D;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		if (id == 0)
			return this.unifier ? 1 : 0;
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		if (id == 0) {
			this.unifier = value > 0;
		}
	}

	@Override
	public int getFieldCount() {
		return 1;
	}

	@Override
	public void clear() {
		inv.clear();
	}

	@Override
	public String getName() {
		return "dcs.gui.device.hopper.sus";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerHopperFilterSUS(this, playerIn);
	}

	@Override
	public String getGuiID() {
		return "dcs.gui.device.hopper.sus";
	}

	@Override
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}

	/* === Hopper === */

	@Override
	public double getXPos() {
		return this.pos.getX() + 0.5D;
	}

	@Override
	public double getYPos() {
		return this.pos.getY() + 0.5D;
	}

	@Override
	public double getZPos() {
		return this.pos.getZ() + 0.5D;
	}

	@Override
	public World getWorld() {
		return this.world;
	}

	/* === SidedInventory === */

	protected int[] slotsSides() {
		return new int[] {
				0,
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9
		};
	};

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return slotsSides();
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStack, EnumFacing dir) {
		return this.isItemValidForSlot(index, itemStack);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing dir) {
		if (!DCUtil.isEmpty(stack)) {
			return !isFilterd(index) || stack.getCount() > 1 || stack.getItem().getItemStackLimit(stack) == 1;
		}
		return false;
	}

	IItemHandler handler = new HopperInvWrapper(this, getCurrentFacing());
	IItemHandler handler2 = new HopperInvWrapper(this, getCurrentFacing()) {
		@Override
		@Nonnull
		public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
			return stack;
		}
	};

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (facing == getCurrentFacing() || facing == getExtractSide()) {
				return (T) handler2;
			} else {
				return (T) handler;
			}
		}
		return null;
	}

	/* Packet,NBT */

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		inv.readFromNBT(tag);

		this.cooldown = tag.getInteger("Cooldown");
		this.lastUni = tag.getBoolean("LastUni");
		this.unifier = tag.getBoolean("Unifier");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		// 燃焼時間や調理時間などの書き込み
		tag.setInteger("Cooldown", this.cooldown);
		tag.setBoolean("LastUni", lastUni);
		tag.setBoolean("Unifier", unifier);

		// アイテムの書き込み
		inv.writeToNBT(tag);
		return tag;
	}

	@Override
	public NBTTagCompound getNBT(NBTTagCompound tag) {
		super.getNBT(tag);
		// 燃焼時間や調理時間などの書き込み
		tag.setInteger("Cooldown", this.cooldown);
		tag.setBoolean("LastUni", lastUni);
		tag.setBoolean("Unifier", unifier);

		// アイテムの書き込み
		inv.writeToNBT(tag);

		return tag;
	}

	@Override
	public void setNBT(NBTTagCompound tag) {
		super.setNBT(tag);

		inv.readFromNBT(tag);

		this.cooldown = tag.getInteger("Cooldown");
		this.lastUni = tag.getBoolean("LastUni");
		this.unifier = tag.getBoolean("Unifier");
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

	@Override
	public void markDirty() {}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString(this.getName());
	}

	@Override
	public boolean isEmpty() {
		return inv.isEmpty();
	}

	private class HopperInvWrapper extends SidedInvWrapper {
		private HopperInvWrapper(TileHopperFilterSUS tile, EnumFacing side) {
			super(tile, side);
		}

		@Override
		@Nonnull
		public ItemStack extractItem(int slot, int amount, boolean simulate) {
			if (amount <= 0)
				return ItemStack.EMPTY;

			int slot1 = getSlot(inv, slot, side);

			if (slot1 == -1)
				return ItemStack.EMPTY;

			ItemStack stackInSlot = inv.getStackInSlot(slot1);

			if (stackInSlot.isEmpty())
				return ItemStack.EMPTY;

			if (!inv.canExtractItem(slot1, stackInSlot, side))
				return ItemStack.EMPTY;

			ItemStack copy2 = stackInSlot.copy();
			int count = copy2.getCount();
			if (count > amount) {
				count = amount;
			} else {
				if (stackInSlot.getItem().getItemStackLimit(copy2) == 1) {
					count = 1;
				} else if (isFilterd(slot)) {
					count--;
				}
			}

			if (count <= 0) {
				return ItemStack.EMPTY;
			}

			if (simulate) {
				if (stackInSlot.getCount() < count) {
					return stackInSlot.copy();
				} else {
					ItemStack copy = stackInSlot.copy();
					copy.setCount(count);
					return copy;
				}
			} else {
				int m = Math.min(stackInSlot.getCount(), count);
				ItemStack ret = inv.decrStackSize(slot1, m);
				inv.markDirty();
				return ret;
			}
		}
	}

}
