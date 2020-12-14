
package net.mcreator.stormlightmod.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.stormlightmod.StormlightModModElements;

@StormlightModModElements.ModElement.Tag
public class DoubleeyeOFTheAlmightyPainting extends StormlightModModElements.ModElement {
	public DoubleeyeOFTheAlmightyPainting(StormlightModModElements instance) {
		super(instance, 389);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(160, 48).setRegistryName("doubleeye_of_the_almighty"));
	}
}
