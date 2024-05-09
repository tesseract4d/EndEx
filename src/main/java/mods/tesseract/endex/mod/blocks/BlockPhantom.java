package mods.tesseract.endex.mod.blocks;

import java.util.Random;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPhantom extends BlockBreakable implements IHasModel
{

	public BlockPhantom(String name, Material material, boolean ignoreSimilarity)
	{
		super(material, ignoreSimilarity);
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
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    public boolean isFullCube(IBlockState state)
    {
        return true;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
    public int quantityDropped(Random random)
    {
        return 0;
    }
	@Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
}
