package mods.tesseract.endex.handlers;

import mods.tesseract.endex.mod.entity.EntityChronologist;
import mods.tesseract.endex.mod.entity.EntityEGuard;
import mods.tesseract.endex.mod.entity.EntityLord;
import mods.tesseract.endex.mod.entity.EntityWatcher;
import mods.tesseract.endex.mod.entity.render.RenderChronologist;
import mods.tesseract.endex.mod.entity.render.RenderEGuard;
import mods.tesseract.endex.mod.entity.render.RenderLord;
import mods.tesseract.endex.mod.entity.render.RenderWatcher;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityEGuard.class, RenderEGuard::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, RenderWatcher::new);
	RenderingRegistry.registerEntityRenderingHandler(EntityLord.class, RenderLord::new);
	RenderingRegistry.registerEntityRenderingHandler(EntityChronologist.class, manager -> new RenderChronologist(manager));
}
}
