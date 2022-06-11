package net.boyaard.antarmy.block;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class AnthillRenderer extends GeoBlockRenderer<AnthillBlockEntity> {
    public AnthillRenderer() {
        super(new AnthillModel());
    }
}
