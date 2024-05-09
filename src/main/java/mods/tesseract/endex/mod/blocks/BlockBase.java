package mods.tesseract.endex.mod.blocks;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public abstract class BlockBase extends Block implements IHasModel
{

	public BlockBase(String name, Material material)
	{
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(EndEx.endertab);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		EndEx.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
