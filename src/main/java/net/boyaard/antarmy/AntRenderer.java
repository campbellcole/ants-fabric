package net.boyaard.antarmy;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AntRenderer extends GeoEntityRenderer<EntityAnt> {

    public AntRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AntModel());
    }

    @Override
    public Identifier getTexture(EntityAnt entity) {
        return new Identifier(Consts.MODID, "textures/entity/ant/ant.png");
    }
}
