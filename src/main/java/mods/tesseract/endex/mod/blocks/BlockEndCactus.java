package mods.tesseract.endex.mod.blocks;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEndCactus extends BlockCactus implements IHasModel {
    protected static final AxisAlignedBB CACTUS_COLLISION_AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.9375D, 0.8125D);
    protected static final AxisAlignedBB CACTUS_AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 1.0D, 0.8125D);

    public BlockEndCactus(String name) {
        super();
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(EndEx.endertab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public boolean canBlockStay(World worldIn, BlockPos pos) {
        Block b = worldIn.getBlockState(pos.down()).getBlock();
        return b == BlockInit.FIRETHORN || b == BlockInit.END_DUST || b == BlockInit.END_GRAVEL;
    }

    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return CACTUS_COLLISION_AABB;
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
        return CACTUS_AABB.offset(pos);
    }

    @Override
    public void registerModels() {
        ModelLoader.setCustomStateMapper(this, (new StateMap.Builder()).ignore(new IProperty[]{AGE}).build());
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
