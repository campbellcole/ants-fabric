package net.boyaard.antarmy;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class EntityAnt extends PathAwareEntity implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    public EntityAnt(EntityType<? extends PathAwareEntity> type, World worldIn) {
        super(type, worldIn);
        this.ignoreCameraFrustum = true;
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8d));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    public static Builder createAntAttributes() {
        return EntityAnt.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bat.fly", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<EntityAnt>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }


}
