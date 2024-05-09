package mods.tesseract.endex.mod.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockInfested extends BlockEndLog {
    public BlockInfested(String name) {
        super(name);
        setHardness(1);
    }

    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        if (!worldIn.isRemote && worldIn.getGameRules().getBoolean("doTileDrops")) {
            Entity e = new EntityEndermite(worldIn);
            e.setLocationAndAngles((double) pos.getX() + 0.5F, (double) pos.getY() + 0.5F, (double) pos.getZ() + 0.5F, worldIn.rand.nextFloat() * 360.0F, 0.0F);
            worldIn.spawnEntity(e);
            e.spawnRunningParticles();
        }
    }
}
