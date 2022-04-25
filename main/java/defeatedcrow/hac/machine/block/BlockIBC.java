package defeatedcrow.hac.machine.block;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.api.climate.IClimate;
import defeatedcrow.hac.core.base.DCTileBlockFaced;
import defeatedcrow.hac.core.fluid.DCFluidUtil;
import defeatedcrow.hac.core.util.DCUtil;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.main.util.MainUtil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class BlockIBC extends DCTileBlockFaced {
	public BlockIBC(String s) {
		super(Material.CLAY, s, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileIBC();
	}

	@Override
	public boolean isSideSolid(IBlockState state, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return side != EnumFacing.UP;
	}

	@Override
	public boolean onRightClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (player != null) {
			ItemStack heldItem = player.getHeldItem(hand);
			if (hand == EnumHand.MAIN_HAND) {
				TileEntity tile = world.getTileEntity(pos);
				if (!world.isRemote && tile instanceof TileIBC) {
					if (!DCUtil.isEmpty(heldItem)) {
						if (DCFluidUtil.onActivateDCTank(tile, heldItem, world, state, side, player)) {
							world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.8F, 2.0F);
						}
					} else {
						FluidStack f = ((TileIBC) tile).inputT.getFluid();
						if (f != null) {
							String name = f.getLocalizedName();
							int i = f.amount;
							String mes1 = "Stored Fluid: " + name + " " + i + "mB";
							player.sendMessage(new TextComponentString(mes1));
						}
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public List<ItemStack> getSubItemList() {
		List<ItemStack> list = Lists.newArrayList();
		list.add(new ItemStack(this, 1, 0));
		return list;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		// block側の気候処理は無し
	}

	@Override
	public boolean onClimateChange(World world, BlockPos pos, IBlockState state, IClimate clm) {
		return false;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	public static void changeLitState(World world, BlockPos pos, boolean f) {
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock() == MachineInit.IBC) {
			if (f) {
				world.setBlockState(pos, state.withProperty(DCState.TYPE4, 1), 3);
			} else {
				world.setBlockState(pos, state.withProperty(DCState.TYPE4, 0), 3);
			}
		}
	}

	public static boolean isLit(IBlockAccess world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock() != MachineInit.IBC)
			return false;
		int meta = state.getBlock().getMetaFromState(state) & 3;
		return meta > 0;
	}

	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
		int meta = this.getMetaFromState(state) & 3;
		return meta == 1 ? 15 : 0;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	// redstone

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return MainUtil.calcTankRedstone(worldIn.getTileEntity(pos));
	}
}
