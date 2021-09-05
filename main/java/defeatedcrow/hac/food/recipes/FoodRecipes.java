package defeatedcrow.hac.food.recipes;

import defeatedcrow.hac.api.cultivate.CropAPI;
import defeatedcrow.hac.api.cultivate.IClimateCrop;
import defeatedcrow.hac.core.recipe.ConvertTargetList;
import defeatedcrow.hac.food.FoodInit;
import defeatedcrow.hac.food.item.brewing.DispenseChickInEgg;
import defeatedcrow.hac.main.ClimateMain;
import defeatedcrow.hac.main.api.MainAPIManager;
import defeatedcrow.hac.main.api.brewing.IMicrobe;
import defeatedcrow.hac.main.config.ModuleConfig;
import defeatedcrow.hac.main.util.RecipeResourcesMain;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.GameData;

public class FoodRecipes {

	private static final RecipeResourcesMain res = new RecipeResourcesMain("food");

	public static void load() {
		FoodBasicRecipe.load(res);
		FoodBasicRecipe.loadAdvanced(res);
		FoodBasicRecipe.loadCrops(res);
		FoodClimateRecipe.load();
		if (ModuleConfig.agri) {
			loadCropData();
		}

		GameData.register_impl(new DrinkCustomRecipeDC().setRegistryName(new ResourceLocation(ClimateMain.MOD_ID,
				"drinkcustom")));
		GameData.register_impl(new MediumCraftRecipeDC().setRegistryName(new ResourceLocation(ClimateMain.MOD_ID,
				"medium")));

		if (ModuleConfig.food_advanced) {
			loadMicrobe();
		}
	}

