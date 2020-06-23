package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChunkPostClaimEvent extends Event {



    @NotNull
    public Land getLand() {
        return null;
    }

    public int getZ() {
        return 0;
    }

    public int getX() {
        return 0;
    }

    @NotNull
    public LandPlayer getLandPlayer() {
        return null;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
