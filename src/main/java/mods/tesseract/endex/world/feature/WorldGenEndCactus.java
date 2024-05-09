package mods.tesseract.endex.world.feature;

import java.util.Random;

import mods.tesseract.endex.init.BlockInit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEndCactus extends WorldGenerator {
    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int height = 3 + rand.nextInt(5);

        if (world.getBlockState(pos) != BlockInit.END_DUST.getDefaultState()) {
            return false;
        }
        for (int y = 1; y <= height; y++)
            world.setBlockState(pos.add(0, y, 0), BlockInit.FIRETHORN.getDefaultState());

        return true;
    }

}
