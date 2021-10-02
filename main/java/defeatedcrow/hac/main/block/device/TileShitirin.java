package defeatedcrow.hac.main.block.device;

import java.util.ArrayList;
import java.util.List;

import defeatedcrow.hac.api.climate.DCAirflow;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.main.api.IColorChangeTile;
import defeatedcrow.hac.main.client.gui.ContainerNormalChamber;
import defeatedcrow.hac.main.packet.DCMainPacket;
import defeatedcrow.hac.main.packet.MessageColorID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

public class TileShitirin extends TileNormalChamber implements IColorChangeTile {

	private int lastTier = 0;
	private int lastBurn = 0;

	@Override
	public void updateTile() {
		super.updateTile();
		if (!getWorld().isRemote) {

			DCAirflow air = DCAirflow.TIGHT;
			if (current != null) {
				air = current.getAirflow();
			}

			if (air.getID() > 0) {
				this.currentClimate = DCHeatTier.OVEN.getID();
			} else {
				this.currentClimate = DCHeatTier.BOIL.getID();
			}

			if (BlockShitirin.isLit(getWorld(), getPos()) != this.isActive()) {
				BlockShitirin.changeLitState(getWorld(), getPos(), isActive());
			}
		}
	}

	/* === 燃焼判定 === */

	@Override
	protected void onServerUpdate() {
		if (this.currentBurnTime > 0 && BlockShitirin.isPower(getWorld(), getPos())) {
			this.currentBurnTime--;
		}
	}

	@Override
	public int getFuel(ItemStack item) {
		return getBurnTime(item) * 4;
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString(this.getName());
	}

	@Override
	public String getName() {
		return "dcs.gui.device.shitirin";
	}

	@Override
	public boolean isSuitableClimate() {
		return currentClimate > DCHeatTier.HOT.getID();
	}

	@Override
	public List<String> climateSuitableMassage() {
		List<String> list = new ArrayList<String>();
		if (isSuitableClimate()) {
			list.add(I18n.translateToLocal("dcs.gui.message.suitable"));
		} else {
			list.add(I18n.translateToLocal("dcs.gui.message.require.airflow"));
			list.add(I18n.translateToLocal("dcs.gui.message.require.airflow2"));
		}
		return list;
	}

	/* ========== 以下、ISidedInventoryのメソッド ========== */

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerNormalChamber(this, playerInventory);
	}

	// color

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.color = tag.getInteger("Color");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("Color", this.color);
		return tag;
	}

	@Override
	public void setNBT(NBTTagCompound tag) {
		super.setNBT(tag);
		this.color = tag.getInteger("Color");
	}

	@Override
	public NBTTagCompound getNBT(NBTTagCompound tag) {
		super.getNBT(tag);
		tag.setInteger("Color", this.color);
		return tag;
	}

	protected int color = 0;

	@Override
	public int getColor() {
		return color;
	}

	@Override
	public void setColor(int num) {
		color = num;
		if (color < 0 || color > 3) {
			color = 0;
		}
	}

	@Override
	public boolean rotateColor() {
		int c = color + 1;
		setColor(c);
		if (!world.isRemote) {
			DCMainPacket.INSTANCE.sendToAll(new MessageColorID(pos, color));
		}
		return true;
	}

}
