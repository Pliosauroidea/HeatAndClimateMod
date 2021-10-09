package defeatedcrow.hac.main.recipes;

import defeatedcrow.hac.api.module.HaCModule;
import defeatedcrow.hac.core.DCRecipe;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.main.MainInit;
import defeatedcrow.hac.main.config.ModuleConfig;
import defeatedcrow.hac.main.util.MainUtil;
import defeatedcrow.hac.main.util.RecipeResourcesMain;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class LoadingBuildingRecipe {

	public static void add(RecipeResourcesMain res) {
		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.selenite, 8, 1), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(MainInit.selenite, 1, 0),
				'Y',
				new ItemStack(Items.GLOWSTONE_DUST)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.selenite, 8, 2), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(MainInit.selenite, 1, 0),
				'Y',
				"dustSilver"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.selenite, 8,
				2), new Object[] {
						"XXX",
						"XYX",
						"XXX",
						'X',
						new ItemStack(MainInit.selenite, 1, 0),
						'Y',
						"dustLead"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsGlass, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.selenite, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsGlass, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.selenite, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsGypsum, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 3)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsGypsum, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 3)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsMarble, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 6)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsMarble, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 6)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsSerpentine, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 9)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsSerpentine, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 9)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsBedrock, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 12)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsBedrock, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 12)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsDirtbrick, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.builds, 1, 7)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsDirtbrick, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.builds, 1, 7)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsSkarn, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.skarnBlock, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsSkarn, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.skarnBlock, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.stairsGreisen, 4,
				0), new Object[] {
						"X  ",
						"XX ",
						"XXX",
						'X',
						new ItemStack(MainInit.skarnBlock, 1, 2)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.stairsGreisen, 4,
				0), new Object[] {
						"  X",
						" XX",
						"XXX",
						'X',
						new ItemStack(MainInit.skarnBlock, 1, 2)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 1), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.selenite, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 0), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 3)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 2), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 6)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 3), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 9)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 4), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 12)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 5), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.builds, 1, 7)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 6), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.skarnBlock, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab, 6, 7), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.skarnBlock, 1, 2)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab2, 6, 0), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab2, 6, 1), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 1)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab2, 6, 2), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 2)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab2, 6, 3), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.chalLamp, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab2, 6, 4), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.chalLamp, 1, 1)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab2, 6, 5), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.chalLamp, 1, 2)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab2, 6, 6), new Object[] {
				"XXX",
				'X',
				new ItemStack(MainInit.chalLamp, 1, 3)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.fenceGypsum, 6,
				0), new Object[] {
						"XXX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 3)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.fenceMarble, 6,
				0), new Object[] {
						"XXX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 6)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.fenceSerpentine, 6,
				0), new Object[] {
						"XXX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 9)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.fenceBedrock, 6,
				0), new Object[] {
						"XXX",
						"XXX",
						'X',
						new ItemStack(MainInit.gemBlock, 1, 12)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 0), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 3)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 1), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 6)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 2), new Object[] {
				"XX",
				"XX",
				'X',
				"oreLime"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 3), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 12)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 4), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.gemBlock, 1, 5)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 5), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.skarnBlock, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 6), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.skarnBlock, 1, 1)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.bricks, 4, 7), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.skarnBlock, 1, 2)
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 1, 0), new Object[] {
				"dustLime",
				"dustLime",
				new ItemStack(Blocks.GRAVEL)
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 1, 1), new Object[] {
				"dyeRed",
				new ItemStack(MainInit.builds, 1, 0),
				"blockGlass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 1, 2), new Object[] {
				"dyeBlue",
				new ItemStack(MainInit.builds, 1, 0),
				"blockGlass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 1, 3), new Object[] {
				"dyeYellow",
				new ItemStack(MainInit.builds, 1, 0),
				"blockGlass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 1, 4), new Object[] {
				"dyeBlack",
				new ItemStack(MainInit.builds, 1, 0),
				"blockGlass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.builds, 1,
				1), new Object[] {
						"dyeRed",
						new ItemStack(MainInit.builds, 1, 0),
						"dustBorax"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.builds, 1,
				2), new Object[] {
						"dyeBlue",
						new ItemStack(MainInit.builds, 1, 0),
						"dustBorax"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.builds, 1,
				3), new Object[] {
						"dyeYellow",
						new ItemStack(MainInit.builds, 1, 0),
						"dustBorax"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.builds, 1,
				4), new Object[] {
						"dyeBlack",
						new ItemStack(MainInit.builds, 1, 0),
						"dustBorax"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 3, new ItemStack(MainInit.builds, 1,
				1), new Object[] {
						"dyeRed",
						new ItemStack(Blocks.CONCRETE, 1, 32767),
						"blockGlass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 3, new ItemStack(MainInit.builds, 1,
				2), new Object[] {
						"dyeBlue",
						new ItemStack(Blocks.CONCRETE, 1, 32767),
						"blockGlass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 3, new ItemStack(MainInit.builds, 1,
				3), new Object[] {
						"dyeYellow",
						new ItemStack(Blocks.CONCRETE, 1, 32767),
						"blockGlass"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 3, new ItemStack(MainInit.builds, 1,
				4), new Object[] {
						"dyeBlack",
						new ItemStack(Blocks.CONCRETE, 1, 32767),
						"blockGlass"
		});

		if (ModuleConfig.machine) {
			DCRecipe.jsonShapelessRecipe(HaCModule.MACHINE, "main_build", new ItemStack(MainInit.builds, 1,
					5), new Object[] {
							"gravel",
							new ItemStack(MachineInit.reagent, 1, 0)
			});
		}

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.builds, 1,
				5), new Object[] {
						"gravel",
						"slimeball",
						"dyeBlack"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 1, 6), new Object[] {
				"dustLime",
				"blockTallgrass",
				"cropSeaweed"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.builds, 1,
				6), new Object[] {
						"dustLime",
						"feedStraw",
						"cropSeaweed"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 3, new ItemStack(MainInit.builds, 1,
				6), new Object[] {
						"dustLime",
						"dustBagasse",
						"cropSeaweed"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 4, new ItemStack(MainInit.builds, 1,
				6), new Object[] {
						"dustLime",
						"dustPlant",
						"cropSeaweed"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 4, 7), new Object[] {
				"XX",
				"XX",
				'X',
				new ItemStack(MainInit.dustBlock_2, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 2, 8), new Object[] {
				"XY",
				"YX",
				'X',
				"stoneDiorite",
				'Y',
				"gemFlint"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 2, 9), new Object[] {
				"XY",
				"YX",
				'X',
				"stoneAndesite",
				'Y',
				"gemFlint"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 2, 10), new Object[] {
				"XY",
				"YX",
				'X',
				"stoneGranite",
				'Y',
				"gemFlint"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.builds, 1, 11), new Object[] {
				"XX",
				"XX",
				'X',
				"bunchVine"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.dustBlock_2, 1,
				0), new Object[] {
						new ItemStack(MainInit.builds, 1, 7)
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.gemBlock, 1,
				3), new Object[] {
						new ItemStack(MainInit.bricks, 1, 0)
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.gemBlock, 1,
				6), new Object[] {
						new ItemStack(MainInit.bricks, 1, 1)
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.layerNew, 1,
				1), new Object[] {
						new ItemStack(MainInit.bricks, 1, 2)
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.gemBlock, 1,
				12), new Object[] {
						new ItemStack(MainInit.bricks, 1, 3)
		});

		for (int i = 0; i < 16; i++) {
			DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.clayBricks, 4,
					i), new Object[] {
							"XX",
							"XX",
							'X',
							new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, i)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(Blocks.STAINED_HARDENED_CLAY, 4,
					i), new Object[] {
							"XX",
							"XX",
							'X',
							new ItemStack(MainInit.clayBricks, 1, i)
			});
		}

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab3, 3, 0), new Object[] {
				"XXX",
				'X',
				"gemSlate"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.roofSlate, 3, 0), new Object[] {
				"  X",
				" X ",
				"X  ",
				'X',
				"gemSlate"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.roofSlate, 3,
				0), new Object[] {
						"X  ",
						" X ",
						"  X",
						'X',
						"gemSlate"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab3, 8, 1), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(MainInit.halfSlab3, 1, 0),
				'Y',
				"dyeRed"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab3, 8, 2), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(MainInit.halfSlab3, 1, 0),
				'Y',
				"dyeGreen"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.halfSlab3, 8, 3), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(MainInit.halfSlab3, 1, 0),
				'Y',
				"dyeBrown"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.roofSlateRed, 8,
				0), new Object[] {
						"XXX",
						"XYX",
						"XXX",
						'X',
						new ItemStack(MainInit.roofSlate, 1, 0),
						'Y',
						"dyeRed"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.roofSlateGreen, 8,
				0), new Object[] {
						"XXX",
						"XYX",
						"XXX",
						'X',
						new ItemStack(MainInit.roofSlate, 1, 0),
						'Y',
						"dyeGreen"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.roofSlateBrown, 8,
				0), new Object[] {
						"XXX",
						"XYX",
						"XXX",
						'X',
						new ItemStack(MainInit.roofSlate, 1, 0),
						'Y',
						"dyeBrown"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.strawBlock, 1,
				0), new Object[] {
						"XX",
						"XX",
						'X',
						"feedHay"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.strawBlock, 1,
				0), new Object[] {
						"XX",
						"XX",
						'X',
						"feedStraw"
		});

		DCRecipe.jsonShapelessRecipe(HaCModule.CORE, "main_build", 3, new ItemStack(MainInit.strawBlock, 1,
				0), new Object[] {
						new ItemStack(MainInit.roofStraw, 1, 0)
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.roofStraw, 3,
				0), new Object[] {
						"  X",
						" X ",
						"X  ",
						'X',
						"blockStraw"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.roofStraw, 3,
				0), new Object[] {
						"X  ",
						" X ",
						"  X",
						'X',
						"blockStraw"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.scaffold, 16, 0), new Object[] {
				"YXY",
				"Y Y",
				"YXY",
				'X',
				"plankWood",
				'Y',
				"stickWood"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.scaffold, 16,
				0), new Object[] {
						"YXY",
						"Y Y",
						"YXY",
						'X',
						"plankWood",
						'Y',
						"treeSapling"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.pressureChal, 1,
				0), new Object[] {
						"XX",
						'X',
						"gemChalcedony"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", new ItemStack(MainInit.pressureOlivine, 1,
				0), new Object[] {
						"XX",
						'X',
						"gemEmerald"
		});

		DCRecipe.jsonShapedRecipe(HaCModule.CORE, "main_build", 2, new ItemStack(MainInit.pressureOlivine, 1,
				0), new Object[] {
						"XX",
						'X',
						"gemPeridot"
		});

	}

	public static void advanced(RecipeResourcesMain res) {
		if (ModuleConfig.build_advanced) {

			Object[] chal = new Object[] {
					new ItemStack(MainInit.gemBlock, 1, 0),
					new ItemStack(MainInit.gemBlock, 1, 1),
					new ItemStack(MainInit.gemBlock, 1, 2)
			};
			for (int i = 0; i < 3; i++) {
				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
						i), new Object[] {
								"X",
								"Y",
								'X',
								chal[i],
								'Y',
								"dustRedstone"
				});

				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
						4 + i), new Object[] {
								" X ",
								"XYX",
								" X ",
								'X',
								"blockGlass",
								'Y',
								new ItemStack(MainInit.chalLamp, 1, i)
				});

				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
						8 + i), new Object[] {
								"Z",
								"Y",
								'Y',
								"ingotCopper",
								'Z',
								new ItemStack(MainInit.chalLamp, 1, i)
				});

				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
						12 + i), new Object[] {
								"Y",
								"Z",
								'Y',
								"ingotCopper",
								'Z',
								new ItemStack(MainInit.chalLamp, 1, i)
				});
			}

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
					3), new Object[] {
							" X ",
							"XYX",
							" X ",
							'X',
							"plankWood",
							'Y',
							new ItemStack(MainInit.chalLamp, 1, 2)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
					7), new Object[] {
							" X ",
							"XYX",
							" X ",
							'X',
							"blockGlass",
							'Y',
							new ItemStack(MainInit.chalLamp, 1, 3)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
					11), new Object[] {
							"X",
							"Y",
							'X',
							new ItemStack(MainInit.chalLamp, 1, 3),
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chalLamp, 1,
					15), new Object[] {
							"Y",
							"X",
							'X',
							new ItemStack(MainInit.chalLamp, 1, 3),
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallLamp, 1,
					0), new Object[] {
							"YX",
							'X',
							new ItemStack(MainInit.chalLamp, 1, 0),
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallLamp, 1,
					1), new Object[] {
							"YX",
							'X',
							new ItemStack(MainInit.chalLamp, 1, 1),
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallLamp, 1,
					2), new Object[] {
							"YX",
							'X',
							new ItemStack(MainInit.chalLamp, 1, 2),
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallLamp, 1,
					3), new Object[] {
							"YX",
							'X',
							new ItemStack(MainInit.chalLamp, 1, 3),
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chandelierGypsum,
					1, 0), new Object[] {
							" Z ",
							"XYX",
							" X ",
							'X',
							"gemGypsum",
							'Y',
							new ItemStack(MainInit.chalLamp, 1, 2),
							'Z',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chandelierGypsum,
					1, 1), new Object[] {
							" Z ",
							"XYX",
							" X ",
							'X',
							"gemSalt",
							'Y',
							new ItemStack(MainInit.chalLamp, 1, 2),
							'Z',
							"ingotIron"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chandelierGypsum,
					1, 2), new Object[] {
							" Z ",
							"XYX",
							" X ",
							'X',
							"gemChalcedony",
							'Y',
							new ItemStack(MainInit.chalLamp, 1, 2),
							'Z',
							"ingotSteel"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.tableMarble, 1,
					0), new Object[] {
							"XXX",
							" X ",
							" X ",
							'X',
							"blockMarble"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.tableGypsum, 1,
					0), new Object[] {
							"XXX",
							" X ",
							" X ",
							'X',
							new ItemStack(MainInit.gemBlock, 1, 3)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.tableWood, 1,
					0), new Object[] {
							"XXX",
							" X ",
							" X ",
							'X',
							new ItemStack(Blocks.PLANKS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.tableDark, 1,
					0), new Object[] {
							"XXX",
							" X ",
							" X ",
							'X',
							new ItemStack(Blocks.PLANKS, 1, 5)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.squaretableWood, 1,
					0), new Object[] {
							"XXX",
							"X X",
							'X',
							"plankWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.squaretableMarble,
					1, 0), new Object[] {
							"XXX",
							"X X",
							'X',
							"blockMarble"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.squaretableSkarn,
					1, 0), new Object[] {
							"XXX",
							"X X",
							'X',
							"blockSkarn"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.squaretableGreisen,
					1, 0), new Object[] {
							"XXX",
							"X X",
							'X',
							"blockGreisen"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.squaretableChecker,
					1, 0), new Object[] {
							"XXX",
							"X X",
							'X',
							"blockGypsum"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.squaretableBlack,
					1, 0), new Object[] {
							"XXX",
							"X X",
							'X',
							new ItemStack(MainInit.gemBlock, 1, 12)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.squaretableRattan,
					1, 0), new Object[] {
							"XYX",
							"X X",
							'X',
							"bunchVine",
							'Y',
							"blockGlass"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.carpetRed, 1,
					0), new Object[] {
							"X",
							"Y",
							'X',
							new ItemStack(Blocks.CARPET, 1, 14),
							'Y',
							"plankWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.carpetWhite, 1,
					0), new Object[] {
							"X",
							"Y",
							'X',
							new ItemStack(Blocks.CARPET, 1, 0),
							'Y',
							"plankWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.carpetGray, 1,
					0), new Object[] {
							"X",
							"Y",
							'X',
							new ItemStack(Blocks.CARPET, 1, 15),
							'Y',
							"plankWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.carpetLinen, 1,
					0), new Object[] {
							"X",
							"Y",
							'X',
							new ItemStack(Blocks.CARPET, 1, 4),
							'Y',
							"plankWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.carpetRed, 1,
					0), new Object[] {
							"Z",
							"X",
							"Y",
							'X',
							"itemCloth",
							'Y',
							"plankWood",
							'Z',
							"dyeRed"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.carpetWhite, 1,
					0), new Object[] {
							"Z",
							"X",
							"Y",
							'X',
							"itemCloth",
							'Y',
							"plankWood",
							'Z',
							"dyeWhite"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.carpetGray, 1,
					0), new Object[] {
							"Z",
							"X",
							"Y",
							'X',
							"itemCloth",
							'Y',
							"plankWood",
							'Z',
							"dyeBlack"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.carpetLinen, 1,
					0), new Object[] {
							"Z",
							"X",
							"Y",
							'X',
							"itemCloth",
							'Y',
							"plankWood",
							'Z',
							"dyeYellow"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.carpetTatami, 1,
					0), new Object[] {
							"Z",
							"X",
							"Y",
							'X',
							"blockStraw",
							'Y',
							"plankWood",
							'Z',
							"feedHay"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.carpetTatami, 1,
					0), new Object[] {
							"Z",
							"X",
							"Y",
							'X',
							"blockStraw",
							'Y',
							"plankWood",
							'Z',
							"feedStraw"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.sofaBlack, 1,
					0), new Object[] {
							" X ",
							"YYY",
							"ZZZ",
							'X',
							"dyeBlack",
							'Y',
							"itemCloth",
							'Z',
							new ItemStack(Blocks.WOOL, 1, 32767)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.sofaRed, 1,
					0), new Object[] {
							" X ",
							"YYY",
							"ZZZ",
							'X',
							"dyeRed",
							'Y',
							"itemCloth",
							'Z',
							new ItemStack(Blocks.WOOL, 1, 32767)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.stoolBlack, 1,
					0), new Object[] {
							"X",
							"Y",
							"Z",
							'X',
							"dyeBlack",
							'Y',
							"itemCloth",
							'Z',
							"blockMarble"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.stoolRed, 1,
					0), new Object[] {
							"X",
							"Y",
							"Z",
							'X',
							"dyeRed",
							'Y',
							"itemCloth",
							'Z',
							"plankWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.stoolRattan, 1,
					0), new Object[] {
							"X",
							"Y",
							'X',
							"itemCloth",
							'Y',
							"bunchVine"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chairWood, 1,
					0), new Object[] {
							"  X",
							"XYX",
							"X X",
							'X',
							"plankWood",
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chairMarble, 1,
					0), new Object[] {
							"  X",
							"XYX",
							"X X",
							'X',
							"blockMarble",
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chairSkarn, 1,
					0), new Object[] {
							"  X",
							"XYX",
							"X X",
							'X',
							"blockSkarn",
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chairGreisen, 1,
					0), new Object[] {
							"  X",
							"XYX",
							"X X",
							'X',
							"blockGreisen",
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chairChecker, 1,
					0), new Object[] {
							"  X",
							"XYX",
							"X X",
							'X',
							"blockGypsum",
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chairBlack, 1,
					0), new Object[] {
							"  X",
							"XYX",
							"X X",
							'X',
							new ItemStack(MainInit.gemBlock, 1, 12),
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chairRattan, 1,
					0), new Object[] {
							"  X",
							"XYX",
							"X X",
							'X',
							"bunchVine",
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestMarble, 1,
					0), new Object[] {
							"XXX",
							" Y ",
							"XXX",
							'X',
							"blockMarble",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestSkarn, 1,
					0), new Object[] {
							"XXX",
							" Y ",
							"XXX",
							'X',
							"blockSkarn",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestGreisen, 1,
					0), new Object[] {
							"XXX",
							" Y ",
							"XXX",
							'X',
							"blockGreisen",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestWood, 1,
					0), new Object[] {
							"XXX",
							" Y ",
							"XXX",
							'X',
							"plankWood",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestChecker, 1,
					0), new Object[] {
							"XXX",
							" Y ",
							"XXX",
							'X',
							"blockGypsum",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestBlack, 1,
					0), new Object[] {
							"XXX",
							" Y ",
							"XXX",
							'X',
							new ItemStack(MainInit.gemBlock, 1, 12),
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestRattan, 1,
					0), new Object[] {
							"XXX",
							" Y ",
							"XXX",
							'X',
							"bunchVine",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallshelfMarble, 1,
					0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							"blockMarble",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallshelfSkarn, 1,
					0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							"blockSkarn",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallshelfGreisen,
					1, 0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							"blockGreisen",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallshelfWood, 1,
					0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							"plankWood",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallshelfChecker,
					1, 0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							"blockGypsum",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallshelfBlack, 1,
					0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							new ItemStack(MainInit.gemBlock, 1, 12),
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.wallshelfRattan, 1,
					0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							"bunchVine",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.displayShelf, 1,
					0), new Object[] {
							" Y ",
							"XXX",
							'X',
							"plankWood",
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.displayStand, 1,
					0), new Object[] {
							" Y ",
							"XXX",
							'X',
							"plankWood",
							'Y',
							"ingotTin"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.awning, 1,
					0), new Object[] {
							"XXX",
							"Y Y",
							'X',
							"plankWood",
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.awning, 1,
					1), new Object[] {
							"XXX",
							"Y Y",
							'X',
							"ingotAluminum",
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.awning, 1,
					1), new Object[] {
							"XXX",
							"Y Y",
							'X',
							"ingotIron",
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.awning, 1,
					2), new Object[] {
							"XXX",
							"Y Y",
							'X',
							"itemLinenCloth",
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.awning, 1,
					3), new Object[] {
							"XXX",
							"Y Y",
							'X',
							"itemCottonCloth",
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chain, 1,
					0), new Object[] {
							"X",
							"Y",
							"Y",
							'X',
							"string",
							'Y',
							"ingotCopper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chain, 1,
					1), new Object[] {
							"X",
							"Y",
							"Y",
							'X',
							"string",
							'Y',
							"ingotSteel"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.flowerPot, 1,
					0), new Object[] {
							" X ",
							"X X",
							"XXX",
							'X',
							"gemChalcedony"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.flowerPot, 1,
					1), new Object[] {
							" X ",
							"X X",
							"XXX",
							'X',
							new ItemStack(Blocks.HARDENED_CLAY, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemDoorMarble, 2,
					0), new Object[] {
							"XX",
							"XX",
							"XX",
							'X',
							"blockMarble"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemDoorGreisen, 2,
					0), new Object[] {
							"XX",
							"XX",
							"XX",
							'X',
							"blockGreisen"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemDoorGypsum, 2,
					0), new Object[] {
							"XX",
							"XX",
							"XX",
							'X',
							"blockGypsum"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemDoorSteel, 2,
					0), new Object[] {
							"XX",
							"YY",
							"XX",
							'X',
							"ingotSteel",
							'Y',
							new ItemStack(Blocks.IRON_BARS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.doorHikido, 2,
					0), new Object[] {
							"XXX",
							"YYY",
							"XXX",
							'X',
							"stickWood",
							'Y',
							"paper"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.realtimeClock, 1,
					0), new Object[] {
							"X",
							"Y",
							'X',
							"gemSapphire",
							'Y',
							new ItemStack(Items.CLOCK, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.realtimeClock_L, 1,
					0), new Object[] {
							" X ",
							"XYX",
							" X ",
							'X',
							"ingotSteel",
							'Y',
							new ItemStack(MainInit.realtimeClock, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.mcClock_L, 1,
					0), new Object[] {
							" X ",
							"XYX",
							" X ",
							'X',
							"ingotGold",
							'Y',
							new ItemStack(MainInit.realtimeClock, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.curtainWhite, 1,
					0), new Object[] {
							"XX",
							"YY",
							"YY",
							'X',
							"stickWood",
							'Y',
							"itemCloth"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(
					MainInit.curtainGray), new Object[] {
							new ItemStack(MainInit.curtainWhite, 1, 0),
							"dyeGray"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(
					MainInit.curtainRed), new Object[] {
							new ItemStack(MainInit.curtainWhite, 1, 0),
							"dyeRed"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(
					MainInit.curtainBlue), new Object[] {
							new ItemStack(MainInit.curtainWhite, 1, 0),
							"dyeBlue"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.windowBlinds, 1,
					0), new Object[] {
							"XX",
							"YY",
							"YY",
							'X',
							"string",
							'Y',
							"ingotAluminum"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.windowWood, 1,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"plankWood",
							'Y',
							"blockGlass"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(
					MainInit.windowWood, 1, 1), new Object[] {
							new ItemStack(MainInit.windowWood, 1, 0),
							"dyeWhite"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestMetal, 1,
					0), new Object[] {
							"XXX",
							"XYX",
							"XXX",
							'X',
							"ingotSteel",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestMagnet, 1,
					0), new Object[] {
							"XXX",
							"XYX",
							"XXX",
							'X',
							"ingotMagnet",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.chestVillage, 1,
					0), new Object[] {
							"XZX",
							"XYX",
							"XXX",
							'X',
							"ingotGold",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0),
							'Z',
							"gemEmerald"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.chestVillage, 1,
					0), new Object[] {
							"XZX",
							"XYX",
							"XXX",
							'X',
							"ingotGold",
							'Y',
							new ItemStack(Blocks.CHEST, 1, 0),
							'Z',
							"gemPeridot"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.plate, 2,
					0), new Object[] {
							"X X",
							'X',
							"ingotIron"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.plate, 2,
					1), new Object[] {
							"X X",
							'X',
							new ItemStack(Blocks.IRON_BARS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.sinkMetal, 1,
					0), new Object[] {
							"X X",
							"XXX",
							'X',
							"ingotNickelsilver"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.sinkMetal, 1,
					0), new Object[] {
							new ItemStack(MainInit.sinkChest, 1, 0)
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.sinkChest, 1,
					0), new Object[] {
							new ItemStack(MainInit.sinkMetal, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.craftingCounter, 1,
					0), new Object[] {
							"XYX",
							" Z ",
							'X',
							"ingotSteel",
							'Y',
							new ItemStack(Blocks.CRAFTING_TABLE),
							'Z',
							new ItemStack(Blocks.CHEST)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.kitchenHood, 1,
					0), new Object[] {
							" Z ",
							"XYX",
							'X',
							"ingotSUS",
							'Y',
							new ItemStack(MainInit.bellow),
							'Z',
							"gearSteel"
			});

			for (int i = 0; i < 16; i++) {
				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.syntheticBlock,
						8, i), new Object[] {
								"XXX",
								"XYX",
								"XXX",
								'X',
								new ItemStack(MainInit.syntheticBlock, 1, 32767),
								'Y',
								MainUtil.DYES[i]
				});
			}

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceAluminium, 6,
					0), new Object[] {
							"XXX",
							"XXX",
							'X',
							"ingotAluminium"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.fenceAluminium,
					6, 0), new Object[] {
							"XXX",
							"XXX",
							'X',
							"ingotAluminum"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceNet, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotAluminium",
							'Y',
							new ItemStack(Blocks.IRON_BARS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceGlass, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotAluminium",
							'Y',
							new ItemStack(Blocks.GLASS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.fenceGlass, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotAluminium",
							'Y',
							"blockGlass"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.fenceNet, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotAluminum",
							'Y',
							new ItemStack(Blocks.IRON_BARS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 3, new ItemStack(MainInit.fenceGlass, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotAluminum",
							'Y',
							new ItemStack(Blocks.GLASS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 4, new ItemStack(MainInit.fenceGlass, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotAluminum",
							'Y',
							"blockGlass"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceRattan, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"stickWood",
							'Y',
							"bunchVine"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceLadder, 6,
					0), new Object[] {
							"X X",
							"XXX",
							"X X",
							'X',
							"ingotAluminium"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.fenceLadder, 6,
					0), new Object[] {
							"X X",
							"XXX",
							"X X",
							'X',
							"ingotAluminum"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.pillarSteel, 6,
					0), new Object[] {
							"XX",
							"YY",
							"XX",
							'X',
							"ingotSteel",
							'Y',
							"ingotIron"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceSteel, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotSteel",
							'Y',
							"ingotIron"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceNetSteel, 6,
					0), new Object[] {
							"XYX",
							"XYX",
							'X',
							"ingotSteel",
							'Y',
							new ItemStack(Blocks.IRON_BARS, 1, 0)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.fenceLadderSteel,
					6, 0), new Object[] {
							"X X",
							"XYX",
							"X X",
							'X',
							"ingotSteel",
							'Y',
							"ingotIron"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.hedgeSpring, 1,
					0), new Object[] {
							"XXX",
							"YYY",
							'X',
							new ItemStack(Blocks.SAPLING, 1, 0),
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.hedgeSummer, 1,
					0), new Object[] {
							"XXX",
							"YYY",
							'X',
							new ItemStack(Blocks.SAPLING, 1, 5),
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.hedgeAutumn, 1,
					0), new Object[] {
							"XXX",
							"YYY",
							'X',
							new ItemStack(Blocks.SAPLING, 1, 2),
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.hedgeWinter, 1,
					0), new Object[] {
							"XXX",
							"YYY",
							'X',
							new ItemStack(Blocks.SAPLING, 1, 1),
							'Y',
							"stickWood"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.lampCarbide, 1,
					0), new Object[] {
							"XXX",
							"YZY",
							"XXX",
							'X',
							"ingotBrass",
							'Y',
							"blockGlass",
							'Z',
							"gemCarbide"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.lampGas, 1,
					0), new Object[] {
							"XXX",
							"YZY",
							"XXX",
							'X',
							"ingotSteel",
							'Y',
							"blockGlass",
							'Z',
							"gemCarbide"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.desiccant, 1,
					0), new Object[] {
							new ItemStack(Items.PAPER, 1, 0),
							"dustLime"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(Items.DYE, 1,
					15), new Object[] {
							new ItemStack(MainInit.desiccant, 1, 3)
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.freezepack, 1,
					0), new Object[] {
							new ItemStack(Items.PAPER, 1, 0),
							"dustAmmoniumNitrate",
							"bucketWater"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(Items.DYE, 1,
					15), new Object[] {
							new ItemStack(MainInit.freezepack, 1, 3)
			});

			if (ModuleConfig.food) {
				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.oilLamp, 1,
						0), new Object[] {
								" X ",
								"XZX",
								" Y ",
								'X',
								"blockGlass",
								'Y',
								"plankWood",
								'Z',
								"dropFuel"
				});

				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.oilLamp, 1,
						1), new Object[] {
								" X ",
								"XZX",
								" Y ",
								'X',
								"blockGlass",
								'Y',
								"ingotGold",
								'Z',
								"dropFuel"
				});

				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.oilLamp, 1,
						2), new Object[] {
								" X ",
								"XZX",
								" Y ",
								'X',
								"blockGlass",
								'Y',
								"gemChalcedony",
								'Z',
								"dropFuel"
				});

				DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.oilLamp, 1,
						3), new Object[] {
								" X ",
								"XZX",
								" Y ",
								'X',
								"blockGlass",
								'Y',
								"blockSerpentine",
								'Z',
								"dropFuel"
				});

			}

			for (int i = 0; i < 16; i++) {
				DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.linoleum, 4,
						i), new Object[] {
								"plankWood",
								"dustPlant",
								"foodOil",
								"dustLime",
								MainUtil.DYES[15 - i]
				});
			}

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.cushionGray, 1,
					0), new Object[] {
							" X ",
							"YYY",
							" X ",
							'X',
							"itemCloth",
							'Y',
							new ItemStack(Blocks.WOOL, 1, 32767)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", 2, new ItemStack(MainInit.cushionGray, 1,
					0), new Object[] {
							" X ",
							"YYY",
							" X ",
							'X',
							"itemCloth",
							'Y',
							"cropCotton"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.cushionGray, 1,
					1), new Object[] {
							new ItemStack(MainInit.cushionGray, 1, 0),
							"dyeBrown"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.cushionGray, 1,
					2), new Object[] {
							"W",
							"Y",
							"X",
							'X',
							"itemCloth",
							'Y',
							"cropCotton",
							'W',
							"dyeRed"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.cushionGray, 1,
					3), new Object[] {
							"W",
							"Y",
							"X",
							'X',
							"itemCloth",
							'Y',
							"cropCotton",
							'W',
							"dyeBlue"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.cushionGray, 1,
					4), new Object[] {
							"YY",
							"XX",
							'X',
							"cropCotton",
							'Y',
							"feedStraw"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemBed, 1,
					0), new Object[] {
							"XXX",
							"YYY",
							'X',
							"itemCloth",
							'Y',
							new ItemStack(Blocks.IRON_BARS)
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemBed, 1,
					1), new Object[] {
							"XXX",
							"YYY",
							'X',
							"itemCloth",
							'Y',
							"blockMarble"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemBed, 1,
					2), new Object[] {
							"XXX",
							"YYY",
							'X',
							"itemCloth",
							'Y',
							"bunchVine"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemBed, 1,
					3), new Object[] {
							"XXX",
							"YYY",
							'X',
							"itemCloth",
							'Y',
							"cropCotton"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.itemBed, 1,
					4), new Object[] {
							"XXX",
							"YZY",
							'X',
							"itemCloth",
							'Y',
							"stickWood",
							'Z',
							"string"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.flowerVase, 1,
					0), new Object[] {
							"XYX",
							"XXX",
							'X',
							"ingotBrick",
							'Y',
							"dirt"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.flowerVase, 1,
					1), new Object[] {
							" Z ",
							"XYX",
							"XXX",
							'X',
							"itemClay",
							'Y',
							"bucketWater",
							'Z',
							"dustAsh"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.flowerVase, 1,
					2), new Object[] {
							" Z ",
							"XYX",
							"XXX",
							'X',
							"itemClay",
							'Y',
							"bucketWater",
							'Z',
							"dyeBlue"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.flowerVase, 1,
					3), new Object[] {
							" Z ",
							"XYX",
							"XXX",
							'X',
							"itemClay",
							'Y',
							"bucketWater",
							'Z',
							"dyeRed"
			});

			DCRecipe.jsonShapedRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.flowerVase, 1,
					4), new Object[] {
							" Z ",
							"XYX",
							"XXX",
							'X',
							"itemClay",
							'Y',
							"bucketWater",
							'Z',
							"dyeBlack"
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.planting, 1,
					0), new Object[] {
							"gemMalachite",
							new ItemStack(Blocks.DOUBLE_PLANT, 1, 4)
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.planting, 1,
					1), new Object[] {
							"gemMalachite",
							new ItemStack(Blocks.DOUBLE_PLANT, 1, 5)
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.planting, 1,
					2), new Object[] {
							"gemMalachite",
							new ItemStack(Blocks.DOUBLE_PLANT, 1, 1)
			});

			DCRecipe.jsonShapelessRecipe(HaCModule.BUILD_ADVANCED, "main_build", new ItemStack(MainInit.planting, 1,
					3), new Object[] {
							"gemMalachite",
							new ItemStack(Blocks.DOUBLE_PLANT, 1, 0)
			});

		}
	}

}
