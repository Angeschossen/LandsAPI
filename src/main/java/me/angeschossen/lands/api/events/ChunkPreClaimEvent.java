package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChunkPreClaimEvent extends Event implements Cancellable {


    public int getX() {
        return 0;
    }

    public int getZ() {
        return 0;
    }

    @NotNull
    public String getWorldName() {
        return null;
    }

    @NotNull
    public LandPlayer getLandPlayer() {
        return null;
    }


    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
