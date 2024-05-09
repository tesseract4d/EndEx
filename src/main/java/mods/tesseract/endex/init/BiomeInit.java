package mods.tesseract.endex.init;

import mods.tesseract.endex.world.biomes.BiomeCorruption;
import mods.tesseract.endex.world.biomes.BiomeEndBase;
import mods.tesseract.endex.world.biomes.BiomeEndDesert;
import mods.tesseract.endex.world.biomes.BiomeStygianGrowth;
import mods.tesseract.endex.world.feature.WorldGenLormyte;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Random;

import static net.minecraft.entity.EnumCreatureType.MONSTER;


public class BiomeInit {
    public static Biome STYGIAN_GROWTH;
    public static Biome END_DESERT;
    public static Biome OUTER;
    public static Biome CORRUPTION;

    public static void registerBiomes() {
        STYGIAN_GROWTH = registerBiome(new BiomeStygianGrowth(new BiomeProperties("Stygian Growth").setTemperature(Biomes.SKY.getDefaultTemperature()).setRainfall(Biomes.SKY.getRainfall()).setRainDisabled()), "stygian_growth", Type.END);
        END_DESERT = registerBiome(new BiomeEndDesert(new BiomeProperties("End Desert").setTemperature(Biomes.SKY.getDefaultTemperature()).setRainfall(Biomes.SKY.getRainfall()).setRainDisabled()), "end_desert", Type.END);
        OUTER = registerBiome(new BiomeEndBase(new BiomeProperties("Outer").setTemperature(Biomes.SKY.getDefaultTemperature()).setRainfall(Biomes.SKY.getRainfall()).setRainDisabled()) {
            private final WorldGenerator lormytee = new WorldGenLormyte(7, 5);

            public void decorate(World world, Random rand, BlockPos pos) {
                lormytee.generate(world, rand, pos.add(8 + rand.nextInt(16), rand.nextInt(10) + 30, 8 + rand.nextInt(16)));
                if (rand.nextFloat() < 0.2) {
                    BlockPos q = pos.add(8 + rand.nextInt(16), 0, 8 + rand.nextInt(16));
                    int h = getEndSurfaceHeight(world, q, 50, 70);
                    if (h > 0) {
                        lormytee.generate(world, rand, q.up(h - rand.nextInt(3)));
                    }
                }
            }
        }, "outer", Type.END);
        OUTER.getSpawnableList(MONSTER).clear();
        CORRUPTION = registerBiome(new BiomeCorruption(new BiomeProperties("Corruption").setTemperature(Biomes.SKY.getDefaultTemperature()).setRainfall(Biomes.SKY.getRainfall()).setRainDisabled()), "corruption", Type.END);
        CORRUPTION.getSpawnableList(MONSTER).add(new Biome.SpawnListEntry(EntitySilverfish.class, 25, 4, 4));
    }

    private static Biome registerBiome(Biome biome, String name, Type... types) {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        return biome;
    }
}
