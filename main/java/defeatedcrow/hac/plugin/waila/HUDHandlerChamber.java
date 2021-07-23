package defeatedcrow.hac.plugin.waila;

import java.util.List;

import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.machine.block.TileFan;
import defeatedcrow.hac.machine.block.TileFreezer;
import defeatedcrow.hac.machine.block.TileHeatExchanger;
import defeatedcrow.hac.main.MainInit;
import defeatedcrow.hac.main.block.device.BlockFirestand;
import defeatedcrow.hac.main.block.device.BlockSwedishTorch;
import defeatedcrow.hac.main.block.device.TileBellow;
import defeatedcrow.hac.main.block.device.TileCookingStove;
import defeatedcrow.hac.main.block.device.TileNormalChamber;
import defeatedcrow.hac.main.config.ModuleConfig;
import defeatedcrow.hac.main.util.DCName;
import mcp.mobius.waila.addons.core.HUDHandlerBlocks;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.SpecialChars;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HUDHandlerChamber extends HUDHandlerBlocks {

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		if (!config.getConfig("dcs_climate.showclimate") || accessor.getBlock() == null)
			return currenttip;

		Block block = accessor.getBlock();
		int meta = accessor.getMetadata();

		if (block == MainInit.chamber || block == MainInit.shitirin || block == MainInit.fuelStove || block == MachineInit.burner) {
			int burntime = accessor.getNBTData().getInteger("BurnTime");
			byte tier = accessor.getNBTData().getByte("Climate");
			if (burntime > 0) {
				DCHeatTier heat = DCHeatTier.getTypeByID(tier);
				currenttip.add(String.format("%s: %s", DCName.TEMP2.getLocalizedName(), SpecialChars.GOLD + heat
						.localize()));
			} else {
				currenttip.add(String.format("%s", DCName.STOPPING.getLocalizedName()));
			}
		}

		if (block == MainInit.firestand) {
			if (meta == 1) {
				currenttip.add(String.format("%s: %s", DCName.TEMP2
						.getLocalizedName(), SpecialChars.GOLD + DCHeatTier.KILN.localize()));
			} else {
				currenttip.add(String.format("%s", DCName.STOPPING.getLocalizedName()));
			}
		}

		if (block == MainInit.swedishTorch) {
			if (meta == 1) {
				currenttip.add(String.format("%s: %s", DCName.TEMP2
						.getLocalizedName(), SpecialChars.GOLD + DCHeatTier.OVEN.localize()));
			} else {
				currenttip.add(String.format("%s", DCName.STOPPING.getLocalizedName()));
			}
		}

		if (block == MainInit.bellow) {
			float f = accessor.getNBTData().getFloat("dcs.pretoq");
			if (f > 0) {
				currenttip.add(String.format("%s: %s", DCName.AIR2
						.getLocalizedName(), SpecialChars.GREEN + DCAirflow.WIND.localize()));
			} else {
				currenttip.add(String.format("%s", DCName.STOPPING.getLocalizedName()));
			}
		}

		if (ModuleConfig.machine) {

			if (block == MachineInit.freezer) {
				float burntime = accessor.getNBTData().getFloat("dcs.pretoq");
				byte tier = accessor.getNBTData().getByte("dcs.heatID");
				if (burntime > 0) {
					DCHeatTier heat = DCHeatTier.getTypeByID(tier);
					currenttip.add(String.format("%s: %s", DCName.TEMP2.getLocalizedName(), SpecialChars.AQUA + heat
							.localize()));
				} else {
					currenttip.add(String.format("%s", DCName.STOPPING.getLocalizedName()));
				}
			}

			if (block == MachineInit.fan) {
				float f = accessor.getNBTData().getFloat("dcs.pretoq");
				if (f > 5.5F) {
					currenttip.add(String.format("%s: %s", DCName.AIR2
							.getLocalizedName(), SpecialChars.GREEN + DCAirflow.WIND.localize()));
				} else {
					currenttip.add(String.format("%s", DCName.STOPPING.getLocalizedName()));
				}
			}

			if (block == MachineInit.heatPump) {
				float f = accessor.getNBTData().getFloat("dcs.pretoq");
				if (f > 31.5F) {
					currenttip.add(String.format("Active: %s", SpecialChars.RED + "Stage 2"));
				} else if (f > 5.5F) {
					currenttip.add(String.format("Active: %s", SpecialChars.GOLD + "Stage 1"));
				} else {
					currenttip.add(String.format("%s", DCName.STOPPING.getLocalizedName()));
				}
			}
		}

		return currenttip;
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world,
			BlockPos pos) {
		return te.writeToNBT(tag);
	}

	public static void register(IWailaRegistrar registrar) {

		HUDHandlerChamber provider = new HUDHandlerChamber();

		registrar.registerBodyProvider(provider, BlockFirestand.class);
		registrar.registerBodyProvider(provider, BlockSwedishTorch.class);

		registrar.registerBodyProvider(provider, TileNormalChamber.class);
		registrar.registerNBTProvider(provider, TileNormalChamber.class);

		registrar.registerBodyProvider(provider, TileCookingStove.class);
		registrar.registerNBTProvider(provider, TileCookingStove.class);

		registrar.registerBodyProvider(provider, TileBellow.class);
		registrar.registerNBTProvider(provider, TileBellow.class);

		if (ModuleConfig.machine) {
			registrar.registerBodyProvider(provider, TileFan.class);
			registrar.registerNBTProvider(provider, TileFan.class);

			registrar.registerBodyProvider(provider, TileHeatExchanger.class);
			registrar.registerNBTProvider(provider, TileHeatExchanger.class);
		}

		if (ModuleConfig.machine) {
			registrar.registerBodyProvider(provider, TileFreezer.class);
			registrar.registerNBTProvider(provider, TileFreezer.class);
		}

	}
}