	static void loadCropData() {
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropRice);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropOnion);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropSpinach);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropTomato);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropCoffee);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropCotton);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.leavesLemon);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.leavesOlive);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.leavesTea);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.leavesMorus);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropLotusN);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropHerb);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropSeaweed);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropSoy);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropBean);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropChili);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropGarlic);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropLettuce);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.leavesWalnut);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.leavesDatesCrop);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropWisteria);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropGinger);
		CropAPI.register.addCropData((IClimateCrop) FoodInit.cropGrape);
	}

	public static void loadOres() {
		OreDictionary.registerOre("cropRice", new ItemStack(FoodInit.crops, 1, 0));
		OreDictionary.registerOre("cropOnion", new ItemStack(FoodInit.crops, 1, 1));
		OreDictionary.registerOre("cropSpinach", new ItemStack(FoodInit.crops, 1, 2));
		OreDictionary.registerOre("cropTomato", new ItemStack(FoodInit.crops, 1, 3));
		OreDictionary.registerOre("cropCoffee", new ItemStack(FoodInit.crops, 1, 4));
		OreDictionary.registerOre("cropCotton", new ItemStack(FoodInit.crops, 1, 5));
		OreDictionary.registerOre("cropLemon", new ItemStack(FoodInit.crops, 1, 6));
		OreDictionary.registerOre("cropOlive", new ItemStack(FoodInit.crops, 1, 7));
		OreDictionary.registerOre("cropTea", new ItemStack(FoodInit.crops, 1, 8));
		OreDictionary.registerOre("cropHerb", new ItemStack(FoodInit.crops, 1, 9));
		OreDictionary.registerOre("cropLotusSeed", new ItemStack(FoodInit.crops, 1, 10));
		OreDictionary.registerOre("cropMulberry", new ItemStack(FoodInit.crops, 1, 11));
		OreDictionary.registerOre("cropGreenSoybeans", new ItemStack(FoodInit.crops, 1, 12));
		OreDictionary.registerOre("listAllbean", new ItemStack(FoodInit.crops, 1, 12));
		OreDictionary.registerOre("cropChilipepper", new ItemStack(FoodInit.crops, 1, 13));
		OreDictionary.registerOre("cropGarlic", new ItemStack(FoodInit.crops, 1, 14));
		OreDictionary.registerOre("cropLettuce", new ItemStack(FoodInit.crops, 1, 15));
		OreDictionary.registerOre("cropWalnut", new ItemStack(FoodInit.crops, 1, 16));
		OreDictionary.registerOre("cropDate", new ItemStack(FoodInit.crops, 1, 17));
		OreDictionary.registerOre("bunchVine", new ItemStack(FoodInit.crops, 1, 18));
		OreDictionary.registerOre("cropGinger", new ItemStack(FoodInit.crops, 1, 19));
		OreDictionary.registerOre("cropGrape", new ItemStack(FoodInit.crops, 1, 20));

		OreDictionary.registerOre("listAllgrain", new ItemStack(FoodInit.seeds, 1, 0));
		OreDictionary.registerOre("listAllveggie", new ItemStack(FoodInit.crops, 1, 1));
		OreDictionary.registerOre("listAllveggie", new ItemStack(FoodInit.crops, 1, 2));
		OreDictionary.registerOre("listAllgreenveggie", new ItemStack(FoodInit.crops, 1, 2));
		OreDictionary.registerOre("listAllveggie", new ItemStack(FoodInit.crops, 1, 3));
		OreDictionary.registerOre("listAllveggie", new ItemStack(FoodInit.crops, 1, 10));
		OreDictionary.registerOre("listAllveggie", new ItemStack(FoodInit.crops, 1, 12));
		OreDictionary.registerOre("listAllveggie", new ItemStack(FoodInit.seeds, 1, 6));
		OreDictionary.registerOre("listAllrootveggie", new ItemStack(FoodInit.seeds, 1, 6));
		OreDictionary.registerOre("listAllfruit", new ItemStack(FoodInit.crops, 1, 6));
		OreDictionary.registerOre("listAllfruit", new ItemStack(FoodInit.crops, 1, 11));
		OreDictionary.registerOre("listAllberry", new ItemStack(FoodInit.crops, 1, 11));
		OreDictionary.registerOre("listAllpepper", new ItemStack(FoodInit.crops, 1, 13));
		OreDictionary.registerOre("listAllherb", new ItemStack(FoodInit.crops, 1, 14));
		OreDictionary.registerOre("listAllspice", new ItemStack(FoodInit.crops, 1, 14));
		OreDictionary.registerOre("listAllgreenveggie", new ItemStack(FoodInit.crops, 1, 15));
		OreDictionary.registerOre("listAllnut", new ItemStack(FoodInit.crops, 1, 16));
		OreDictionary.registerOre("listAllfruit", new ItemStack(FoodInit.crops, 1, 17));
		OreDictionary.registerOre("listAllspice", new ItemStack(FoodInit.crops, 1, 19));
		OreDictionary.registerOre("listAllfruit", new ItemStack(FoodInit.crops, 1, 20));
		OreDictionary.registerOre("listAllherb", new ItemStack(FoodInit.crops, 1, 9));
		OreDictionary.registerOre("listAllspice", new ItemStack(FoodInit.crops, 1, 9));

		OreDictionary.registerOre("seedRice", new ItemStack(FoodInit.seeds, 1, 0));
		OreDictionary.registerOre("seedOnion", new ItemStack(FoodInit.seeds, 1, 1));
		OreDictionary.registerOre("seedSpinach", new ItemStack(FoodInit.seeds, 1, 2));
		OreDictionary.registerOre("seedTomato", new ItemStack(FoodInit.seeds, 1, 3));
		OreDictionary.registerOre("seedCoffee", new ItemStack(FoodInit.seeds, 1, 4));
		OreDictionary.registerOre("seedCotton", new ItemStack(FoodInit.seeds, 1, 5));
		OreDictionary.registerOre("seedLotus", new ItemStack(FoodInit.seeds, 1, 6));
		OreDictionary.registerOre("cropLotusRoot", new ItemStack(FoodInit.seeds, 1, 6));
		OreDictionary.registerOre("seedHerb", new ItemStack(FoodInit.seeds, 1, 7));
		OreDictionary.registerOre("cropSeaweed", new ItemStack(FoodInit.seeds, 1, 8));
		OreDictionary.registerOre("cropSoybean", new ItemStack(FoodInit.seeds, 1, 9));
		OreDictionary.registerOre("cropSoy", new ItemStack(FoodInit.seeds, 1, 9));
		OreDictionary.registerOre("listAllbean", new ItemStack(FoodInit.seeds, 1, 9));
		OreDictionary.registerOre("seedSoybean", new ItemStack(FoodInit.seeds, 1, 9));
		OreDictionary.registerOre("cropBean", new ItemStack(FoodInit.seeds, 1, 10));
		OreDictionary.registerOre("seedBean", new ItemStack(FoodInit.seeds, 1, 10));
		OreDictionary.registerOre("listAllbean", new ItemStack(FoodInit.seeds, 1, 10));
		OreDictionary.registerOre("seedChilipepper", new ItemStack(FoodInit.seeds, 1, 11));
		OreDictionary.registerOre("seedGarlic", new ItemStack(FoodInit.seeds, 1, 12));
		OreDictionary.registerOre("seedLettuce", new ItemStack(FoodInit.seeds, 1, 13));
		OreDictionary.registerOre("seedWisteria", new ItemStack(FoodInit.seeds, 1, 14));
		OreDictionary.registerOre("seedGinger", new ItemStack(FoodInit.seeds, 1, 15));
		OreDictionary.registerOre("seedGrape", new ItemStack(FoodInit.seeds, 1, 16));

		OreDictionary.registerOre("listAllseeds", new ItemStack(FoodInit.seeds, 1, 1));
		OreDictionary.registerOre("listAllseeds", new ItemStack(FoodInit.seeds, 1, 2));
		OreDictionary.registerOre("listAllseeds", new ItemStack(FoodInit.seeds, 1, 3));
		OreDictionary.registerOre("listAllseeds", new ItemStack(FoodInit.seeds, 1, 7));
		OreDictionary.registerOre("listAllseeds", new ItemStack(FoodInit.seeds, 1, 11));
		OreDictionary.registerOre("listAllseeds", new ItemStack(FoodInit.seeds, 1, 13));

		OreDictionary.registerOre("saplingLemon", new ItemStack(FoodInit.saplings, 1, 0));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.saplings, 1, 0));
		OreDictionary.registerOre("saplingOlive", new ItemStack(FoodInit.saplings, 1, 1));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.saplings, 1, 1));
		OreDictionary.registerOre("saplingTea", new ItemStack(FoodInit.saplings, 1, 2));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.saplings, 1, 2));
		OreDictionary.registerOre("saplingMorus", new ItemStack(FoodInit.saplings, 1, 3));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.saplings, 1, 3));
		OreDictionary.registerOre("saplingWalnut", new ItemStack(FoodInit.saplings2, 1, 0));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.saplings2, 1, 0));
		OreDictionary.registerOre("saplingDate", new ItemStack(FoodInit.saplings2, 1, 1));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.saplings2, 1, 1));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.cropWisteria, 1, 0));
		OreDictionary.registerOre("saplingWisteria", new ItemStack(FoodInit.cropWisteria, 1, 32767));
		OreDictionary.registerOre("treeSapling", new ItemStack(FoodInit.cropWisteria, 1, 32767));
		if (ModuleConfig.lotus) {
			OreDictionary.registerOre("petalLotus", new ItemStack(FoodInit.petals, 1, 0));
			OreDictionary.registerOre("petalBlackLotus", new ItemStack(FoodInit.petals, 1, 1));
		}

		OreDictionary.registerOre("bucketWater", new ItemStack(FoodInit.paperPack, 1, 1));
		OreDictionary.registerOre("listAllwater", new ItemStack(FoodInit.paperPack, 1, 1));
		OreDictionary.registerOre("bucketMilk", new ItemStack(FoodInit.paperPack, 1, 2));
		OreDictionary.registerOre("listAllmilk", new ItemStack(FoodInit.paperPack, 1, 2));
		OreDictionary.registerOre("foodCream", new ItemStack(FoodInit.paperPack, 1, 3));
		OreDictionary.registerOre("listAllheavycream", new ItemStack(FoodInit.paperPack, 1, 3));
		OreDictionary.registerOre("foodCream", new ItemStack(FoodInit.dropCream, 1, 0));
		OreDictionary.registerOre("listAllheavycream", new ItemStack(FoodInit.dropCream, 1, 0));
		OreDictionary.registerOre("foodOil", new ItemStack(FoodInit.paperPack, 1, 4));
		OreDictionary.registerOre("foodOliveoil", new ItemStack(FoodInit.paperPack, 1, 4));
		OreDictionary.registerOre("dropFuel", new ItemStack(FoodInit.paperPack, 1, 4));
		OreDictionary.registerOre("foodOil", new ItemStack(FoodInit.dropOil, 1, 0));
		OreDictionary.registerOre("foodVegetablejuice", new ItemStack(FoodInit.paperPack, 1, 5));
		OreDictionary.registerOre("foodLemonaide", new ItemStack(FoodInit.paperPack, 1, 6));
		OreDictionary.registerOre("foodAbsince", new ItemStack(FoodInit.paperPack, 1, 7));
		OreDictionary.registerOre("foodGreentea", new ItemStack(FoodInit.paperPack, 1, 8));
		OreDictionary.registerOre("foodTea", new ItemStack(FoodInit.paperPack, 1, 9));
		OreDictionary.registerOre("foodCoffee", new ItemStack(FoodInit.paperPack, 1, 10));
		OreDictionary.registerOre("foodStock", new ItemStack(FoodInit.paperPack, 1, 11));
		OreDictionary.registerOre("foodLiquor", new ItemStack(FoodInit.paperPack, 1, 12));
		OreDictionary.registerOre("dropFuel", new ItemStack(FoodInit.paperPack, 1, 12));
		OreDictionary.registerOre("bucketMilk", new ItemStack(FoodInit.paperPack, 1, 13));
		OreDictionary.registerOre("bucketSoymilk", new ItemStack(FoodInit.paperPack, 1, 13));
		OreDictionary.registerOre("listAllmilk", new ItemStack(FoodInit.paperPack, 1, 13));
		OreDictionary.registerOre("dropFuel", new ItemStack(FoodInit.paperPack, 1, 14));
		OreDictionary.registerOre("dropSulfuricAcid", new ItemStack(FoodInit.paperPack, 1, 15));
		OreDictionary.registerOre("dropNitricAcid", new ItemStack(FoodInit.paperPack, 1, 16));
		OreDictionary.registerOre("gasFuel", new ItemStack(FoodInit.paperPack, 1, 17));
		OreDictionary.registerOre("gasHydrogen", new ItemStack(FoodInit.paperPack, 1, 18));
		OreDictionary.registerOre("gasNitrogen", new ItemStack(FoodInit.paperPack, 1, 19));
		OreDictionary.registerOre("gasAmmonia", new ItemStack(FoodInit.paperPack, 1, 20));
		OreDictionary.registerOre("gasOxygen", new ItemStack(FoodInit.paperPack, 1, 21));

		OreDictionary.registerOre("foodButter", new ItemStack(FoodInit.dairy, 1, 0));
		OreDictionary.registerOre("foodCheese", new ItemStack(FoodInit.dairy, 1, 1));
		OreDictionary.registerOre("foodCustard", new ItemStack(FoodInit.dairy, 1, 2));
		OreDictionary.registerOre("foodCream", new ItemStack(FoodInit.dairy, 1, 3));
		OreDictionary.registerOre("foodButter", new ItemStack(FoodInit.dairy, 1, 4));
		OreDictionary.registerOre("listAllheavycream", new ItemStack(FoodInit.dairy, 1, 3));
		OreDictionary.registerOre("foodViscera", new ItemStack(FoodInit.meat, 1, 0));
		OreDictionary.registerOre("foodRennet", new ItemStack(FoodInit.meat, 1, 1));
		OreDictionary.registerOre("foodSquid", new ItemStack(FoodInit.meat, 1, 2));
		OreDictionary.registerOre("foodCalamariraw", new ItemStack(FoodInit.meat, 1, 2));
		OreDictionary.registerOre("foodAgar", new ItemStack(FoodInit.meat, 1, 3));
		OreDictionary.registerOre("foodGelatine", new ItemStack(FoodInit.meat, 1, 4));
		OreDictionary.registerOre("listAllmeatraw", new ItemStack(FoodInit.meat, 1, 5));
		OreDictionary.registerOre("foodVegimeat", new ItemStack(FoodInit.meat, 1, 5));
		OreDictionary.registerOre("foodMiso", new ItemStack(FoodInit.meat, 1, 6));
		OreDictionary.registerOre("foodMisopaste", new ItemStack(FoodInit.meat, 1, 6));
		OreDictionary.registerOre("foodSoysauce", new ItemStack(FoodInit.meat, 1, 7));
		OreDictionary.registerOre("foodSiroanko", new ItemStack(FoodInit.meat, 1, 8));
		OreDictionary.registerOre("foodAnko", new ItemStack(FoodInit.meat, 1, 8));
		OreDictionary.registerOre("foodShrimp", new ItemStack(FoodInit.meat, 1, 9));
		OreDictionary.registerOre("foodShrimpraw", new ItemStack(FoodInit.meat, 1, 9));
		OreDictionary.registerOre("foodRoe", new ItemStack(FoodInit.meat, 1, 10));
		OreDictionary.registerOre("foodAzukianko", new ItemStack(FoodInit.meat, 1, 11));
		OreDictionary.registerOre("foodAnko", new ItemStack(FoodInit.meat, 1, 11));
		OreDictionary.registerOre("foodPastry", new ItemStack(FoodInit.pastry, 1, 0));
		OreDictionary.registerOre("foodNoodles", new ItemStack(FoodInit.pastry, 1, 1));
		OreDictionary.registerOre("cropCinnamon", new ItemStack(FoodInit.spices, 1, 0));
		OreDictionary.registerOre("listAllspice", new ItemStack(FoodInit.spices, 1, 0));
		OreDictionary.registerOre("cropAzuki", new ItemStack(FoodInit.spices, 1, 1));
		OreDictionary.registerOre("cropRedbean", new ItemStack(FoodInit.spices, 1, 1));
		OreDictionary.registerOre("foodGarammasala", new ItemStack(FoodInit.spices, 1, 2));
		OreDictionary.registerOre("listAllspice", new ItemStack(FoodInit.spices, 1, 2));

		OreDictionary.registerOre("foodCoffeeBean", new ItemStack(FoodInit.teaLeaves, 1, 0));
		OreDictionary.registerOre("foodGreenteaLeaf", new ItemStack(FoodInit.teaLeaves, 1, 1));
		OreDictionary.registerOre("foodTeaLeaf", new ItemStack(FoodInit.teaLeaves, 1, 2));

		OreDictionary.registerOre("foodDough", new ItemStack(FoodInit.bread, 1, 0));
		OreDictionary.registerOre("foodBowlofrice", new ItemStack(FoodInit.ricebowl, 1, 0));
		OreDictionary.registerOre("foodRicecake", new ItemStack(FoodInit.mochi, 1, 1));

		OreDictionary.registerOre("bread", new ItemStack(FoodInit.bread, 1, 1));
		OreDictionary.registerOre("bread", new ItemStack(FoodInit.bread, 1, 3));
		OreDictionary.registerOre("bread", new ItemStack(FoodInit.bread, 1, 13));
		OreDictionary.registerOre("bread", new ItemStack(FoodInit.bread, 1, 21));
		OreDictionary.registerOre("foodToast", new ItemStack(FoodInit.bread, 1, 5));
		OreDictionary.registerOre("foodPizza", new ItemStack(FoodInit.bread, 1, 7));
		OreDictionary.registerOre("foodFrenchtoast", new ItemStack(FoodInit.bread, 1, 9));
		OreDictionary.registerOre("foodGarlicbread", new ItemStack(FoodInit.bread, 1, 11));
		OreDictionary.registerOre("foodPita", new ItemStack(FoodInit.bread, 1, 13));
		OreDictionary.registerOre("foodPancakes", new ItemStack(FoodInit.bread, 1, 15));
		OreDictionary.registerOre("foodPita", new ItemStack(FoodInit.bread, 1, 21));
		OreDictionary.registerOre("foodTortilla", new ItemStack(FoodInit.bread, 1, 21));
		OreDictionary.registerOre("foodCrackers", new ItemStack(FoodInit.bread, 1, 27));
		OreDictionary.registerOre("foodMarshmellows", new ItemStack(FoodInit.nonEntity, 1, 0));
		OreDictionary.registerOre("foodDatenut", new ItemStack(FoodInit.nonEntity, 1, 1));
		OreDictionary.registerOre("foodTaffy", new ItemStack(FoodInit.nonEntity, 1, 2));
		OreDictionary.registerOre("foodTofu", new ItemStack(FoodInit.nonEntity, 1, 3));
		OreDictionary.registerOre("foodFirmtofu", new ItemStack(FoodInit.nonEntity, 1, 3));
		OreDictionary.registerOre("foodSmokedsalmon", new ItemStack(FoodInit.nonEntity, 1, 4));
		OreDictionary.registerOre("foodRaisins", new ItemStack(FoodInit.nonEntity, 1, 5));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(FoodInit.sticks, 1, 3));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(FoodInit.sticks, 1, 5));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(FoodInit.sticks, 1, 7));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(FoodInit.sticks, 1, 9));
		OreDictionary.registerOre("listAllmeatcooked", new ItemStack(FoodInit.sticks, 1, 17));
		OreDictionary.registerOre("listAllfishcooked", new ItemStack(FoodInit.sticks, 1, 1));
		OreDictionary.registerOre("listAllchickencooked", new ItemStack(FoodInit.sticks, 1, 3));
		OreDictionary.registerOre("listAllporkcooked", new ItemStack(FoodInit.sticks, 1, 5));
		OreDictionary.registerOre("listAllbeefcooked", new ItemStack(FoodInit.sticks, 1, 7));
		OreDictionary.registerOre("listAllmuttoncooked", new ItemStack(FoodInit.sticks, 1, 9));
		OreDictionary.registerOre("foodChili", new ItemStack(FoodInit.bowlSoup, 1, 13));
		OreDictionary.registerOre("foodLiverpaste", new ItemStack(FoodInit.dip, 1, 0));
		OreDictionary.registerOre("foodRaisinbutter", new ItemStack(FoodInit.dip, 1, 1));
		OreDictionary.registerOre("foodSalsa", new ItemStack(FoodInit.dip, 1, 2));
		OreDictionary.registerOre("foodPlainyogurt", new ItemStack(FoodInit.yogurt, 1, 0));
		OreDictionary.registerOre("foodPlainyogurt", new ItemStack(FoodInit.yogurt, 1, 1));
		OreDictionary.registerOre("foodCurry", new ItemStack(FoodInit.curry, 1, 0));
		OreDictionary.registerOre("foodCurry", new ItemStack(FoodInit.curry, 1, 1));
		OreDictionary.registerOre("foodCurry", new ItemStack(FoodInit.curry, 1, 2));
		OreDictionary.registerOre("foodCurry", new ItemStack(FoodInit.curry, 1, 3));
		OreDictionary.registerOre("foodCurry", new ItemStack(FoodInit.curry, 1, 4));
		OreDictionary.registerOre("foodCurry", new ItemStack(FoodInit.curry, 1, 5));

		if (ModuleConfig.food_advanced) {
			OreDictionary.registerOre("bottleBeer", new ItemStack(FoodInit.liquorBottle, 1, 1));
			OreDictionary.registerOre("bottleWine", new ItemStack(FoodInit.liquorBottle, 1, 2));
			OreDictionary.registerOre("bottleSake", new ItemStack(FoodInit.liquorBottle, 1, 3));
			OreDictionary.registerOre("bottleRoseWater", new ItemStack(FoodInit.roseWaterBottle, 1, 0));
			OreDictionary.registerOre("bottleTonic", new ItemStack(FoodInit.roseWaterBottle, 1, 1));
			OreDictionary.registerOre("foodBubblywater", new ItemStack(FoodInit.roseWaterBottle, 1, 1));
			OreDictionary.registerOre("bottleLemonSquash", new ItemStack(FoodInit.roseWaterBottle, 1, 2));
			OreDictionary.registerOre("listAllsoda", new ItemStack(FoodInit.roseWaterBottle, 1, 2));
			OreDictionary.registerOre("bottleCola", new ItemStack(FoodInit.roseWaterBottle, 1, 3));
			OreDictionary.registerOre("foodColasoda", new ItemStack(FoodInit.roseWaterBottle, 1, 3));
			OreDictionary.registerOre("listAllsoda", new ItemStack(FoodInit.roseWaterBottle, 1, 3));

			OreDictionary.registerOre("dustSpentGrain", new ItemStack(FoodInit.residue, 1, 0));
			OreDictionary.registerOre("dustSakeLees", new ItemStack(FoodInit.residue, 1, 1));
			OreDictionary.registerOre("dustPomace", new ItemStack(FoodInit.residue, 1, 2));
			OreDictionary.registerOre("dustDraff", new ItemStack(FoodInit.residue, 1, 0));
			OreDictionary.registerOre("dustDraff", new ItemStack(FoodInit.residue, 1, 1));
			OreDictionary.registerOre("dustDraff", new ItemStack(FoodInit.residue, 1, 2));
			OreDictionary.registerOre("feedSilage", new ItemStack(FoodInit.residue, 1, 3));
			OreDictionary.registerOre("dustYeast", new ItemStack(FoodInit.residue, 1, 4));
			OreDictionary.registerOre("dustPeptone", new ItemStack(FoodInit.residue, 1, 5));
			OreDictionary.registerOre("dustWhey", new ItemStack(FoodInit.residue, 1, 6));
			OreDictionary.registerOre("brothIncreace", new ItemStack(FoodInit.broth, 1, 0));
			OreDictionary.registerOre("brothGrow", new ItemStack(FoodInit.broth, 1, 1));
			OreDictionary.registerOre("foodKoji", new ItemStack(FoodInit.inoculum, 1, 0));
			OreDictionary.registerOre("dustMana", new ItemStack(FoodInit.antibiotic, 1, 7));
			OreDictionary.registerOre("dyeBlue", new ItemStack(FoodInit.cyano, 1, 2));
		}

		ConvertTargetList.addExclusing(new ItemStack(FoodInit.paperPack, 1, 1));
		ConvertTargetList.addExclusing(new ItemStack(FoodInit.paperPack, 1, 2));

		OreDictionary.registerOre("vineLeaves", new ItemStack(FoodInit.cropWisteria, 1, 32767));
		OreDictionary.registerOre("vineLeaves", new ItemStack(FoodInit.cropGrape, 1, 32767));

	}

	static void loadMicrobe() {
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.bacillus);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.coliformes);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.lab);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.skin);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.cyano);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.beerYeast);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.oryzae);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.nether);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.blueMold);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.slimeMold);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.mushroom);
		MainAPIManager.microbeRegister.registerSpecies((IMicrobe) FoodInit.methanogen);

		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(FoodInit.chickInEgg, DispenseChickInEgg.getInstance());
	}

}
