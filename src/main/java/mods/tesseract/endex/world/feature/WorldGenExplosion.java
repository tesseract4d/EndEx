package mods.tesseract.endex.world.feature;

import mods.tesseract.endex.init.BlockInit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenExplosion extends WorldGenerator {
    private final float size;
    private final int density;

    public WorldGenExplosion(float size, int density) {
        this.size = size;
        this.density = density;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        //Set<BlockPos> set = Sets.<BlockPos>newHashSet();
        int d = density - 1;
        for (int j = 0; j < density; ++j) {
            for (int k = 0; k < density; ++k) {
                for (int l = 0; l < density; ++l) {
                    if (j == 0 || j == d || k == 0 || k == d || l == 0 || l == d) {
                        double d0 = (double) ((float) j / d * 2 - 1);
                        double d1 = (double) ((float) k / d * 2 - 1);
                        double d2 = (double) ((float) l / d * 2 - 1);
                        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                        d0 = d0 / d3;
                        d1 = d1 / d3;
                        d2 = d2 / d3;
                        float f = this.size * (0.7F + rand.nextFloat() * 0.6F);
                        double d4 = pos.getX();
                        double d6 = pos.getY();
                        double d8 = pos.getZ();

                        while (f > 0.0F) {
                            BlockPos q = new BlockPos(d4, d6, d8);
                            world.setBlockState(q, BlockInit.ESSENCE_ORE.getDefaultState());
                            f -= 0.225;
                            d4 += d0 * 0.3;
                            d6 += d1 * 0.3;
                            d8 += d2 * 0.3;
                        }
                    }
                }
            }
        }
        return false;
    }

}
