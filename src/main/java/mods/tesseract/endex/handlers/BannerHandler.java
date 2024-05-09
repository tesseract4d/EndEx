package mods.tesseract.endex.handlers;

import mods.tesseract.endex.init.ItemInit;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.common.util.EnumHelper;
public final class BannerHandler {

    public static void init() {
        Class<? extends Enum<?>> clazz = BannerPattern.class;
        addPattern(clazz, "rune", "run", new ItemStack(ItemInit.END_RUNE));
        addPattern(clazz, "end", "end", new ItemStack(Items.CHORUS_FRUIT_POPPED));
        addPattern(clazz, "pearl", "prl", new ItemStack(Items.ENDER_PEARL));
    }

    public static void addPattern(Class<? extends Enum<?>> clazz, String name, String id, ItemStack craftingItem) {
        name = "endex_" + name;
        id = "ex_" + id;
        EnumHelper.addEnum(clazz, name.toUpperCase(), new Class[] { String.class, String.class, ItemStack.class }, name, id, craftingItem);
    }
}