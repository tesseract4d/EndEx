package mods.tesseract.endex.mod.blocks;

import javax.annotation.Nullable;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockEndCoral extends BlockEndTallGrass {
    protected static final AxisAlignedBB END_BUSH_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.400000011920929D, 0.8999999761581421D);

    public BlockEndCoral(String s) {
        super(s);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return END_BUSH_AABB;
    }

    @Override
    public void registerModels() {
        EndEx.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public boolean canSustain(Block p) {
        return p == Blocks.END_BRICKS || p == Blocks.END_STONE || p == BlockInit.STYGIAN_GRASS || p == BlockInit.END_DUST || p == BlockInit.END_GRAVEL || p == BlockInit.END_STONE_CHISELED || p == BlockInit.END_STONE_PILLAR || p == BlockInit.END_STONE_SMOOTH;
    }

    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

}