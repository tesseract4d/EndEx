package mods.tesseract.endex.mod.blocks;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockPillar extends BlockRotatedPillar implements IHasModel {

    public BlockPillar(String name, Material material) {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(EndEx.endertab);
        setSoundType(SoundType.STONE);
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 2);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        EndEx.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}

