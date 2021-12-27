package defeatedcrow.hac.food.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import defeatedcrow.hac.api.climate.ClimateAPI;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import defeatedcrow.hac.core.fluid.DCTank;
import defeatedcrow.hac.core.util.DCUtil;
import defeatedcrow.hac.food.capability.DrinkCapabilityHandler;
import defeatedcrow.hac.food.capability.DrinkCustomizer;
import defeatedcrow.hac.food.capability.DrinkMilk;
import defeatedcrow.hac.food.capability.DrinkSugar;
import defeatedcrow.hac.food.capability.IDrinkCustomize;
import defeatedcrow.hac.food.gui.ContainerFluidProcessor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.oredict.OreDictionary;

/**
 * outputスロットは存在しない
 */
public class TileTeaPot extends TileFluidProcessorBase {

	public DrinkCustomizer cap = new DrinkCustomizer();

	protected int milkCount = 0;
	protected int sugarCount = 0;

	@Override
	public int getProcessTime() {
		if (current != null) {
			if (current.getHeat() == DCHeatTier.BOIL)
				return 8;
			else if (current.getHeat().getTier() > DCHeatTier.BOIL.getTier())
				return 4;
		}
		return 20;
	}

	public int getMilkCount() {
		return this.milkCount;
	}

	public int getSugarCount() {
		return this.sugarCount;
	}

	public void setMilkCount(int i) {
		this.milkCount = i;
	}

	public void setSugarCount(int i) {
		this.sugarCount = i;
	}

	public boolean setMilk(DrinkMilk milk) {
		if (milk.id == 0) {
			if (cap.getMilk().id == 0)
				return false;
			else {
				cap.setMilk(DrinkMilk.NONE);
				milkCount = 0;
				return true;
			}
		} else {
			if (cap.getMilk().id == 0) {
				cap.setMilk(milk);
				milkCount = 4;
				return true;
			} else if (cap.milkID == milk.id && milkCount < 64) {
				milkCount += 4;
				if (milkCount > 64) {
					milkCount = 64;
				}
				return true;
			} else
				return false;
		}
	}

	public boolean setSugar(DrinkSugar sugar) {
		if (sugar.id == 0) {
			if (cap.sugarID == 0)
				return false;
			else {
				cap.setSugar(DrinkSugar.NONE);
				sugarCount = 0;
				return true;
			}
		} else {
			if (cap.sugarID == 0) {
				cap.setSugar(sugar);
				sugarCount = 4;
				return true;
			} else if (cap.sugarID == sugar.id && sugarCount < 64) {
				sugarCount += 4;
				if (sugarCount > 64) {
					sugarCount = 64;
				}
				return true;
			} else
				return false;
		}
	}

