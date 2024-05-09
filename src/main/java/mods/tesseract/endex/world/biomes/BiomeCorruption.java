package mods.tesseract.endex.world.biomes;

import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.world.feature.WorldGenCorruptedTree;
import mods.tesseract.endex.world.feature.WorldGenEndBlob;
import mods.tesseract.endex.world.feature.WorldGenEnderCanopy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeCorruption extends BiomeEndBase {
    public WorldGenerator corruptedTree = new WorldGenCorruptedTree(false);
    public WorldGenerator blob = new WorldGenEndBlob(Blocks.MONSTER_EGG, 1);
    private static final IBlockState CORRUPTED_END_STONE = BlockInit.CORRUPTED_END_STONE.getDefaultState();

    public BiomeCorruption(BiomeProperties properties) {
        super(properties);
        topBlock = CORRUPTED_END_STONE;
    }

    public void decorate(World world, Random rand, BlockPos pos) {
        if (rand.nextInt(4) == 0) {
            BlockPos p = pos.add(rand.nextInt(8) + 16, 0, rand.nextInt(8) + 16);
            int h = getEndSurfaceHeight(world, p, 50, 70);
            if (h > 0 && world.getBlockState(p.up(h)) == CORRUPTED_END_STONE) {
                blob.generate(world, rand, p.up(h + 2));
            }
        }
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                BlockPos p = pos.add(x + 8, 0, z + 8);
                int h = getEndSurfaceHeight(world, p, 30, 70);
                if (h > 0) {
                    BlockPos q = p.up(h);
                    if (rand.nextFloat() < 0.2) {
                        if (world.getBlockState(q) == CORRUPTED_END_STONE) {
                            q = q.up();
                            switch (rand.nextInt(10)) {
                                case 0:
                                    world.setBlockState(q, BlockInit.CORRUPTED_FERN.getDefaultState());
                                    break;
                                case 1:
                                    world.setBlockState(q, BlockInit.CORRUPTED_FERN_2.getDefaultState());
                                    break;
                                default:
                                    world.setBlockState(q, BlockInit.CORRUPTED_TALL_GRASS.getDefaultState());
                            }
                        }
                    } else if (h >= 50 && rand.nextFloat() < 0.1) {
                        corruptedTree.generate(world, rand, q.up());
                    }
                }
            }
        }
    }
}
