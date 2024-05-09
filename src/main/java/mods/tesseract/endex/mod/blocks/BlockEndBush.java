package mods.tesseract.endex.mod.blocks;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockEndBush extends BlockBush implements IHasModel {
    public BlockEndBush(String s) {
        super();
        setTranslationKey(s);
        setRegistryName(s);
        setSoundType(SoundType.PLANT);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    protected static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.1, 0, 0.1, 0.9, 0.8, 0.9);

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock().isReplaceable(world, pos) && this.canSustain(world.getBlockState(pos.down()).getBlock());
    }

    @Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
        return this.canSustain(world.getBlockState(pos.down()).getBlock());
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BUSH_AABB;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public boolean canSustain(Block p) {
        return p == Blocks.END_STONE || p == BlockInit.STYGIAN_GRASS || p == BlockInit.CORRUPTED_END_STONE;
    }

    @Override
    public void registerModels() {
        EndEx.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
