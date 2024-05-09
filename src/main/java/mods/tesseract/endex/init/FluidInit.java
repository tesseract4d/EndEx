package mods.tesseract.endex.init;

import mods.tesseract.endex.Reference;
import mods.tesseract.endex.mod.blocks.BlockFluidAcid;
import mods.tesseract.endex.mod.fluid.FluidAcid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Locale;

@Mod.EventBusSubscriber
public class FluidInit {
    public static Fluid ACID;

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> e) {
        final IForgeRegistry<Block> r = e.getRegistry();
        ACID = registerFluid(new FluidAcid("acid", 0xFFFFFF));
        ACID.setDensity(1100).setLuminosity(5).setViscosity(900);
        BlockInit.ACID = registerClassicBlock(r, ACID);
    }

    public static Fluid registerFluid(Fluid f) {
        f.setUnlocalizedName(Reference.MODID + "." + f.getName());
        FluidRegistry.registerFluid(f);
        FluidRegistry.addBucketForFluid(f);
        return f;
    }

    public static BlockFluidBase registerClassicBlock(IForgeRegistry<Block> registry, Fluid fluid) {
        return registerBlock(registry, new BlockFluidAcid(fluid, Material.WATER), fluid.getName());
    }

    protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name) {
        if (!name.equals(name.toLowerCase(Locale.US))) {
            throw new IllegalArgumentException(
                    String.format("Unlocalized names need to be all lowercase! Block: %s", name));
        }

        String prefixedName = Reference.MODID + ":" + name;
        block.setTranslationKey(prefixedName);

        register(registry, block, name);
        return block;
    }

    protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, String name) {
        thing.setRegistryName(new ResourceLocation(Reference.MODID, "fluid." + name));
        registry.register(thing);
        return thing;
    }
}
