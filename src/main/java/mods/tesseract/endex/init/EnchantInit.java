package mods.tesseract.endex.init;

import mods.tesseract.endex.Reference;
import mods.tesseract.endex.mod.enchants.EnchantECore;
import mods.tesseract.endex.mod.enchants.EnchantEnder;
import mods.tesseract.endex.mod.enchants.EnchantSCore;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class EnchantInit {
	public static final Enchantment ender_core = new EnchantECore();
    public static final Enchantment ender_killer = new EnchantEnder();
	public static final Enchantment shulker_core = new EnchantSCore();
	
	@Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onEvent(final RegistryEvent.Register<Enchantment> event)
        {
           
            final IForgeRegistry<Enchantment> registry = event.getRegistry();
            
            registry.register(ender_core);
            registry.register(ender_killer);
            registry.register(shulker_core);
        }
    }
	
	public static final Enchantment[] helmetEnchants = new Enchantment[] {ender_core};
	public static final Enchantment[] chestplateEnchants = new Enchantment[] {ender_core};
	public static final Enchantment[] leggingsEnchants = new Enchantment[] {ender_core};
	public static final Enchantment[] bootsEnchants = new Enchantment[] {ender_core};
	
	public static final Enchantment[] swordEnchants = new Enchantment[] {shulker_core, ender_killer};
}
