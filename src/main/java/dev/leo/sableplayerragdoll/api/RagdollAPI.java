package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.player.Player;

public class RagdollAPI {

    public static void startRagdoll(Player player, RagdollLaunchOptions options) {
        // Triggers the active ragdoll state for the target player
        RagdollSession session = new RagdollSession(player, options);
        session.start();
    }

    public static void stopRagdoll(Player player) {
        // Stops active ragdoll state and restores vanilla player controller
        RagdollSession.stop(player);
    }
}