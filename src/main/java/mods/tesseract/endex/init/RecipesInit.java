package mods.tesseract.endex.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesInit 
{

	public static void init() 
	{
		GameRegistry.addSmelting(BlockInit.WOLFRAMIUM_ORE, new ItemStack(ItemInit.INGOT_WOLFRAMIUM, 1), 1.5f);
	}
}