package net.mcreator.stormlightmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.SprenbladeItem;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;

@StormlightModModElements.ModElement.Tag
public class HonorSprenRightClickedOnEntityProcedure extends StormlightModModElements.ModElement {
	public HonorSprenRightClickedOnEntityProcedure(StormlightModModElements instance) {
		super(instance, 123);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure HonorSprenRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure HonorSprenRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((sourceentity instanceof ServerPlayerEntity) && (sourceentity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) sourceentity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("minecraft:adventure/hero_of_the_village")))
						.isDone()
				: false)) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.radiantTrueFalse = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((!((sourceentity instanceof PlayerEntity)
					? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(SprenbladeItem.block, (int) (1)))
					: false))
					&& (((entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new StormlightModModVariables.PlayerVariables())).receivedSprenblade) == (false)))) {
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SprenbladeItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.receivedSprenblade = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
