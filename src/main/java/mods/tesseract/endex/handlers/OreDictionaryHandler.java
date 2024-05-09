package mods.tesseract.endex.handlers;

import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.ItemInit;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {

    public static void registerOres() {
    	OreDictionary.registerOre("ingotEndorium", ItemInit.INGOT_ENDORIUM);
        OreDictionary.registerOre("ingotTungsten", ItemInit.INGOT_WOLFRAMIUM);
        OreDictionary.registerOre("nuggetTungsten", ItemInit.NUGGET_WOLFRAMIUM);
        OreDictionary.registerOre("oreTungsten", BlockInit.WOLFRAMIUM_ORE);
        OreDictionary.registerOre("dustObsidian", ItemInit.CATALYST);
        OreDictionary.registerOre("shardObsidian", ItemInit.SHARD_OBSIDIAN);
        OreDictionary.registerOre("shardLormyte", ItemInit.LORMYTE_CRYSTAL);
        OreDictionary.registerOre("essence", ItemInit.END_ESSENCE);
        OreDictionary.registerOre("logWood", BlockInit.WYRMWOOD_LOG);
        OreDictionary.registerOre("planksWood", BlockInit.WYRMWOOD_PLANKS);
        OreDictionary.registerOre("treeSapling", BlockInit.WYRMWOOD_SAPLING);
    }

}
