package defeatedcrow.hac.magic;

import defeatedcrow.hac.api.blockstate.DCState;
import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.core.client.JsonRegisterHelper;
import defeatedcrow.hac.magic.block.TileCubeFlame;
import defeatedcrow.hac.magic.block.TileCubeIce;
import defeatedcrow.hac.magic.block.TileLotusCandle;
import defeatedcrow.hac.magic.block.TileLotusCandleBlack;
import defeatedcrow.hac.magic.block.TilePictureBG;
import defeatedcrow.hac.magic.block.TilePictureGU;
import defeatedcrow.hac.magic.block.TilePictureRW;
import defeatedcrow.hac.magic.block.TilePictureUR;
import defeatedcrow.hac.magic.block.TilePictureWB;
import defeatedcrow.hac.magic.block.TileTimeCage;
import defeatedcrow.hac.magic.block.TileVeinBeacon;
import defeatedcrow.hac.magic.client.BlackDogRenderer;
import defeatedcrow.hac.magic.client.FireCircleRenderer;
import defeatedcrow.hac.magic.client.FlametongueDogRenderer;
import defeatedcrow.hac.magic.client.FlowerTurretRenderer;
import defeatedcrow.hac.magic.client.HealCircleRenderer;
import defeatedcrow.hac.magic.client.MagicBlackSpitRenderer;
import defeatedcrow.hac.magic.client.MagicCircleRenderer;
import defeatedcrow.hac.magic.client.MagicCushionRenderer;
import defeatedcrow.hac.magic.client.MagicIceSpitRenderer;
import defeatedcrow.hac.magic.client.MagicLightSpitRenderer;
import defeatedcrow.hac.magic.client.MagicRedSpitRenderer;
import defeatedcrow.hac.magic.client.MagicWhiteSpitRenderer;
import defeatedcrow.hac.magic.client.ProjCircleRenderer;
import defeatedcrow.hac.magic.client.TESRCubeFlame;
import defeatedcrow.hac.magic.client.TESRCubeIce;
import defeatedcrow.hac.magic.client.TESRLotusCandle;
import defeatedcrow.hac.magic.client.TESRTimeCage;
import defeatedcrow.hac.magic.client.TESRVeinBeacon;
import defeatedcrow.hac.magic.entity.EntityBlackDog;
import defeatedcrow.hac.magic.entity.EntityFTDog;
import defeatedcrow.hac.magic.entity.EntityFlowerTurret;
import defeatedcrow.hac.magic.entity.EntityMagicCushion;
import defeatedcrow.hac.magic.proj.EntityFireBarrier;
import defeatedcrow.hac.magic.proj.EntityHealBarrier;
import defeatedcrow.hac.magic.proj.EntityMobBarrier;
import defeatedcrow.hac.magic.proj.EntityProjBarrier;
import defeatedcrow.hac.magic.proj.EntityProjBlackSpit;
import defeatedcrow.hac.magic.proj.EntityProjDogSpit;
import defeatedcrow.hac.magic.proj.EntityProjIceSpit;
import defeatedcrow.hac.magic.proj.EntityProjLightSpit;
import defeatedcrow.hac.magic.proj.EntityProjRedSpit;
import defeatedcrow.hac.magic.proj.EntityProjWhiteSpit;
import defeatedcrow.hac.main.client.ClientMainProxy;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MagicClientProxy {

	public static void loadEntity() {
		ClientMainProxy.registRender(EntityProjLightSpit.class, MagicLightSpitRenderer.class);
		ClientMainProxy.registRender(EntityProjIceSpit.class, MagicIceSpitRenderer.class);
		ClientMainProxy.registRender(EntityProjWhiteSpit.class, MagicWhiteSpitRenderer.class);
		ClientMainProxy.registRender(EntityProjRedSpit.class, MagicRedSpitRenderer.class);
		ClientMainProxy.registRender(EntityProjBlackSpit.class, MagicBlackSpitRenderer.class);
		ClientMainProxy.registRender(EntityProjDogSpit.class, MagicRedSpitRenderer.class);

		ClientMainProxy.registRender(EntityMobBarrier.class, MagicCircleRenderer.class);
		ClientMainProxy.registRender(EntityProjBarrier.class, ProjCircleRenderer.class);
		ClientMainProxy.registRender(EntityHealBarrier.class, HealCircleRenderer.class);
		ClientMainProxy.registRender(EntityFireBarrier.class, FireCircleRenderer.class);

		ClientMainProxy.registRender(EntityBlackDog.class, BlackDogRenderer.class);
		ClientMainProxy.registRender(EntityFTDog.class, FlametongueDogRenderer.class);

		ClientMainProxy.registRender(EntityFlowerTurret.class, FlowerTurretRenderer.class);

		ClientMainProxy.registRender(EntityMagicCushion.class, MagicCushionRenderer.class);
	}

	public static void loadTE() {
		ClientMainProxy.registerTileEntity(TileCubeIce.class, "dcs_te_cube_ice", new TESRCubeIce());
		ClientMainProxy.registerTileEntity(TileCubeFlame.class, "dcs_te_cube_flame", new TESRCubeFlame());
		ClientMainProxy.registerTileEntity(TileLotusCandle.class, "dcs_te_lotus_candle", new TESRLotusCandle());
		ClientMainProxy.registerTileEntity(TileVeinBeacon.class, "dcs_te_vein_beacon", new TESRVeinBeacon());
		ClientMainProxy
				.registerTileEntity(TileLotusCandleBlack.class, "dcs_te_lotus_candle_black", new TESRLotusCandle());

		ClientMainProxy.registerTileEntity(TileTimeCage.class, "dcs_te_time_cage", new TESRTimeCage());

		GameRegistry.registerTileEntity(TilePictureUR.class, "dcs_te_picture_u");
		GameRegistry.registerTileEntity(TilePictureRW.class, "dcs_te_picture_r");
		GameRegistry.registerTileEntity(TilePictureWB.class, "dcs_te_picture_w");
		GameRegistry.registerTileEntity(TilePictureBG.class, "dcs_te_picture_b");
		GameRegistry.registerTileEntity(TilePictureGU.class, "dcs_te_picture_g");
	}

	public static void regJson(JsonRegisterHelper instance) {
		// item
		instance.regSimpleItem(MagicInit.colorDrop, ClimateCore.PACKAGE_ID, "dcs_color", "magic", 9);
		instance.regSimpleItem(MagicInit.colorRing, ClimateCore.PACKAGE_ID, "dcs_color_ring", "magic", 4);
		instance.regSimpleItem(MagicInit.colorRing2, ClimateCore.PACKAGE_ID, "dcs_color_ring2", "magic", 4);
		instance.regSimpleItem(MagicInit.colorPendant, ClimateCore.PACKAGE_ID, "dcs_color_pendant", "magic", 4);
		instance.regSimpleItem(MagicInit.colorPendant2, ClimateCore.PACKAGE_ID, "dcs_color_pendant2", "magic", 4);
		instance.regSimpleItem(MagicInit.colorBadge, ClimateCore.PACKAGE_ID, "dcs_color_badge", "magic", 4);
		instance.regSimpleItem(MagicInit.colorGauntlet, ClimateCore.PACKAGE_ID, "dcs_color_gauntlet", "magic", 4);
		instance.regSimpleItem(MagicInit.magicCard, ClimateCore.PACKAGE_ID, "dcs_magic_card", "magic", 14);
		instance.regSimpleItem(MagicInit.magicCard2, ClimateCore.PACKAGE_ID, "dcs_magic_card_m", "magic", 4);
		instance.regSimpleItem(MagicInit.magicCard3, ClimateCore.PACKAGE_ID, "dcs_magic_card_m2", "magic", 4);

		instance.regSimpleItem(MagicInit.expGem, ClimateCore.PACKAGE_ID, "dcs_expgem", "magic", 0);
		instance.regSimpleItem(MagicInit.gemBootsBird, ClimateCore.PACKAGE_ID, "dcs_gemboots_blue", "equip", 0);
		instance.regSimpleItem(MagicInit.gemBootsFish, ClimateCore.PACKAGE_ID, "dcs_gemboots_green", "equip", 0);

		// block
		instance.regSimpleBlock(MagicInit.colorCube, ClimateCore.PACKAGE_ID, "dcs_color_cube", "device", 9);
		instance.regTEBlock(MagicInit.clusterIce, ClimateCore.PACKAGE_ID, "dcs_cube_ice", "magic", 0, false);
		instance.regTEBlock(MagicInit.infernalFlame, ClimateCore.PACKAGE_ID, "dcs_cube_flame", "magic", 0, false);
		instance.regSimpleBlock(MagicInit.elestial, ClimateCore.PACKAGE_ID, "dcs_ore_elestial", "ores", 0);
		instance.regTEBlock(MagicInit.lotusCandle, ClimateCore.PACKAGE_ID, "dcs_lotus_candle_white", "magic", 0, false);
		instance.regTEBlock(MagicInit.lotusCandleBlack, ClimateCore.PACKAGE_ID, "dcs_lotus_candle_black", "magic", 0, false);
		instance.regSimpleBlock(MagicInit.biomeOrb, ClimateCore.PACKAGE_ID, "dcs_magic_biomeglass", "magic", 3);
		instance.regSimpleBlock(MagicInit.coldLamp, ClimateCore.PACKAGE_ID, "dcs_build_coldlamp", "magic", 3);
		instance.regTEBlock(MagicInit.timeCage, ClimateCore.PACKAGE_ID, "dcs_time_cage", "magic", 0, false);
		instance.regSimpleItem(Item
				.getItemFromBlock(MagicInit.pictureBlue), ClimateCore.PACKAGE_ID, "dcs_magic_picture_u", "device", 0);
		instance.regSimpleItem(Item
				.getItemFromBlock(MagicInit.pictureRed), ClimateCore.PACKAGE_ID, "dcs_magic_picture_r", "device", 0);
		instance.regSimpleItem(Item
				.getItemFromBlock(MagicInit.pictureGreen), ClimateCore.PACKAGE_ID, "dcs_magic_picture_g", "device", 0);
		instance.regSimpleItem(Item
				.getItemFromBlock(MagicInit.pictureWhite), ClimateCore.PACKAGE_ID, "dcs_magic_picture_w", "device", 0);
		instance.regSimpleItem(Item
				.getItemFromBlock(MagicInit.pictureBlack), ClimateCore.PACKAGE_ID, "dcs_magic_picture_b", "device", 0);
		ModelLoader.setCustomStateMapper(MagicInit.veinBeacon, (new StateMap.Builder()).ignore(DCState.TYPE16).build());
		instance.regSimpleBlock(MagicInit.veinBeacon, ClimateCore.PACKAGE_ID, "dcs_beacon_vein", "magic", 0);

	}

}
