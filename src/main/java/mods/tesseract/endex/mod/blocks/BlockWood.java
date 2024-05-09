package mods.tesseract.endex.mod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;

public class BlockWood extends BlockBase {

    public BlockWood(String name) {
        super(name, Material.WOOD);
        setSoundType(SoundType.WOOD);
        setHardness(3.0F);
        setHarvestLevel("axe", 1);
    }

    @Override
    public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return true;
    }
}
