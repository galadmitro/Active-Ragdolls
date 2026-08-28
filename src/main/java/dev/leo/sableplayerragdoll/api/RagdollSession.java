package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.player.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RagdollSession {

    private static final Map<UUID, RagdollSession> ACTIVE_SESSIONS = new HashMap<>();

    private final Player player;
    private final RagdollLaunchOptions options;

    public RagdollSession(Player player, RagdollLaunchOptions options) {
        this.player = player;
        this.options = options;
    }

    public void start() {
        ACTIVE_SESSIONS.put(player.getUUID(), this);
    }

    public static void stop(Player player) {
        ACTIVE_SESSIONS.remove(player.getUUID());
    }

    public static boolean isRagdolled(Player player) {
        return ACTIVE_SESSIONS.containsKey(player.getUUID());
    }

    public Player getPlayer() {
        return player;
    }

    public RagdollLaunchOptions getOptions() {
        return options;
    }
}