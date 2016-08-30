/**
 * Copyright (c) defeatedcrow, 2016
 * URL:http://defeatedcrow.jp/modwiki/Mainpage
 * defeatedcrow's mods are distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL.
 * Please check the License.txt included in the package file of this Mod.
 */

package defeatedcrow.hac.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.main.config.MainConfig;

@Mod(
		modid = ClimateMain.MOD_ID,
		name = ClimateMain.MOD_NAME,
		version = ClimateMain.MOD_MEJOR + "." + ClimateMain.MOD_MINOR + "." + ClimateMain.MOD_BUILD,
		dependencies = ClimateMain.MOD_DEPENDENCIES,
		acceptedMinecraftVersions = ClimateCore.MOD_ACCEPTED_MC_VERSIONS,
		useMetadata = true)
public class ClimateMain {
	public static final String MOD_ID = "dcs_climate";
	public static final String MOD_NAME = "HeatAndClimateMod";
	public static final int MOD_MEJOR = 1;
	public static final int MOD_MINOR = 0;
	public static final int MOD_BUILD = 0;
	public static final String MOD_DEPENDENCIES = "required-after:Forge@[12.17.0.1976,);required-after:dcs_climate|lib@[1.0.0,)";

	@SidedProxy(
			clientSide = "defeatedcrow.hac.main.client.ClientMainProxy",
			serverSide = "defeatedcrow.hac.main.CommonMainProxy")
	public static CommonMainProxy proxy;

	@Instance("dcs_climate")
	public static ClimateMain instance;

	public static final CreativeTabs tool = new CreativeTabClimateTool(MOD_ID);
	public static final CreativeTabs food = new CreativeTabClimateFood(MOD_ID + "_food");
	public static final CreativeTabs build = new CreativeTabClimateBuild(MOD_ID + "_build");

	@EventHandler
	public void construction(FMLConstructionEvent event) {
		// TextureStitch
		proxy.loadConst();
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// config
		MainConfig.INSTANCE.load(event.getModConfigurationDirectory());
		// Material
		proxy.loadMaterial();
		// TileEntity
		proxy.loadTE();
		// Entity
		proxy.loadEntity();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		// WorldGen
		proxy.loadWorldGen();
		// Recipes
		proxy.loadRecipes();
		// event
		proxy.loadInit();

		// other things
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
	}

}
