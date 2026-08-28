package dev.leo.activeragdolls.api;

import net.minecraft.world.phys.Vec3;

public record RagdollLaunchOptions(Vec3 impulse, float force, boolean preserveVelocity) {
    public static final RagdollLaunchOptions DEFAULT = new RagdollLaunchOptions(Vec3.ZERO, 1.0f, true);
}