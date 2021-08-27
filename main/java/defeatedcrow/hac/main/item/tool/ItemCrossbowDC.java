package defeatedcrow.hac.main.item.tool;

import javax.annotation.Nullable;

import defeatedcrow.hac.core.base.ITexturePath;
import defeatedcrow.hac.core.util.DCUtil;
import defeatedcrow.hac.main.MainInit;
import defeatedcrow.hac.main.config.MainCoreConfig;
import defeatedcrow.hac.main.entity.EntityIronBolt;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCrossbowDC extends ItemBow implements ITexturePath {

	public ItemCrossbowDC() {
		this.maxStackSize = 1;
		this.setMaxDamage(512);
		this.setFull3D();
	}

	@Override
	public String getTexPath(int meta, boolean isFull) {
		return "dcs_climate:items/tool/crossbow_iron";
	}

	public ItemStack findAmmo(EntityPlayer player) {
		if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
			return player.getHeldItem(EnumHand.OFF_HAND);
		} else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
			return player.getHeldItem(EnumHand.MAIN_HAND);
		} else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isArrow(itemstack)) {
					return itemstack;
				}
			}

			return ItemStack.EMPTY;
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		boolean flag = !this.findAmmo(playerIn).isEmpty();

		if (!playerIn.capabilities.isCreativeMode && !flag) {
			return flag ? new ActionResult(EnumActionResult.PASS, itemstack) : new ActionResult(EnumActionResult.FAIL,
					itemstack);
		} else {
			playerIn.setActiveHand(handIn);
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}
	}

	@Override
	protected boolean isArrow(@Nullable ItemStack stack) {
		return !DCUtil.isEmpty(stack) && stack.getItem() == MainInit.cartridge && stack.getItemDamage() == 0;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase living, int timeLeft) {
		if (living instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) living;
			boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper
					.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack ammo = this.findAmmo(player);

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			if (i < 0)
				return;

			if (!DCUtil.isEmpty(ammo) || flag) {

				float f = getArrowVelocity(i);

				if (f >= 0.0D) {

					EntityIronBolt entityarrow = new EntityIronBolt(world, player);
					entityarrow.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, 3.0F, 1.0F);

					if (!world.isRemote) {
						int power = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
						int punch = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						int flame = EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack);

						if (power > 0) {
							double pow = power + 5.0D;
							pow *= 0.2D;
							double damage = entityarrow.getDamage() * pow * 2;
							entityarrow.setDamage(damage);
						}

						if (punch > 0) {
							entityarrow.setKnockbackStrength(punch);
						}

						if (flame > 0) {
							entityarrow.setFire(100);
						}

						stack.damageItem(1, player);

						world.spawnEntity(entityarrow);
					}

					if (MainCoreConfig.sound_gun > 0D)
						world.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, (float) MainCoreConfig.sound_gun, 1.0F / (itemRand
								.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

					if (!flag) {
						DCUtil.reduceStackSize(ammo, 1);
					}

					player.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
	}

}
