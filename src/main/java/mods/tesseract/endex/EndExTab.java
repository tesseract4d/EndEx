package mods.tesseract.endex;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EndExTab extends CreativeTabs
{

	public EndExTab(String label)
	{
		super("endertab");
	}
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(Items.ENDER_PEARL);
	}

}
