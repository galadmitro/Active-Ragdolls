package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.LivingEntity;

public class RagdollAPI {
    public static RagdollSession startRagdoll(LivingEntity entity, RagdollLaunchOptions options) {
        RagdollSession session = new RagdollSession(entity, options);
        session.activate();
        return session;
    }
}