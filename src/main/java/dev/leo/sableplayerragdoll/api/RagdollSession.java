package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;

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
        if (this.target != null) {
            this.target.setPose(Pose.SWIMMING);
            this.target.setForcedPose(Pose.SWIMMING);
        }
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