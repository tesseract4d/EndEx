package mods.tesseract.endex;

import mods.tesseract.endex.handlers.*;
import mods.tesseract.endex.init.*;
import mods.tesseract.endex.proxy.CommonProxy;
import mods.tesseract.endex.utils.DebugCommand;
import mods.tesseract.endex.world.OreGen;
import mods.tesseract.endex.world.feature.WorldGenCustomStructures;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class EndEx {
    public static final Logger LOGGER = LogManager.getLogger(Reference.MODID);
    public static final CreativeTabs endertab = new EndExTab("endertab");

    static
    {
        FluidRegistry.enableUniversalBucket();
    }

    @Instance(Reference.MODID)
    public static EndEx mod;

    @Instance
    public static EndEx instance;

    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());

        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        SoundHandler.preInit();
        EntitiesInit.init();
        ProjectileInit.initEntities();

        TileHandler.registerTileEntities();
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);

        if(e.getSide() == Side.CLIENT)
        {
            RenderHandler.registerEntityRenders();
            ProjectileInit.registerEntityRenderers();
        }

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e)
    {
        if (e.getSide() == Side.CLIENT && ConfigsHandler.GENERAL.spawnNewVillagers) {
            EndVillagerHandler.initIEVillagerTrades();
            EndVillagerHandler.initIEVillagerHouse();
        }
        RecipesInit.init();
        ChestsHandler.init();
        BannerHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(EndEx.instance, new GuiHandler());
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e){
        OreDictionaryHandler.registerOres();
        Blocks.FIRE.setFireInfo(BlockInit.WYRMWOOD_LOG,5,5);
        Blocks.FIRE.setFireInfo(BlockInit.WYRMWOOD_INFESTED,30,60);
        Blocks.FIRE.setFireInfo(BlockInit.WYRMWOOD_LEAVES,30,60);
        Blocks.FIRE.setFireInfo(BlockInit.WYRMWOOD_SAPLING,60,100);
        Blocks.FIRE.setFireInfo(BlockInit.STYGIAN_CREEPER, 15, 100);
    }

    @Mod.EventHandler
    public void startServer(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new DebugCommand()); //TODO delete
    }
}