	// Fill時に排出アイテムをカスタマイズできる
	@Override
	protected boolean onDrainTank(DCTank tank, int slot1, int slot2, boolean flag) {
		ItemStack in = this.getStackInSlot(slot1);
		ItemStack out = this.getStackInSlot(slot2);
		if (DCUtil.isEmpty(in))
			return false;

		IFluidHandlerItem dummy = null;
		ItemStack in2 = in.copy();
		if (in2.getCount() > 1) {
			in2.setCount(1);
		}
		if (in.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {
			dummy = in2.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
		} else if (in.getItem() instanceof IFluidHandlerItem) {
			dummy = (IFluidHandlerItem) in2.getItem();
		}

		if (tank.getFluidAmount() > 0 && dummy != null && dummy.getTankProperties() != null && dummy
				.getTankProperties().length > 0) {
			boolean loose = false;
			ItemStack ret = ItemStack.EMPTY;

			int max = dummy.getTankProperties()[0].getCapacity();
			FluidStack fc = dummy.drain(max, false);
			boolean b = false;
			int rem = max;
			if (fc == null || fc.amount == 0) {
				b = true;
			} else {
				rem = max - fc.amount;
				if (tank.getFluidAmount() <= rem) {
					b = true;
				}
			}
			// 排出の場合
			if (b) {
				FluidStack drain = tank.drain(rem, false);
				int fill = 0;
				fill = dummy.fill(drain, true);
				ret = dummy.getContainer();

				if (!DCUtil.isEmpty(ret)) {
					// Customize
					// DCLogger.debugLog("check1");
					if (ret.hasCapability(DrinkCapabilityHandler.DRINK_CUSTOMIZE_CAPABILITY, null)) {
						// DCLogger.debugLog("check2");
						IDrinkCustomize drink = ret
								.getCapability(DrinkCapabilityHandler.DRINK_CUSTOMIZE_CAPABILITY, null);
						DrinkMilk milk = this.cap.getMilk();
						DrinkSugar sugar = this.cap.getSugar();
						if (drink.setMilk(milk)) {
							this.milkCount--;
							if (this.milkCount <= 0) {
								cap.setMilk(DrinkMilk.NONE);
								this.milkCount = 0;
							}
						}
						if (drink.setSugar(sugar)) {
							this.sugarCount--;
							if (this.sugarCount <= 0) {
								cap.setSugar(DrinkSugar.NONE);
								this.sugarCount = 0;
							}
						}
					}
				}

				if (fill > 0 && this.canInsertResult(ret, slot2, slot2 + 1) != 0) {
					loose = true;
					tank.drain(fill, true);
				}
			}

			if (loose) {
				this.decrStackSize(slot1, 1);
				this.incrStackInSlot(slot2, ret);
				this.markDirty();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canRecipeProcess() {
		if (!isSuitableClimate())
			return false;
		FluidStack inf = inputT.getFluid();
		List<ItemStack> ins = new ArrayList<ItemStack>(this.getInputs());
		FluidStack outf = outputT.getFluid();
		List<ItemStack> outs = new ArrayList<ItemStack>(this.getOutputs());
		if (currentRecipe == null) {
			return false;
		} else {
			if (currentRecipe.matchClimate(current) && currentRecipe.matches(ins, inf)) {
				int outAmo = currentRecipe.getOutputFluid() == null ? 0 : currentRecipe.getOutputFluid().amount;
				return currentRecipe.matchOutput(outs, outf, 0) && outputT.getFluidAmount() + outAmo <= outputT
						.getCapacity();
			}
		}
		return false;
	}

	@Override
	public boolean canStartProcess() {
		if (!isSuitableClimate())
			return false;
		FluidStack inf = inputT.getFluid();
		List<ItemStack> ins = new ArrayList<ItemStack>(this.getInputs());
		FluidStack outf = outputT.getFluid();
		List<ItemStack> outs = new ArrayList<ItemStack>(this.getOutputs());
		currentRecipe = RecipeAPI.registerFluidRecipes.getRecipe(current, ins, inf);
		return currentRecipe != null && currentRecipe.matchOutput(outs, outf, 0);
	}

	@Override
	public boolean onProcess() {
		if (currentRecipe != null) {
			ItemStack out = currentRecipe.getOutput();
			ItemStack sec = currentRecipe.getSecondary();
			float chance = MathHelper.ceil(currentRecipe.getSecondaryChance() * 100);
			FluidStack inF = currentRecipe.getInputFluid();
			FluidStack outF = currentRecipe.getOutputFluid();

			if (inF != null) {
				inputT.drain(inF.amount, true);
			}

			List<Object> required = new ArrayList<Object>(currentRecipe.getProcessedInput());
			for (int i = 4; i < 7; i++) {
				ItemStack slot = this.getStackInSlot(i);
				if (!DCUtil.isEmpty(slot)) {
					boolean inRecipe = false;
					Iterator<Object> req = required.iterator();
					ItemStack cont = slot.getItem().getContainerItem(slot);

					// 9スロットについて、要求材料の数だけ回す
					while (req.hasNext()) {
						boolean match = false;
						Object next = req.next();
						int count = 1;

						if (next instanceof ItemStack) {
							count = ((ItemStack) next).getCount();
							match = OreDictionary.itemMatches((ItemStack) next, slot, false) && slot
									.getCount() >= count;
						} else if (next instanceof ArrayList) {
							ArrayList<ItemStack> list = new ArrayList<ItemStack>((ArrayList<ItemStack>) next);
							if (list != null && !list.isEmpty()) {
								for (ItemStack item : list) {
									boolean f = OreDictionary.itemMatches(item, slot, false) && slot.getCount() > 0;
									if (f) {
										match = true;
									}
								}
							}
						}

						if (match) {
							inRecipe = true;
							if (DCUtil.isEmpty(sec) && !DCUtil.isEmpty(cont)) {
								sec = cont.copy();
								chance = 100;
							}
							required.remove(next);
							this.decrStackSize(i, count);
							break;
						}
					}

					if (!inRecipe) {
						break;// 中断
					}
				}
			}

			if (outF != null) {
				outputT.fill(outF, true);
			}

			this.markDirty();
			return true;
		}
		return false;
	}

	@Override
	public boolean isSuitableClimate() {
		return current != null;
	}

	@Override
	public String climateSuitableMassage() {
		if (current == null)
			return "dcs.gui.message.nullclimate";
		else
			return "dcs.gui.message.suitableclimate";
	}

	@Override
	public int maxColor() {
		return 4;
	}

	/* ========== 以下、ISidedInventoryのメソッド ========== */

	@Override
	protected int[] slotsTop() {
		return new int[] {
				0,
				2,
				4,
				5,
				6
		};
	};

	@Override
	protected int[] slotsBottom() {
		return new int[] {
				1,
				3
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
				6
		};
	};

	@Override
	public List<ItemStack> getOutputs() {
		List<ItemStack> ret = new ArrayList<ItemStack>();
		return ret;
	}

	// スロット数
	@Override
	public int getSizeInventory() {
		return 7;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerFluidProcessor(this, playerInventory);
	}

	@Override
	public int getField(int id) {
		switch (id) {
		case 0:
			return this.currentBurnTime;
		case 1:
			return this.maxBurnTime;
		case 2:
			return this.current == null ? 0 : this.current.getClimateInt();

		case 3:
			return this.cap.milkID;
		case 4:
			return this.cap.sugarID;
		case 5:
			return this.milkCount;
		case 6:
			return this.sugarCount;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.currentBurnTime = value;
			break;
		case 1:
			this.maxBurnTime = value;
			break;
		case 2:
			this.current = ClimateAPI.register.getClimateFromInt(value);
			break;

		case 3:
			this.cap.milkID = (byte) value;
			break;
		case 4:
			this.cap.sugarID = (byte) value;
			break;
		case 5:
			this.milkCount = value;
			break;
		case 6:
			this.sugarCount = value;
			break;
		}
	}

	@Override
	public int getFieldCount() {
		return 7;
	}

	@Override
	public String getGuiID() {
		return "dcs_climate:fluidprocessor_steel";
	}

	// インベントリの名前
	@Override
	public String getName() {
		return "dcs.gui.device.teapot";
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == DrinkCapabilityHandler.DRINK_CUSTOMIZE_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == DrinkCapabilityHandler.DRINK_CUSTOMIZE_CAPABILITY)
			return (T) cap;
		return super.getCapability(capability, facing);
	}

	/* Packet,NBT */

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		this.milkCount = tag.getInteger("MilkCount");
		this.sugarCount = tag.getInteger("SugarCount");
		cap = cap.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		// 燃焼時間や調理時間などの書き込み
		tag.setInteger("MilkCount", this.milkCount);
		tag.setInteger("SugarCount", this.sugarCount);
		cap.writeToNBT(tag);
		return tag;
	}

	@Override
	public NBTTagCompound getNBT(NBTTagCompound tag) {
		super.getNBT(tag);
		tag.setInteger("MilkCount", this.milkCount);
		tag.setInteger("SugarCount", this.sugarCount);
		cap.writeToNBT(tag);
		return tag;
	}

	@Override
	public void setNBT(NBTTagCompound tag) {
		super.setNBT(tag);
		this.milkCount = tag.getInteger("MilkCount");
		this.sugarCount = tag.getInteger("SugarCount");
		cap = cap.readFromNBT(tag);
	}

}
