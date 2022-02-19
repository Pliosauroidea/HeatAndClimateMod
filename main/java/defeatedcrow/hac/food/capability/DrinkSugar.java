package defeatedcrow.hac.food.capability;

import defeatedcrow.hac.core.util.DCUtil;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public enum DrinkSugar {
	NONE(0, 0),
	SUGAR(1, 1),
	HONEY(2, 2),
	MAPLE(3, 3),
	SPICE(4, 2);

	public final int effect;
	public final int id;

	private DrinkSugar(int i, int param) {
		effect = param;
		id = i;
	}

	public static DrinkSugar getFromId(int i) {
		if (i == 0)
			return NONE;
		else if (i == 1)
			return SUGAR;
		else if (i == 2)
			return HONEY;
		else if (i == 3)
			return MAPLE;
		else if (i == 4)
			return SPICE;
		return NONE;
	}

	public static String getTagKey() {
		return "dcs.drink.sugar";
	}

	public static DrinkSugar isSugarItem(ItemStack item) {
		if (DCUtil.isEmpty(item))
			return NONE;
		else {

			int[] ids = OreDictionary.getOreIDs(item);
			for (int i : ids) {
				String name = OreDictionary.getOreName(i);
				if (name.contains("honey") || name.contains("Honey"))
					return HONEY;
				else if (name.contains("sugar") || name.contains("Sugar"))
					return SUGAR;
				else if (name.contains("Maplesyrup") || name.contains("MapleSyrup"))
					return MAPLE;
				else if (name.equalsIgnoreCase("listAllspice"))
					return SPICE;
			}
			return NONE;
		}
	}
}
