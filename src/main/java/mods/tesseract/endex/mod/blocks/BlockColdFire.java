package mods.tesseract.endex.mod.blocks;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockColdFire extends BlockFire implements IHasModel
{

    public BlockColdFire(String name)
    {
        super();
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(EndEx.endertab);

        BlockInit.BLOCKS.add(this);
    }

    @Override
    public void registerModels()
    {
        EndEx.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
       
        super.onEntityWalk(worldIn, pos, entityIn);
    }

}