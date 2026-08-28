package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.phys.Vec3;

public class RagdollLaunchOptions {

    public static final RagdollLaunchOptions DEFAULT = new RagdollLaunchOptions(Vec3.ZERO, 1.0f, false);

    private final Vec3 initialVelocity;
    private final float impulseStrength;
    private final boolean keepInventory;

    public RagdollLaunchOptions(Vec3 initialVelocity, float impulseStrength, boolean keepInventory) {
        this.initialVelocity = initialVelocity;
        this.impulseStrength = impulseStrength;
        this.keepInventory = keepInventory;
    }

    public Vec3 getInitialVelocity() {
        return initialVelocity;
    }

    public float getImpulseStrength() {
        return impulseStrength;
    }

    public boolean shouldKeepInventory() {
        return keepInventory;
    }
}