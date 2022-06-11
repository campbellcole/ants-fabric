package net.boyaard.antarmy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AntArmy implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(Consts.MODID);

	public static final EntityModelLayer MODEL_ANT_LAYER = new EntityModelLayer(new Identifier(Consts.MODID, "ant"), "main");

	public static EntityType<EntityAnt> ANT = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(Consts.MODID, "ant"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EntityAnt::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);

	public static final Item ANT_SPAWN_EGG = new SpawnEggItem(ANT, 3289650, 	5263440, new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ANT, EntityAnt.createAntAttributes());
		EntityRendererRegistry.register(AntArmy.ANT, AntRenderer::new);
		Registry.register(Registry.ITEM, new Identifier(Consts.MODID, "ant_spawn_egg"), ANT_SPAWN_EGG);
	}

}
