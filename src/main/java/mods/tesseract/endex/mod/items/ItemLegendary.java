package mods.tesseract.endex.mod.items;

import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLegendary extends Item implements IHasModel
{
    public ItemLegendary(String name)
    {
    	setTranslationKey(name);
    	setRegistryName(name);
    	setCreativeTab(EndEx.endertab);
    	
    	ItemInit.ITEMS.add(this);
    }

	@Override
	public void registerModels() 
	{
		EndEx.proxy.registerItemRenderer(this, 0, "inventory");
	}
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
	    return EnumRarity.RARE;
	}
}
