package defeatedcrow.hac.food.block;

import java.util.List;

import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.food.gui.ContainerSteelPot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class TileSteelPot extends TileFluidProcessorBase {

	@Override
	public int getProcessTime() {
		if (current != null) {
			DCHeatTier tier = current.getHeat();
			int i = tier.getTier();
			if (i < 0) {
				i *= -1;
			}
			int ret = 20 - i * 4;
			if (ret < 2) {
				ret = 2;
			}
			return ret;
		}
		return 20;
	}

	@Override
	public boolean isSuitableClimate() {
		// 問わず
		return current != null;
	}

	@Override
	public String climateSuitableMassage() {
		if (current == null)
			return "dcs.gui.message.nullclimate";
		else
			return "dcs.gui.message.suitableclimate";
	}

	// @Override
	// protected void onServerUpdate() {
	// super.onServerUpdate();
	// boolean lit = !this.outputT.isEmpty();
	// if (BlockSteelPot.isLit(getWorld(), getPos()) != lit) {
	// BlockSteelPot.changeLitState(getWorld(), getPos(), lit);
	// }
	// }

	/* ========== 以下、ISidedInventoryのメソッド ========== */

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerSteelPot(this, playerInventory);
	}

	@Override
	public String getGuiID() {
		return "dcs_climate:fluidprocessor_steel";
	}
	/* サイズ変更 */

	/*
	 * 0: fluid in 1
	 * 1: fluid out 1
	 * 2: fluid in 2
	 * 3: fluid out 2
	 * 4-9: in
	 * 10-12: out
	 */

	@Override
	protected int getInputSlotTop() {
		return 4;
	}

	@Override
	protected int getInputSlotEnd() {
		return 9;
	}

	@Override
	protected int getOutputSlotTop() {
		return 10;
	}

	@Override
	protected int getOutputSlotEnd() {
		return 12;
	}

	@Override
	protected int[] slotsTop() {
		return new int[] {
				0,
				2,
				4,
				5,
				6,
				7,
				8,
				9
		};
	};

	@Override
	protected int[] slotsBottom() {
		return new int[] {
				1,
				3,
				10,
				11,
				12
		};
	};

	@Override
	protected int[] slotsSides() {
		return new int[] {
				0,
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9,
				10,
				11,
				12
		};
	};

	@Override
	public List<ItemStack> getInputs() {
		return inv.getInputs(4, 9);
	}

	@Override
	public List<ItemStack> getOutputs() {
		return inv.getOutputs(10, 12);
	}

	// スロット数
	@Override
	public int getSizeInventory() {
		return 13;
	}

}
