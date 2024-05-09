package mods.tesseract.endex.mod.blocks;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockEndGrass extends BlockBase {
    public BlockEndGrass(String name, Material material) {
        super(name, material);
        setHardness(3);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Blocks.END_STONE.getItemDropped(Blocks.END_STONE.getDefaultState(), rand, fortune);
    }

    @Override
    public void onPlantGrow(IBlockState state, World world, BlockPos pos, BlockPos source) {
        world.setBlockState(pos, Blocks.END_STONE.getDefaultState(), 2);
    }
}
