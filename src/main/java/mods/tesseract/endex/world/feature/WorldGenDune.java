package mods.tesseract.endex.world.feature;

import mods.tesseract.endex.init.BlockInit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenDune extends WorldGenerator {
    public final double radius;
    public final double scale;

    public WorldGenDune(double l, double s) {
        radius = l;
        scale = s;
    }

    @Override
    public boolean generate(World w, Random r, BlockPos p) {
        Random a = new Random(r.nextLong());
        double b = a.nextDouble() * 2 * Math.PI, c = Math.cos(b), d = Math.sin(b);
        double rx = radius, rz = radius * scale;
        for (double x = -rx; x < rx; x += 0.5) {
            for (double z = -rz; z < rz; z += 0.5) {
                double x1 = x, z1 = z / scale;
                //double x1 = x0 * c + z0 * d, z1 = x0 * d + z0 * c;
                double l = radius - Math.sqrt(x1 * x1 + z1 * z1);
                if (l > 0) {
                    BlockPos q = p.add(x * c - z * d, 0, z * c + x * d);
                    for (int y = 0; y < Math.sqrt(l) * 2; y++) {
                        w.setBlockState(q.up(y), BlockInit.END_DUST.getDefaultState());
                    }
                }
            }
        }
        return true;
    }
}
