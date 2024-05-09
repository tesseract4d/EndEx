package mods.tesseract.endex.mod.blocks;

import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockEndVine extends BlockVine implements IHasModel {

    public BlockEndVine(String name) {
        super();
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(EndEx.endertab);
        setSoundType(SoundType.PLANT);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        EndEx.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
