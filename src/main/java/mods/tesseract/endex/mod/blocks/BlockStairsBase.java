package mods.tesseract.endex.mod.blocks;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockStairsBase extends BlockStairs implements IHasModel
{

	public BlockStairsBase(String name, Block block)
	{
		super(block.getDefaultState());
		setTranslationKey(name);
		setHardness(block.getBlockHardness(block.getDefaultState(), null, null));
		setSoundType(block.getSoundType());
		setRegistryName(name);
		setCreativeTab(EndEx.endertab);
		useNeighborBrightness = true;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		EndEx.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}