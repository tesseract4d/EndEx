package mods.tesseract.endex.world.biomes;

import git.jbredwards.nether_api.api.world.INetherAPIChunkGenerator;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.mod.blocks.BlockEndTallGrass;
import mods.tesseract.endex.world.feature.WorldGenDune;
import mods.tesseract.endex.world.feature.WorldGenEndCactus;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;

import javax.annotation.Nonnull;
import java.util.Random;

public class BiomeEndDesert extends BiomeEndBase {
    private static final IBlockState END_DUST = BlockInit.END_DUST.getDefaultState();
    private static final IBlockState END_GRAVEL = BlockInit.END_GRAVEL.getDefaultState();
    private static final WorldGenerator endCactus = new WorldGenEndCactus();

    public BiomeEndDesert(BiomeProperties properties) {
        super(properties);
        topBlock = END_DUST;
        fillerBlock = END_GRAVEL;
        decorator = new BiomeEndDecorator();
    }

    @Override
    public void buildSurface(@Nonnull final INetherAPIChunkGenerator chunkGenerator, final int chunkX, final int chunkZ, @Nonnull final ChunkPrimer primer, final int x, final int z, final double terrainNoise) {
        Random rand = chunkGenerator.getRand();
        int d = -1;
        for (int y = chunkGenerator.getWorld().getActualHeight() - 1; y >= 0; --y) {
            final IBlockState here = primer.getBlockState(x, y, z);
            if (here.getMaterial() == Material.AIR) d = -1;
            else if (here.getBlock() == Blocks.END_STONE) {
                if (d == -1) {
                    d = 3 + rand.nextInt(2);
                    primer.setBlockState(x, y, z, topBlock);
                    int r = rand.nextInt(300);
                    if (r <= 25) {
                        if (r == 25)
                            primer.setBlockState(x, y + 1, z, BlockInit.BROKEN_FLOWER.getDefaultState());
                        else
                            primer.setBlockState(x, y + 1, z, BlockInit.END_CORAL.getDefaultState());
                    }
                } else if (d > 0) {
                    primer.setBlockState(x, y, z, d > 1 ? topBlock : fillerBlock);
                    --d;
                }
            }
        }
    }

    public void decorate(World world, Random rand, BlockPos pos) {
        if (rand.nextInt(2) == 0) {
            int x = rand.nextInt(8) + 16;
            int z = rand.nextInt(8) + 16;
            int h = getEndSurfaceHeight(world, pos.add(x, 0, z), 60, 80);
            if (h > 0) {
                BlockPos q = pos.add(x, 0, z);
                new WorldGenDune(rand.nextInt(5) + 9, rand.nextDouble()).generate(world, rand, q.up(h + 1));
                if (rand.nextInt(2) != 0) {
                    int a = 1 - rand.nextInt(2);
                    int c = 1 - rand.nextInt(2);
                    int b = getEndSurfaceHeight(world, q.add(a, 0, c), 50, 80);
                    if (b > 0)
                        endCactus.generate(world, rand, q.add(a, b, c));
                }
            }
        }

        if (rand.nextInt(3) == 0) {
            int x = rand.nextInt(8) + 16;
            int z = rand.nextInt(8) + 16;
            int h = getEndSurfaceHeight(world, pos.add(x, 0, z), 50, 80);
            if (h > 0) {
                endCactus.generate(world, rand, pos.add(x, h, z));
            }
        }
    }
}
