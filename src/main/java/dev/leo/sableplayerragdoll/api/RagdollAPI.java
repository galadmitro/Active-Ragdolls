package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.LivingEntity;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RagdollAPI {
    private static final Map<UUID, RagdollSession> SESSIONS = new ConcurrentHashMap<>();

    public static RagdollSession startRagdoll(LivingEntity entity, RagdollLaunchOptions options) {
        RagdollSession session = SESSIONS.computeIfAbsent(entity.getUUID(), id -> new RagdollSession(entity, options));
        session.activate();
        return session;
    }

    public static boolean isRagdolled(LivingEntity entity) {
        RagdollSession session = SESSIONS.get(entity.getUUID());
        return session != null && session.isActive();
    }
}