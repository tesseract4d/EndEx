package mods.tesseract.endex.handlers;

import git.jbredwards.nether_api.api.event.NetherAPIRegistryEvent;
import git.jbredwards.nether_api.mod.common.compat.nethercraft.BiomeNethercraft;
import git.jbredwards.nether_api.mod.common.registry.NetherAPIRegistry;
import mods.tesseract.endex.init.BiomeInit;
import mods.tesseract.endex.init.BlockInit;
import mods.tesseract.endex.init.FluidInit;
import mods.tesseract.endex.init.ItemInit;
import mods.tesseract.endex.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        //FluidInit.registerFluids();
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
        TileHandler.registerTileEntities();
    }

    @SubscribeEvent
    static void onBiomeRegister(RegistryEvent.Register<Biome> event) {
        BiomeInit.registerBiomes();
    }

    @SubscribeEvent
    static void onEndBiomeRegister(NetherAPIRegistryEvent.End event) {
        event.registry.registerBiome(BiomeInit.STYGIAN_GROWTH, 100);
        event.registry.registerBiome(BiomeInit.END_DESERT, 100);
        event.registry.registerBiome(BiomeInit.OUTER, 200);
        event.registry.registerBiome(BiomeInit.CORRUPTION, 50);
        //event.registry.removeBiome(Biomes.SKY);
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : BlockInit.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }
}

