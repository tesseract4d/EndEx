package mods.tesseract.endex.mod.items;

import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
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
}
