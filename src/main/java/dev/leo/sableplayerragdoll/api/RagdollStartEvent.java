package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.Event;

public class RagdollStartEvent extends Event {
    private final LivingEntity entity;
    private final RagdollLaunchOptions options;

    public RagdollStartEvent(LivingEntity entity, RagdollLaunchOptions options) {
        this.entity = entity;
        this.options = options;
    }

    public LivingEntity getEntity() {
        return this.entity;
    }

    public RagdollLaunchOptions getOptions() {
        return this.options;
    }
}