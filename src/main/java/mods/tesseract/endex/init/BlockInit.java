package mods.tesseract.endex.init;

import mods.tesseract.endex.mod.blocks.*;
import mods.tesseract.endex.world.feature.WorldGenCorruptedTree;
import mods.tesseract.endex.world.feature.WorldGenEnderCanopy;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Material END_FORGE = (new Material(MapColor.STONE));

    public static final Block ENDORIUM_BLOCK = new BlockEndBase("endorium_block", Material.IRON);
    public static final Block END_STONE_SMOOTH = new BlockEndBase("end_stone_smooth", Material.ROCK);
    public static final Block END_STONE_PILLAR = new BlockPillar("end_stone_pillar", Material.ROCK);
    public static final Block PURPUR_LAMP = new LampBase("purpur_lamp", Material.ROCK);
    public static final Block ENDER_FLOWER = new EnderCropBase("crop_ender_flower");
    public static final Block DRAGON_BUSH = new DragonBush("crop_dragonite");
    public static final Block ESSENCE_ORE = new BlockEssenceOre("essence_ore", Material.ROCK);
    public static final Block PHANTOM_BLOCK = new BlockPhantom("phantom", Material.BARRIER, false);
    public static final Block END_DUST = new BlockEndSand("end_dust", Material.SAND);
    public static final Block END_GRAVEL = new BlockEndSand("end_gravel", Material.SAND);
    public static final Block LORMYTE_CRYSTAL = new BlockEndBase("lormyte_crystal_block", Material.ROCK);
    public static final Block SMOOTH_LORMYTE = new BlockEndBase("smooth_lormyte", Material.ROCK);
    public static final Block WOLFRAMIUM_BLOCK = new BlockEndBase("wolframium_block", Material.IRON);
    public static final Block WOLFRAMIUM_ORE = new BlockWolframiumOre("wolframium_ore", Material.ROCK);
    public static final Block BLOCK_RUNE = new BlockRune("rune_block", Material.ROCK);
    public static final Block END_MAGMA = new BlockEndMagma("end_magma");
    public static final Block END_FORGE1 = new BlockEndForge("end_forge");
    public static final Block DRAGON_ESSENCE = new BlockDragonEssence("dragon_essence");
    public static final Block BLOCK_E_USER = new BlockEntropyUser("entropy_user");
    public static final Block BROKEN_FLOWER = new BlockEndCoral("ender_flower");
    public static final Block END_CORAL = new BlockEndCoral("end_coral");
    public static final Block END_STONE_CHISELED = new BlockEndBase("chiseled_end_bricks", Material.ROCK);
    public static final Block COLD_FIRE = new BlockColdFire("end_fire");

    public static final Block STAIRS_END_BRICKS = new BlockStairsBase("e_end_bricks_stairs", Blocks.END_BRICKS);
    public static final Block STAIRS_SMOOTH_END_STONE = new BlockStairsBase("smooth_end_stone_stairs", BlockInit.END_STONE_SMOOTH);

    public static final Block WALL_END_BRICKS = new BlockWallBase("e_end_bricks_wall", Blocks.END_BRICKS);
    public static final Block WALL_PURPUR = new BlockWallBase("e_purpur_wall", Blocks.PURPUR_BLOCK);
    public static final Block WALL_SMOOTH_END_STONE = new BlockWallBase("smooth_end_stone_wall", BlockInit.END_STONE_SMOOTH);

    public static final Block WYRMWOOD_LOG = new BlockEndLog("wyrmwood_log");
    public static final Block WYRMWOOD_INFESTED = new BlockInfested("wyrmwood_infested");
    public static final Block WYRMWOOD_PLANKS = new BlockWood("wyrmwood_planks");
    public static final Block WYRMWOOD_SAPLING = new BlockEndSapling("wyrmwood_sapling") {
        @Override
        public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
            if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos))
                return;
            for (int i = -4; i < 5; i++) {
                for (int j = -4; j < 5; j++) {
                    if (!worldIn.getBlockState(pos.add(i, -1, j)).isFullBlock()) {
                        return;
                    }
                }
            }
            WorldGenerator tree = new WorldGenEnderCanopy(true);
            tree.generate(worldIn, rand, pos.up());
        }
    };
    public static final Block WYRMWOOD_LEAVES = new BlockEndLeaves("wyrmwood_leaves");
    public static final Block STYGIAN_GRASS = new BlockEndGrass("stygian_grass", Material.ROCK);
    public static final Block STYGIAN_CREEPER = new BlockEndVine("stygian_creeper").setHardness(0.2f);
    public static final Block STYGIAN_TALL_GRASS = new BlockEndTallGrass("stygian_tall_grass");
    public static final Block STYGIAN_GLOW = new BlockEndBush("stygian_glow").setLightLevel(5);
    public static final Block FIRETHORN = new BlockEndCactus("firethorn");
    public static final Block CORRUPTED_END_STONE = new BlockEndGrass("corrupted_end_stone", Material.ROCK);
    public static final Block CORRUPTED_TALL_GRASS = new BlockEndTallGrass("corrupted_tall_grass");
    public static final Block CORRUPTED_FERN = new BlockEndTallGrass("corrupted_fern");
    public static final Block CORRUPTED_FERN_2 = new BlockEndTallGrass("corrupted_fern_2");
    public static final Block CORRUPTED_LEAVES = new BlockEndLeaves("corrupted_leaves") {
        @Override
        public Item getItemDropped(IBlockState state, Random rand, int fortune) {
            return Item.getItemFromBlock(BlockInit.CORRUPTED_SAPLING);
        }
    };
    public static final BlockEndBush CORRUPTED_SAPLING = new BlockEndSapling("corrupted_sapling") {
        @Override
        public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
            if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos))
                return;
            WorldGenerator tree = new WorldGenCorruptedTree(true);
            tree.generate(worldIn, rand, pos);
        }
    };
    public static Block ACID;
}
