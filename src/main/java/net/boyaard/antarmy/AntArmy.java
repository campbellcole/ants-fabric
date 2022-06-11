package net.boyaard.antarmy;

import net.boyaard.antarmy.block.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class AntArmy implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(Consts.MODID);

	public static EntityType<EntityAnt> ANT;

	public static Item ANT_SPAWN_EGG;
	public static final Block ANTHILL_BLOCK = new Anthill();
	public static BlockEntityType<AnthillBlockEntity> ANTHILL_BLOCK_ENTITY;
	public static final Item ANTHILL_BLOCK_ITEM = new AnthillBlockItem();

	@Override
	public void onInitialize() {
		ANT = Registry.register(
				Registry.ENTITY_TYPE,
				new Identifier(Consts.MODID, "ant"),
				FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EntityAnt::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
		);
		ANT_SPAWN_EGG = new SpawnEggItem(ANT, 3289650, 	5263440, new Item.Settings().group(ItemGroup.MISC));
		FabricDefaultAttributeRegistry.register(ANT, EntityAnt.createAntAttributes());
		EntityRendererRegistry.register(AntArmy.ANT, AntRenderer::new);
		Registry.register(Registry.BLOCK, new Identifier(Consts.MODID, "anthill"), ANTHILL_BLOCK);
		ANTHILL_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Consts.MODID, "anthill_block_entity"), FabricBlockEntityTypeBuilder.create(AnthillBlockEntity::new, ANTHILL_BLOCK).build(null));
		BlockEntityRendererRegistry.register(AntArmy.ANTHILL_BLOCK_ENTITY, (BlockEntityRendererFactory.Context rendererDispatcherIn) -> new AnthillRenderer());
		Registry.register(Registry.ITEM, new Identifier(Consts.MODID, "anthill"), ANTHILL_BLOCK_ITEM);
		GeoItemRenderer.registerItemRenderer(ANTHILL_BLOCK_ITEM, new AnthillBlockItemRenderer());
		Registry.register(Registry.ITEM, new Identifier(Consts.MODID, "ant_spawn_egg"), ANT_SPAWN_EGG);
	}



}
