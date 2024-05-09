package mods.tesseract.endex.mod.tools;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel
{

	public ToolSword(String name, ToolMaterial material) {
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
