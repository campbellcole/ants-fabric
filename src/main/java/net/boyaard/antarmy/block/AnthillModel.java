package net.boyaard.antarmy.block;

import net.boyaard.antarmy.Consts;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnthillModel extends AnimatedGeoModel<AnthillBlockEntity> {

    @Override
    public Identifier getModelResource(AnthillBlockEntity object) {
        return new Identifier(Consts.MODID, "geo/anthill.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnthillBlockEntity object) {
        return new Identifier(Consts.MODID, "textures/block/anthill/anthill.png");
    }

    @Override
    public Identifier getAnimationResource(AnthillBlockEntity animatable) {
        return null;
    }
}
