package defeatedcrow.hac.main.recipes;

import defeatedcrow.hac.api.module.HaCModule;
import defeatedcrow.hac.core.DCInit;
import defeatedcrow.hac.core.DCRecipe;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.main.MainInit;
import defeatedcrow.hac.main.config.ModuleConfig;
import defeatedcrow.hac.main.util.RecipeResourcesMain;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class LoadingToolRecipe {

	public static void add(RecipeResourcesMain res) {
		// clothes

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 0), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				"blockTallgrass",
				'Y',
				"toolSpindle"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 1), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(Items.STRING, 1, 0),
				'Y',
				"toolSpindle"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.clothes, 1, 1), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				"cropCotton",
				'Y',
				"toolSpindle"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 2), new Object[] {
				" X ",
				"X X",
				" X ",
				'X',
				new ItemStack(MainInit.clothes, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 3), new Object[] {
				" X ",
				"X X",
				" X ",
				'X',
				new ItemStack(MainInit.clothes, 1, 1)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.gears, 1, 0), new Object[] {
				" X ",
				"XYX",
				" X ",
				'X',
				"plankWood",
				'Y',
				"stickWood"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.gears, 1, 1), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearWood",
				'X',
				"ingotBrass"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.gears, 1, 1), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearWood",
				'X',
				"ingotBronze"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.gears, 1, 2), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearWood",
				'X',
				"ingotNickelsilver"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.gears, 1, 3), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearWood",
				'X',
				"ingotSteel"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.gears, 1, 4), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearWood",
				'X',
				"ingotToolSteel"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.gears, 1, 2), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearStone",
				'X',
				"ingotNickelsilver"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.gears, 1, 3), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearStone",
				'X',
				"ingotSteel"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.gears, 1, 4), new Object[] {
				" X ",
				"XYX",
				" X ",
				'Y',
				"gearStone",
				'X',
				"ingotToolSteel"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 4), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				"dustChrysotile",
				'Y',
				"toolSpindle"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 5), new Object[] {
				" X ",
				"X X",
				" X ",
				'X',
				new ItemStack(MainInit.clothes, 1, 4)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 7), new Object[] {
				" X ",
				"X X",
				" X ",
				'X',
				new ItemStack(MainInit.clothes, 1, 6)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 10), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				"bunchVine",
				'Y',
				"toolSpindle"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.clothes, 1, 11), new Object[] {
				" X ",
				"X X",
				" X ",
				'X',
				new ItemStack(MainInit.clothes, 1, 10)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.stoneYagen, 1, 0), new Object[] {
				" X ",
				"XYX",
				"XXX",
				'X',
				"cobblestone",
				'Y',
				"gearWood"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.brassYagen, 1, 0), new Object[] {
				" X ",
				"XYX",
				"XXX",
				'X',
				"ingotBrass",
				'Y',
				"gearWood"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.handSpindle, 1, 0), new Object[] {
				"X",
				"Y",
				"X",
				'X',
				"stickWood",
				'Y',
				"gearWood"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.handNet, 1, 0), new Object[] {
				" YY",
				" YY",
				"XXX",
				'X',
				"stickWood",
				'Y',
				"string"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(DCInit.climate_checker, 1, 0), new Object[] {
				" Z ",
				"XYX",
				" Z ",
				'X',
				"ingotGold",
				'Y',
				"dustRedstone",
				'Z',
				"gemChalcedony"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.stevenson_screen, 1, 0), new Object[] {
				"XZX",
				"ZYZ",
				"XZX",
				'X',
				"plankWood",
				'Y',
				new ItemStack(DCInit.climate_checker),
				'Z',
				"dyeWhite"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.thermometer, 1, 0), new Object[] {
				"X",
				"Y",
				"Z",
				'X',
				"bucketWater",
				'Y',
				new ItemStack(DCInit.climate_checker),
				'Z',
				"blockGlass"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.windvane, 1, 0), new Object[] {
				" X ",
				"XYX",
				" X ",
				'X',
				"ingotBrass",
				'Y',
				new ItemStack(DCInit.climate_checker)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.windvane, 1, 0), new Object[] {
				" X ",
				"XYX",
				" X ",
				'X',
				"ingotBronze",
				'Y',
				new ItemStack(DCInit.climate_checker)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.chamber, 1, 0), new Object[] {
				"ZXZ",
				"XYX",
				"ZXZ",
				'Y',
				new ItemStack(Blocks.FURNACE, 1, 0),
				'X',
				"dustRedstone",
				'Z',
				"ingotBrass"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.chamber, 1, 0), new Object[] {
				"ZXZ",
				"XYX",
				"ZXZ",
				'Y',
				new ItemStack(Blocks.FURNACE, 1, 0),
				'X',
				"dustRedstone",
				'Z',
				"ingotBronze"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.shitirin, 1, 0), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'Y',
				new ItemStack(Blocks.FURNACE, 1, 0),
				'X',
				new ItemStack(Items.CLAY_BALL, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.firestand, 1, 0), new Object[] {
				" Y ",
				" X ",
				"X X",
				'Y',
				"logWood",
				'X',
				"ingotIron"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.firestand, 1, 0), new Object[] {
				" Y ",
				" X ",
				"X X",
				'Y',
				"logWood",
				'X',
				"ingotAluminum"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.swedishTorch, 1, 0), new Object[] {
				"logWood",
				new ItemStack(MainInit.tinder, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.fuelStove, 1, 0), new Object[] {
				"XYX",
				"XZX",
				"XWX",
				'X',
				"ingotSteel",
				'Y',
				new ItemStack(Items.FLINT_AND_STEEL, 1, 32767),
				'Z',
				new ItemStack(Blocks.FURNACE, 1, 0),
				'W',
				new ItemStack(Items.BUCKET, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.bellow, 1, 0), new Object[] {
				"XYX",
				"XZX",
				"XWX",
				'X',
				"ingotIron",
				'Y',
				"stickWood",
				'Z',
				"gearWood",
				'W',
				new ItemStack(Blocks.PISTON, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.pail, 1, 0), new Object[] {
				"X X",
				"YXY",
				'X',
				"ingotIron",
				'Y',
				"dustTin"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.igniter, 1, 0), new Object[] {
				"X",
				"Y",
				'X',
				new ItemStack(Items.FLINT_AND_STEEL, 1, 0),
				'Y',
				"gearBrass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.repairPutty, 1, 0), new Object[] {
				new ItemStack(Items.SLIME_BALL, 1, 0),
				"dustIron"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.repairPutty, 1, 1), new Object[] {
				new ItemStack(Items.CLAY_BALL, 1, 0),
				"dustGarnet"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.repairPutty, 1, 1), new Object[] {
				"dustClay",
				"dustGarnet"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.tinder, 1, 0), new Object[] {
				"stickWood",
				"blockTallgrass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.tinder, 1, 0), new Object[] {
				"stickWood",
				"dustPlant"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", 3, new ItemStack(MainInit.tinder, 1, 0), new Object[] {
				"stickWood",
				"dustWood"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", 4, new ItemStack(MainInit.tinder, 1, 0), new Object[] {
				"stickWood",
				"cropCotton"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", 5, new ItemStack(MainInit.tinder, 1, 0), new Object[] {
				"stickWood",
				"feather"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.tinder, 1, 2), new Object[] {
				"plankWood",
				new ItemStack(MainInit.tinder, 1, 0),
				"string"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.colorChanger, 1, 0), new Object[] {
				"XYZ",
				" W ",
				" W ",
				'X',
				"gemChalcedonyRed",
				'Y',
				"gemChalcedonyBlue",
				'Z',
				"gemChalcedonyWhite",
				'W',
				"ingotSteel"
		});

		if (ModuleConfig.machine) {
			DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.scope, 1, 0), new Object[] {
					"ZYZ",
					" X ",
					'X',
					new ItemStack(DCInit.climate_checker, 1, 0),
					'Y',
					new ItemStack(MachineInit.machimeMaterials, 1, 6),
					'Z',
					new ItemStack(MainInit.selenite, 1, 2)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", new ItemStack(MainInit.entityScope, 1, 0), new Object[] {
					"ZYZ",
					" X ",
					'X',
					new ItemStack(MachineInit.torqueChecker, 1, 0),
					'Y',
					new ItemStack(MachineInit.machimeMaterials, 1, 6),
					'Z',
					new ItemStack(MainInit.selenite, 1, 2)
			});
		} else {
			DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.scope, 1, 0), new Object[] {
					"X",
					"Y",
					"Z",
					'X',
					new ItemStack(Blocks.GLASS_PANE, 1, 0),
					'Y',
					new ItemStack(DCInit.climate_checker, 1, 0),
					'Z',
					"ingotSteel"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main", 2, new ItemStack(MainInit.entityScope, 1, 0), new Object[] {
					"X",
					"Y",
					"Z",
					'X',
					"gemMalachite",
					'Y',
					new ItemStack(DCInit.climate_checker, 1, 0),
					'Z',
					"ingotSteel"
			});
		}
	}

}
