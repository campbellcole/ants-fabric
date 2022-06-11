package net.boyaard.antarmy.block;

import net.boyaard.antarmy.Consts;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

class AnthillItemModel extends AnimatedGeoModel<AnthillBlockItem> {

    @Override
    public Identifier getModelResource(AnthillBlockItem object) {
        return new Identifier(Consts.MODID, "geo/anthill.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnthillBlockItem object) {
        return new Identifier(Consts.MODID, "textures/item/anthill/anthill.png");
    }

    @Override
    public Identifier getAnimationResource(AnthillBlockItem animatable) {
        return null;
    }
}

public class AnthillBlockItemRenderer extends GeoItemRenderer<AnthillBlockItem> {
    public AnthillBlockItemRenderer() {
        super(new AnthillItemModel());
    }
}
