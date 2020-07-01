package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChunkPostClaimEvent extends Event {

    public static HandlerList handlerList = new HandlerList();

    private LandPlayer landPlayer;
    private final int x, z;
    private final Land land;

    public ChunkPostClaimEvent(LandPlayer landPlayer, Land land, int x, int z) {
        super(true);

        this.landPlayer = landPlayer;
        this.land = land;
        this.x = x;
        this.z = z;
    }

    public Land getLand() {
        return land;
    }

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public LandPlayer getLandPlayer() {
        return landPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
