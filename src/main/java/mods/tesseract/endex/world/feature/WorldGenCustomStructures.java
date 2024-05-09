package mods.tesseract.endex.world.feature;

import java.util.Random;

import mods.tesseract.endex.handlers.ConfigsHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomStructures implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator generator,
                         IChunkProvider provider) {
        switch (world.provider.getDimension()) {
            case 1:
                if (ConfigsHandler.GENERAL.spawnEndRuines) {
                    generateStructure(new WorldGenStructure("end_deco"), world, rand, chunkX, chunkZ, 50 + rand.nextInt(15), ConfigsHandler.BALANCE.ruinesRare);
                }
                break;

            case 0:
                if (ConfigsHandler.GENERAL.spawnObservatory) {
                        generateStructure(new WorldGenStructure("observ"), world, rand, chunkX, chunkZ, 3, ConfigsHandler.BALANCE.obsRare);
                }
                break;
        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int y, int chance) {
        int x = (chunkX * 16) + rand.nextInt(15);
        int z = (chunkZ * 16) + rand.nextInt(15);
        BlockPos pos = new BlockPos(x, y, z);
        if (!world.isAirBlock(pos) && world.getWorldType() != WorldType.FLAT) {
            if (rand.nextInt(chance) == 0) {
                generator.generate(world, rand, pos);
            }
        }
    }
}

