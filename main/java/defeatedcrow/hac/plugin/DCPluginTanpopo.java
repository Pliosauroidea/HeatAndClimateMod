package defeatedcrow.hac.plugin;

import defeatedcrow.hac.api.module.HaCModule;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.DCRecipe;
import defeatedcrow.hac.main.MainInit;
import defeatedcrow.hac.main.config.ModuleConfig;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class DCPluginTanpopo {

	public static final DCPluginTanpopo INSTANCE = new DCPluginTanpopo();

	private DCPluginTanpopo() {}

	public static void load() {
		Item fluff = Item.REGISTRY.getObject(new ResourceLocation("schr0tanpopo", "material_fluff"));
		if (fluff != null) {

			OreDictionary.registerOre("cropFluff", new ItemStack(fluff, 1, 0));

			DCRecipe.jsonShapedRecipe(HaCModule.getPlugin("schr0tanpopo"), "plugin", new ItemStack(MainInit.clothes, 1,
					1), new Object[] {
							"XXX",
							"XYX",
							"XXX",
							'X',
							"cropFluff",
							'Y',
							"stickWood"
			});

			if (ModuleConfig.r_spinning) {
				RecipeAPI.registerSpinningRecipes.addRecipe(new ItemStack(MainInit.clothes, 1, 1), 4, "cropFluff");
			}
		}

		Fluid f = FluidRegistry.getFluid("fluid_essence");
		if (f != null) {
			DrinkPotionType.registerPotion(f.getName(), MobEffects.HEALTH_BOOST);
			DCPluginFluid.registerFuel(f.getName(), "seed_oil", 60);
		}

	}

}
