package mods.tesseract.endex.init;

import mods.tesseract.endex.Reference;
import mods.tesseract.endex.handlers.SoundHandler;
import mods.tesseract.endex.mod.armor.ArmourBase;
import mods.tesseract.endex.mod.armor.ArmourDModel;
import mods.tesseract.endex.mod.armor.ArmourModel;
import mods.tesseract.endex.mod.food.FoodChorusSoup;
import mods.tesseract.endex.mod.food.FoodDragonBerries;
import mods.tesseract.endex.mod.food.FoodEnderFlesh;
import mods.tesseract.endex.mod.items.*;
import mods.tesseract.endex.mod.tools.*;
import mods.tesseract.endex.mod.tools.axes.EndoriumAxe;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Materials
    public static final ToolMaterial TOOL_MAGNIFIER = EnumHelper.addToolMaterial("magnifier", 4, 256, 5.5F, 1.0F, 13);
    public static final ToolMaterial TOOL_END = EnumHelper.addToolMaterial("end", 5, 1024, 6.5F, 9.0F, 14);
    public static final ArmorMaterial ARMOUR_DRAGON = EnumHelper.addArmorMaterial("armour_dragon", Reference.MODID + ":dragon", 44, new int[]{6, 9, 10, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.0F);
    public static final ArmorMaterial ARMOUR_HELMET_D = EnumHelper.addArmorMaterial("armour_helmet_d", Reference.MODID + ":dragon_helmet", 44, new int[]{6, 9, 10, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.0F);

    //Items
    public static final Item INGOT_ENDORIUM = new ItemBase("endorium_ingot");
    public static final Item INGOT_WOLFRAMIUM = new ItemBase("wolframium_ingot");
    public static final Item SHARD_OBSIDIAN = new ItemBase("obsidian_shard");
    public static final ToolMaterial TOOL_ENDORIUM = EnumHelper.addToolMaterial("endorium", 4, 1024, 6.5F, 4.0F, 13).setRepairItem(new ItemStack(INGOT_ENDORIUM));
    public static final ToolMaterial TOOL_WOLFRAMIUM = EnumHelper.addToolMaterial("wolframium", 3, 512, 5.5F, 2.5F, 11).setRepairItem(new ItemStack(INGOT_WOLFRAMIUM));
    public static final Item NUGGET_ENDORIUM = new ItemBase("endorium_nugget");
    public static final Item DRAGONITE_SEEDS = new ItemDragonSeeds("dragonite_seeds");
    public static final Item ADVANCED_PEARL = new ItemAPearl("advanced_ender_pearl");
    public static final Item END_ESSENCE = new ItemBase("end_essence");
    public static final Item END_SHARD = new ItemBase("end_shard");
    public static final Item END_RUNE = new ItemLegendary("end_rune");
    public static final Item LORMYTE_CRYSTAL = new ItemBase("lormyte_crystal");
    public static final Item ENDER_STRING = new ItemLegendary("ender_string");
    public static final Item DRAGONITE_TEA = new ItemDragoniteTea("dragonite_tea");
    public static final Item ANGEL_FEATHER = new ItemBase("angel_feather");
    public static final Item DRAGON_SCALES = new ItemBase("dragon_scales");
    public static final Item DEATH_ESSENCE = new ItemBase("death_essence");
    public static final Item INFUSED_METALL = new ItemBase("infused_ingot");
    public static final Item SWORD_SHARD = new ItemBase("sword_shard");
    public static final Item CATALYST = new ItemCatalyst("catalyst");
    public static final Item RECORD = new ItemEndRecord("end_record", SoundHandler.THE_VOID);
    public static final Item NUGGET_WOLFRAMIUM = new ItemBase("wolframium_nugget");

    //Tools
    public static final Item PICKAXE_ENDORIUM = new ToolPickaxe("endorium_pickaxe", TOOL_ENDORIUM);
    public static final Item SWORD_ENDORIUM = new ToolSword("endorium_sword", TOOL_ENDORIUM);
    public static final Item HOE_ENDORIUM = new ToolHoe("endorium_hoe", TOOL_ENDORIUM);
    public static final Item AXE_ENDORIUM = new EndoriumAxe("endorium_axe", TOOL_ENDORIUM);
    public static final Item SHOVEL_ENDORIUM = new ToolShovel("endorium_shovel", TOOL_ENDORIUM);
    public static final Item ENDER_BOW = new ItemEnderBow("ender_bow", 10, 0, 1, 2);
    public static final Item ENDER_SWORD = new ItemEnderSword("ender_sword", TOOL_END);
    public static final Item ENDER_HOOK = new ItemDeather("magnifier", TOOL_MAGNIFIER);
    public static final Item PICKAXE_WOLFRAMIUM = new ToolPickaxe("wolframium_pickaxe", TOOL_WOLFRAMIUM);
    public static final Item SWORD_WOLFRAMIUM = new ToolSword("wolframium_sword", TOOL_WOLFRAMIUM);
    public static final Item HOE_WOLFRAMIUM = new ToolHoe("wolframium_hoe", TOOL_WOLFRAMIUM);
    public static final Item AXE_WOLFRAMIUM = new EndoriumAxe("wolframium_axe", TOOL_WOLFRAMIUM);
    public static final Item SHOVEL_WOLFRAMIUM = new ToolShovel("wolframium_shovel", TOOL_WOLFRAMIUM);
    public static final Item ENTROPY_WAND = new ToolEntropyWand("entropy_wand", TOOL_MAGNIFIER);

    //Armors
    public static final Item CHESTPLATE_DRAGON = new ArmourBase("dragon_chestplate", ARMOUR_DRAGON, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_DRAGON = new ArmourBase("dragon_leggings", ARMOUR_DRAGON, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_DRAGON = new ArmourBase("dragon_boots", ARMOUR_DRAGON, 1, EntityEquipmentSlot.FEET);
    public static final Item HELMET_DRAGON = new ArmourDModel("dragon_helmet", ARMOUR_HELMET_D, 1, EntityEquipmentSlot.HEAD);

    //Food
    public static final Item ENDER_FLESH = new FoodEnderFlesh("ender_flesh");
    public static final Item DRAGONITE_BERRIES = new FoodDragonBerries("dragonite_berries");
    public static final Item CHORUS_SOUP = new FoodChorusSoup(5, "chorus_soup");
}



