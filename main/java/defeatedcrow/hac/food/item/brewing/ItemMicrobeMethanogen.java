package defeatedcrow.hac.food.item.brewing;

import java.util.List;

import com.google.common.collect.ImmutableList;

import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.food.FoodInit;
import defeatedcrow.hac.main.api.brewing.EnumHabitat;
import defeatedcrow.hac.main.api.brewing.EnumMedium;
import defeatedcrow.hac.main.api.brewing.EnumMicrobeType;
import defeatedcrow.hac.main.api.brewing.IMicrobe;
import net.minecraft.item.Item;

public class ItemMicrobeMethanogen extends MicrobeItem implements IMicrobe {

	public ItemMicrobeMethanogen() {
		super();
	}

	@Override
	public Item getMicrobeItem() {
		return FoodInit.methanogen;
	}

	@Override
	public String getTexPath(int meta, boolean f) {
		String s = "items/food/brewing/archaea_methanogen";
		if (f) {
			s = "textures/" + s;
		}
		return ClimateCore.PACKAGE_ID + ":" + s;
	}

	@Override
	public String getName() {
		return "methanogen";
	}

	@Override
	public boolean getGramStaining() {
		return false;
	}

	@Override
	public int getIncubationDays() {
		return 5;
	}

	@Override
	public EnumMicrobeType getType() {
		return EnumMicrobeType.ARCHAEA;
	}

	@Override
	public int getChance(EnumHabitat habitat) {
		switch (habitat) {
		case ANIMAL:
			return 10;
		case WATER:
			return 10;
		default:
			return 0;
		}
	}

	@Override
	public List<EnumMedium> getMediums() {
		return ImmutableList.of(EnumMedium.STANDARD, EnumMedium.GIBLETS);
	}

	@Override
	public List<DCHeatTier> getHeats() {
		return ImmutableList.of(DCHeatTier.HOT, DCHeatTier.BOIL, DCHeatTier.OVEN);
	}

	@Override
	public List<DCHumidity> getHums() {
		return ImmutableList.of(DCHumidity.WET, DCHumidity.UNDERWATER);
	}

	@Override
	public List<DCAirflow> getAirs() {
		return ImmutableList.of(DCAirflow.TIGHT);
	}

	@Override
	public String[] getNameSuffix() {
		return null;
	}

}
