package defeatedcrow.hac.machine.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.core.base.ITagGetter;
import defeatedcrow.hac.core.energy.BlockTorqueBase;
import defeatedcrow.hac.core.fluid.DCFluidUtil;
import defeatedcrow.hac.core.util.DCUtil;
import defeatedcrow.hac.main.ClimateMain;
import defeatedcrow.hac.main.util.DCName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPortalManager extends BlockTorqueBase {

	public BlockPortalManager(String s) {
		super(Material.ROCK, s, 0);
		this.setHardness(1.5F);
		this.setSoundType(SoundType.METAL);
	}

	@Override
	public boolean isSideSolid(IBlockState state, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return side == EnumFacing.DOWN;
	}

	@Override
	public boolean onRightClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (player != null) {
			if (DCUtil.isHeldWrench(player, hand)) {
				return super.onRightClick(world, pos, state, player, hand, side, hitX, hitY, hitZ);
			}
			ItemStack heldItem = player.getHeldItem(hand);
			TileEntity tile = world.getTileEntity(pos);
			if (tile instanceof TilePortalManager) {
				if (!player.world.isRemote && player != null && hand == EnumHand.MAIN_HAND) {
					ItemStack held = player.getHeldItem(hand);
					if (!DCUtil.isEmpty(held) && held
							.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, side)) {
						if (DCFluidUtil.onActivateDCTank(tile, heldItem, world, state, side, player))
							world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.8F, 2.0F);
					} else {
						player.openGui(ClimateMain.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
					}
				}
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TilePortalManager();
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		TileEntity tile = world.getTileEntity(pos);
		if (tile != null && tile instanceof ITagGetter) {
			NBTTagCompound tag = stack.getTagCompound();
			if (tag != null) {
				((ITagGetter) tile).setNBT(tag);
			}
		}
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tile = world.getTileEntity(pos);
		int i = this.damageDropped(state);
		ItemStack drop = new ItemStack(this, 1, i);

		if (tile != null && tile instanceof ITagGetter) {
			NBTTagCompound tag = new NBTTagCompound();
			tag = ((ITagGetter) tile).getNBT(tag);
			if (tag != null) {
				drop.setTagCompound(tag);
			}
		}

		if (!world.isRemote) {
			EntityItem entityitem = new EntityItem(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
					drop);
			float f3 = 0.05F;
			entityitem.motionX = (float) world.rand.nextGaussian() * f3;
			entityitem.motionY = (float) world.rand.nextGaussian() * f3 + 0.25F;
			entityitem.motionZ = (float) world.rand.nextGaussian() * f3;
			world.spawnEntity(entityitem);
		}
		world.updateComparatorOutputLevel(pos, state.getBlock());
		super.breakBlock(world, pos, state);

	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
		if (ClimateCore.proxy.isShiftKeyDown()) {
			tooltip.add(TextFormatting.YELLOW.toString() + TextFormatting.BOLD.toString() + "=== Requirement ===");
			tooltip.add(TextFormatting.BLUE.toString() + "CRYOGENIC-" + TextFormatting.GRAY.toString() + I18n
					.format("dcs.tip.portal1"));
			tooltip.add(DCName.TORQUE.getLocalizedName() + ": 32.0F /s");
			tooltip.add(I18n.format("dcs.tip.portal2"));
			tooltip.add(TextFormatting.YELLOW.toString() + TextFormatting.BOLD.toString() + "=== Output ===");
			tooltip.add(DCName.ITEM.getLocalizedName() + DCName.TRANSPORT.getLocalizedName() + ": 1 item/t");
			tooltip.add(DCName.FLUID.getLocalizedName() + DCName.TRANSPORT.getLocalizedName() + ": 1000 mB/t");
			tooltip.add(TextFormatting.YELLOW.toString() + TextFormatting.BOLD.toString() + "=== Tips ===");
			tooltip.add(I18n.format("dcs.tip.portal3"));
		} else {
			tooltip.add(TextFormatting.ITALIC.toString() + "=== Lshift key: expand tooltip ===");
		}
	}
}
