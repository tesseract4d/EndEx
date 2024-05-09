package mods.tesseract.endex.proxy;

import mods.tesseract.endex.Reference;
import mods.tesseract.endex.init.EntitiesInit;
import mods.tesseract.endex.init.FluidInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	@SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
		registerFluidModel(FluidInit.ACID);
    	EntitiesInit.initModels();
    }

	private static final String FLUID_MODEL_PATH = Reference.MODID + ":fluid_block";

	private static void registerFluidModel(final Fluid fluid) {
		final Item item = Item.getItemFromBlock(fluid.getBlock());
		assert item != Items.AIR;

		ModelBakery.registerItemVariants(item);

		final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(FLUID_MODEL_PATH, fluid.getName());
		System.out.println(fluid.getName());

		ModelLoader.setCustomMeshDefinition(item, stack -> modelResourceLocation);

		ModelLoader.setCustomStateMapper( fluid.getBlock(), new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(final IBlockState state) {
				return modelResourceLocation;
			}
		});
	}
}
