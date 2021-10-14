package defeatedcrow.hac.main.tabs;

import defeatedcrow.hac.core.CreativeTabClimate;
import defeatedcrow.hac.main.MainInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabClimateEquips extends CreativeTabClimate {

	// クリエイティブタブのアイコン画像や名称の登録クラス
	public CreativeTabClimateEquips(String type) {
		super(type);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel() {
		return "HeatAndClimate:Clothing";
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(MainInit.clothes);
	}

}
