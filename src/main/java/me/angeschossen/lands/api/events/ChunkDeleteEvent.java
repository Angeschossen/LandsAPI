package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChunkDeleteEvent extends Event {

    @NotNull
    public Land getLand() {
        return null;
    }

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


    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
