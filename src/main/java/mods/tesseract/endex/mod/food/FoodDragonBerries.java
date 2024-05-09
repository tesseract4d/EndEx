package mods.tesseract.endex.mod.food;

import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.EndEx;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.item.ItemFood;


public class FoodDragonBerries extends ItemFood implements IHasModel {

    public FoodDragonBerries(String name) {
        super(1, 0.1F, false);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(EndEx.endertab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        EndEx.proxy.registerItemRenderer(this, 0, "inventory");
    }

}


