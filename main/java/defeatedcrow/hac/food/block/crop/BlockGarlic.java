package defeatedcrow.hac.food.block.crop;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.api.cultivate.GrowingStage;
import defeatedcrow.hac.core.base.ClimateCropBase;
import defeatedcrow.hac.core.base.ITexturePath;
import defeatedcrow.hac.food.FoodInit;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGarlic extends ClimateCropBase implements ITexturePath {

	protected static final AxisAlignedBB BUD_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.5D, 0.875D);

	public BlockGarlic(String s) {
		super(Material.PLANTS, s, 3);
		setSoundType(SoundType.PLANT);
		setHardness(0.0F);
		setResistance(3.0F);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = DCState.getInt(state, DCState.STAGE4);
		return i < 2 ? BUD_AABB : CROP_AABB;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public String[] getNameSuffix() {
		return null;
	}

	@Override
	public String getTexture(int meta, int side, boolean face) {
		int m = meta & 3;
		String b = "dcs_climate:blocks/crop/";
		return b + "garlic_" + m;
	}

	public static List<String> getTexList() {
		List<String> list = new ArrayList<String>();
		String b = "dcs_climate:blocks/crop/";
		list.add(b + "garlic_0");
		list.add(b + "garlic_1");
		list.add(b + "garlic_2");
		list.add(b + "garlic_3");
		return list;
	}

	@Override
	public String getTexPath(int meta, boolean isFull) {
		int m = meta & 3;
		String b = "dcs_climate:items/block/crop/";
		return b + "garlic_" + m;
	}

	@Override
	public ItemStack getSeedItem(IBlockState thisState) {
		int i = 1;
		if (this.getCurrentStage(thisState) == GrowingStage.GROWN) {
			i = 1 + cropRand.nextInt(2);
		}

		return new ItemStack(FoodInit.seeds, i, 12);
	}

	@Override
	public List<ItemStack> getCropItems(IBlockState thisState, int fortune) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(FoodInit.crops, 1, 14));
		return list;
	}

	@Override
	public IBlockState setGroundState(IBlockState state) {
		return this.getDefaultState().withProperty(DCState.STAGE4, 0);
	}

	@Override
	public boolean canStayOnHarvest() {
		return true;
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
		ret.add(DCHumidity.NORMAL);
		ret.add(DCHumidity.WET);
		return ret;
	}

	@Override
	public List<DCHeatTier> getHardmodeTemp(IBlockState thisState) {
		List<DCHeatTier> ret = new ArrayList<DCHeatTier>();
		ret.add(DCHeatTier.HOT);
		return ret;
	}

	@Override
	public List<DCHumidity> getHardmodeHum(IBlockState thisState) {
		List<DCHumidity> ret = new ArrayList<DCHumidity>();
		ret.add(DCHumidity.WET);
		return ret;
	}

	@Override
	public List<DCAirflow> getHardmodeAir(IBlockState thisState) {
		List<DCAirflow> ret = new ArrayList<DCAirflow>();
		ret.add(DCAirflow.FLOW);
		return ret;
	}

}
