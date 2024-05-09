package mods.tesseract.endex.world.biomes;

import java.util.Random;

import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.world.feature.WorldGenEnderCanopy;
import mods.tesseract.endex.world.feature.WorldGenSurfacePatch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeStygianGrowth extends BiomeEndBase {
    public WorldGenerator endGrassRemoval = new WorldGenSurfacePatch(END_STONE, END_GRASS, 1);
    public WorldGenerator endCanopyTree = new WorldGenEnderCanopy(false);
    public WorldGenerator endLake = new WorldGenLakes(BlockInit.ACID);
    private static final IBlockState AIR = Blocks.AIR.getDefaultState();
    private static final IBlockState END_STONE = Blocks.END_STONE.getDefaultState();
    private static final IBlockState END_GRASS = BlockInit.STYGIAN_GRASS.getDefaultState();

    public BiomeStygianGrowth(BiomeProperties p) {
        super(p);
        topBlock = END_GRASS;
        fillerBlock = END_STONE;
        decorator = new BiomeEndDecorator();
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDecoratorEndBiomes();
    }

    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float currentTemperature) {
        return 0;
    }

    public void decorate(World world, Random rand, BlockPos pos) {
        if (rand.nextInt(16) == 0) {
            int x = rand.nextInt(8) + 16;
            int z = rand.nextInt(8) + 16;
            int h = getEndSurfaceHeight(world, pos.add(x, 0, z), 60, 70);
            if (h > 0)
                endLake.generate(world, rand, pos.add(x, h - 1, z));
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int r = rand.nextInt(100);
                if (r <= 17) {
                    int h = getEndSurfaceHeight(world, pos.add(x + 8, 0, z + 8), 52 - rand.nextInt(5), 70);
                    if (h > 0) {
                        BlockPos q = pos.add(x + 8, h + 1, z + 8);
                        if (r == 17)
                            world.setBlockState(q, BlockInit.STYGIAN_GLOW.getDefaultState());
                        else
                            world.setBlockState(q, BlockInit.STYGIAN_TALL_GRASS.getDefaultState());
                    }
                }
            }
        }


        if (rand.nextInt(7) != 0)
            endGrassRemoval.generate(world, rand, pos.add(8 + rand.nextInt(16), 0, 8 + rand.nextInt(16)));

        if (rand.nextFloat() < 0.2) {
            BlockPos p = pos.add(16, 0, 16);
            int h = getEndSurfaceHeight(world, p, 50, 70);
            if (h > 0) {
                endCanopyTree.generate(world, rand, p.up(h));
            }
        }

        super.decorate(world, rand, pos);
    }

}
