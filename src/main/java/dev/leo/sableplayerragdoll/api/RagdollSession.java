package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.LivingEntity;

public class RagdollSession {
    private final LivingEntity target;
    private final RagdollLaunchOptions options;
    private boolean active;

    public RagdollSession(LivingEntity target, RagdollLaunchOptions options) {
        this.target = target;
        this.options = options;
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return this.active;
    }

    public LivingEntity getTarget() {
        return this.target;
    }

    public RagdollLaunchOptions getOptions() {
        return this.options;
    }
}