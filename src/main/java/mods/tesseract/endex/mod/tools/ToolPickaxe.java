package mods.tesseract.endex.mod.tools;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{

	public ToolPickaxe(String name, ToolMaterial material) {
		super(material);
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
