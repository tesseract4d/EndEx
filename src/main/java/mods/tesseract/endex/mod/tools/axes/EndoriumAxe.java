package mods.tesseract.endex.mod.tools.axes;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.item.ItemAxe;

public class EndoriumAxe extends ItemAxe implements IHasModel
{

	public EndoriumAxe(String name, ToolMaterial material) {
		super(material, 9f, -3.1f);
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
