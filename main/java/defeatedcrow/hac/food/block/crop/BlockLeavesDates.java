package defeatedcrow.hac.food.block.crop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.core.base.ClimateCropBase;
import defeatedcrow.hac.core.base.ITexturePath;
import defeatedcrow.hac.food.FoodInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLeavesDates extends ClimateCropBase implements ITexturePath, IShearable {

	public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
	public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");
	private final Random leavesRand = new Random();

	public BlockLeavesDates(String s) {
		super(Material.LEAVES, s, 3);
		setSoundType(SoundType.PLANT);
		setHardness(0.0F);
		setResistance(3.0F);
		setLightOpacity(1);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DCState.STAGE4, 0)
				.withProperty(DECAYABLE, false).withProperty(CHECK_DECAY, false));
	}

	@Override
	public int tickRate(World world) {
		return 200;
	}

	/* leavesの挙動 */
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		int i = 1;
		int j = i + 1;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		if (world.isAreaLoaded(new BlockPos(x - j, y - j, z - j), new BlockPos(x + j, y + j, z + j))) {
			for (int x1 = -i; x1 <= i; ++x1) {
				for (int y1 = -i; y1 <= i; ++y1) {
					for (int z1 = -i; z1 <= i; ++z1) {
						BlockPos blockpos = pos.add(x1, y1, z1);
						IBlockState iblockstate = world.getBlockState(blockpos);

						if (iblockstate.getBlock().isLeaves(iblockstate, world, blockpos)) {
							iblockstate.getBlock().beginLeavesDecay(iblockstate, world, blockpos);
						}
					}
				}
			}
		}
	}

	private void destroy(World worldIn, BlockPos pos) {
		this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
		worldIn.setBlockToAir(pos);
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return Arrays.asList(new ItemStack(this, 1, 0));
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(this, 1, 0);
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return true;
	}

	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public String[] getNameSuffix() {
		return null;
	}

	@Override
	public String getTexture(int meta, int side, boolean face) {
		int m = meta & 3;
		String b = "dcs_climate:blocks/crop/";
		return b + "dates_" + m;
	}

	public static List<String> getTexList() {
		List<String> list = new ArrayList<String>();
		String b = "dcs_climate:blocks/crop/";
		list.add(b + "dates_0");
		list.add(b + "dates_0");
		list.add(b + "dates_0");
		list.add(b + "dates_0");
		return list;
	}

	@Override
	public String getTexPath(int meta, boolean isFull) {
		int m = meta & 3;
		String b = "dcs_climate:items/block/crop/";
		return b + "dates_" + m;
	}

	@Override
	public ItemStack getSeedItem(IBlockState thisState) {
		return new ItemStack(FoodInit.saplings2, 1, 1);
	}

	@Override
	public List<ItemStack> getCropItems(IBlockState thisState, int fortune) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		// 作物なし
		return list;
	}

	/* ClimateCrop */
	@Override
	public boolean grow(World world, BlockPos pos, IBlockState thisState) {
		// 育たない
		return false;
	}

	@Override
	public boolean harvest(World world, BlockPos pos, IBlockState thisState, EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isCollectable(ItemStack item) {
		return false;
	}

	@Override
	public boolean isSuitablePlace(World world, BlockPos pos, IBlockState stateIn) {
		IBlockState state = world.getBlockState(pos);
		if (!world.isRemote && state.getBlock() == this) {
			if (state.getValue(CHECK_DECAY).booleanValue() && state.getValue(DECAYABLE).booleanValue()) {
				int i = 4;
				int j = i + 1;
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				boolean hasLog = false;

				if (world.isAreaLoaded(new BlockPos(x - j, y - j, z - j), new BlockPos(x + j, y + j, z + j))) {
					BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

					for (int x1 = -i; x1 <= i; ++x1) {
						for (int y1 = -i; y1 <= i; ++y1) {
							for (int z1 = -i; z1 <= i; ++z1) {
								IBlockState iblockstate = world.getBlockState(blockpos$mutableblockpos
										.setPos(x + x1, y + y1, z + z1));
								Block block = iblockstate.getBlock();

								if (block.canSustainLeaves(iblockstate, world, blockpos$mutableblockpos
										.setPos(x + x1, y + y1, z + z1))) {
									hasLog = true;
								}
							}
						}
					}
				}

				if (hasLog) {
					world.setBlockState(pos, state.withProperty(CHECK_DECAY, Boolean.valueOf(false)), 4);
					return true;
				} else {
					this.destroy(world, pos);
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void beginLeavesDecay(IBlockState state, World world, BlockPos pos) {
		if (!(Boolean) state.getValue(CHECK_DECAY)) {
			world.setBlockState(pos, state.withProperty(CHECK_DECAY, true), 4);
		}
	}

	@Override
	protected float getSeedDropChance() {
		return 0.1F;
	}

	@Override
	public boolean canStayOnHarvest() {
		return true;
	}

	/* state関連 */

	@Override
	public IBlockState getStateFromMeta(int meta) {
		int i = meta & 3;
		boolean d = (meta & 4) > 0;
		boolean c = (meta & 8) > 0;
		IBlockState state = this.getDefaultState().withProperty(DCState.STAGE4, i).withProperty(DECAYABLE, d)
				.withProperty(CHECK_DECAY, c);
		return state;
	}

	// state
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		i = state.getValue(DCState.STAGE4);
		if (state.getValue(DECAYABLE)) {
			i += 4;
		}
		if (state.getValue(CHECK_DECAY)) {
			i += 8;
		}
		return i;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {
				DCState.STAGE4,
				DECAYABLE,
				CHECK_DECAY
		});
	}

	@Override
	public List<DCHeatTier> getSuitableTemp(IBlockState thisState) {
		List<DCHeatTier> ret = new ArrayList<DCHeatTier>();
		ret.add(DCHeatTier.NORMAL);
		ret.add(DCHeatTier.WARM);
		ret.add(DCHeatTier.HOT);
		ret.add(DCHeatTier.BOIL);
		return ret;
	}

	@Override
	public List<DCHumidity> getSuitableHum(IBlockState thisState) {
		List<DCHumidity> ret = new ArrayList<DCHumidity>();
		ret.add(DCHumidity.DRY);
		ret.add(DCHumidity.NORMAL);
		ret.add(DCHumidity.WET);
		return ret;
	}

}
