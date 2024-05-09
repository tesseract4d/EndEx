package mods.tesseract.endex.world;

import java.util.Random;

import mods.tesseract.endex.handlers.ConfigsHandler;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.world.feature.WorldGenLormyte;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
    private final WorldGenerator ore_end_essence;
    private final WorldGenerator ore_wolframium;
    private final WorldGenerator end_magma;
    private final WorldGenerator end_entropy;

    public OreGen() {
        ore_end_essence = new WorldGenMinable(BlockInit.ESSENCE_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.OBSIDIAN));
        ore_wolframium = new WorldGenMinable(BlockInit.WOLFRAMIUM_ORE.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.END_STONE));
        end_magma = new WorldGenMinable(BlockInit.END_MAGMA.getDefaultState(), 30, BlockMatcher.forBlock(Blocks.END_STONE));
        end_entropy = new WorldGenMinable(BlockInit.END_DUST.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.END_STONE));

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 1) {
            if (ConfigsHandler.GENERAL.spawnEssenceOre) {
                runGenerator(ore_end_essence, world, random, chunkX, chunkZ, ConfigsHandler.BALANCE.essenceRareEnd, 0, 256);
            }

            if (ConfigsHandler.GENERAL.decoratorEnd) {
                runGenerator(end_entropy, world, random, chunkX, chunkZ, 2, 0, 22);
                surfaceGenerator(end_magma, world, random, chunkX, chunkZ, 64);
            }
            if (ConfigsHandler.GENERAL.spawnWolframiumOre) {
                runGenerator(ore_wolframium, world, random, chunkX, chunkZ, ConfigsHandler.BALANCE.wolframiumRare, 0, 48);
            }
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
            throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chance; i++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            gen.generate(world, rand, new BlockPos(x, y, z));
        }
    }

    public void surfaceGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance) {
        if (rand.nextInt(chance) == 0) {
            int x = chunkX * 16 + rand.nextInt(16);
            int z = chunkZ * 16 + rand.nextInt(16);
            for (int i = 128; i > 0; i--) {
                BlockPos p = new BlockPos(x, i, z);
                if (!world.isAirBlock(p)) {
                    gen.generate(world, rand, p);
                }
            }
        }
    }

    private void runLormyteGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
            throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chance; i++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            gen.generate(world, rand, new BlockPos(x, y - 6, z));
        }
    }
}
