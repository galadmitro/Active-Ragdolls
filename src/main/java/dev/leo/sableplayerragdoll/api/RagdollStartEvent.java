package dev.leo.sableplayerragdoll.api;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class RagdollStartEvent extends Event implements ICancellableEvent {

    private final Player player;
    private final RagdollLaunchOptions options;
    private boolean canceled = false;

    public RagdollStartEvent(Player player, RagdollLaunchOptions options) {
        this.player = player;
        this.options = options;
    }

    public Player getPlayer() {
        return player;
    }

    public RagdollLaunchOptions getOptions() {
        return options;
    }

    @Override
    public boolean isCanceled() {
        return canceled;
    }

    @Override
    public void setCanceled(boolean cancel) {
        this.canceled = cancel;
    }
}