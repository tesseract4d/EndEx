package mods.tesseract.endex.world.biomes;

import git.jbredwards.nether_api.api.biome.IEndBiome;
import git.jbredwards.nether_api.api.world.INetherAPIChunkGenerator;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeEnd;
import net.minecraft.world.chunk.ChunkPrimer;

import javax.annotation.Nonnull;

public class BiomeEndBase extends BiomeEnd implements IEndBiome {
    public BiomeEndBase(BiomeProperties properties) {
        super(properties);
        topBlock = Blocks.END_STONE.getDefaultState();
        fillerBlock = Blocks.END_STONE.getDefaultState();
    }


    @Override
    public void buildSurface(@Nonnull final INetherAPIChunkGenerator chunkGenerator, final int chunkX, final int chunkZ, @Nonnull final ChunkPrimer primer, final int x, final int z, final double terrainNoise) {
        int d = -1;
        for (int y = chunkGenerator.getWorld().getActualHeight() - 1; y >= 0; --y) {
            final IBlockState here = primer.getBlockState(x, y, z);
            if (here.getMaterial() == Material.AIR) d = -1;
            else if (here.getBlock() == Blocks.END_STONE) {
                if (d == -1) {
                    d = 3 + chunkGenerator.getRand().nextInt(2);
                    primer.setBlockState(x, y, z, topBlock);
                } else if (d > 0) {
                    --d;
                    primer.setBlockState(x, y, z, fillerBlock);
                }
            }
        }
    }

    @Override
    public boolean generateChorusPlants(@Nonnull INetherAPIChunkGenerator chunkGenerator, int chunkX, int chunkZ, float islandHeight) {
        return false;
    }

    public static int getEndSurfaceHeight(World world, BlockPos pos, int min, int max) {
        int y = max;

        while (y >= min) {
            if (!world.isAirBlock(pos.up(y)))
                return y;
            y--;
        }
        return 0;
    }
}
