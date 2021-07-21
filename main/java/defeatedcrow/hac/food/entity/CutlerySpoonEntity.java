package defeatedcrow.hac.food.entity;

import javax.annotation.Nullable;

import defeatedcrow.hac.core.base.FoodEntityBase;
import defeatedcrow.hac.food.FoodInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CutlerySpoonEntity extends FoodEntityBase {

	public CutlerySpoonEntity(World worldIn) {
		super(worldIn);
		this.setSize(0.25F, 0.125F);
	}

	public CutlerySpoonEntity(World worldIn, double posX, double posY, double posZ) {
		super(worldIn, posX, posY, posZ);
		this.setSize(0.25F, 0.125F);
	}

	public CutlerySpoonEntity(World worldIn, double posX, double posY, double posZ,
			@Nullable EntityPlayer player) {
		super(worldIn, posX, posY, posZ, player);
		this.setSize(0.25F, 0.125F);
	}

	@Override
	protected ItemStack[] drops() {
		return new ItemStack[] {
				new ItemStack(FoodInit.cutlery, 1, 1),
				new ItemStack(FoodInit.cutlery, 1, 1)
		};
	}

}
