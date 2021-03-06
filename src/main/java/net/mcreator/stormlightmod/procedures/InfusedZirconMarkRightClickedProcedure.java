package net.mcreator.stormlightmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.stormlightmod.item.InfusedZirconMarkItem;
import net.mcreator.stormlightmod.item.DunZirconMarkItem;
import net.mcreator.stormlightmod.StormlightModModVariables;
import net.mcreator.stormlightmod.StormlightModModElements;

import java.util.Map;
import java.util.HashMap;

@StormlightModModElements.ModElement.Tag
public class InfusedZirconMarkRightClickedProcedure extends StormlightModModElements.ModElement {
	public InfusedZirconMarkRightClickedProcedure(StormlightModModElements instance) {
		super(instance, 283);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InfusedZirconMarkRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure InfusedZirconMarkRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			ItemStack _setval = new ItemStack(InfusedZirconMarkItem.block, (int) (1));
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sphereTypeInfused = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			ItemStack _setval = new ItemStack(DunZirconMarkItem.block, (int) (1));
			entity.getCapability(StormlightModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.sphereTypeDun = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			InfusedMarkRightClickedProcedure.executeProcedure($_dependencies);
		}
	}
}
