package net.boyaard.antarmy;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AntModel extends AnimatedGeoModel<EntityAnt> {
    @Override
    public Identifier getModelResource(EntityAnt object) {
        return new Identifier(Consts.MODID, "geo/ant.geo.json");
    }

    @Override
    public Identifier getTextureResource(EntityAnt object) {
        return new Identifier(Consts.MODID, "textures/entity/ant/ant.png");
    }

    @Override
    public Identifier getAnimationResource(EntityAnt animatable) {
        return null;
    }
}
