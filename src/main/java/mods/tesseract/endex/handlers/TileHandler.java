package mods.tesseract.endex.handlers;

import mods.tesseract.endex.Reference;
import mods.tesseract.endex.mod.blocks.TileEntropyUser;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileHandler
{
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntropyUser.class, new ResourceLocation(Reference.MODID + ":entropy_user"));
    }
}
