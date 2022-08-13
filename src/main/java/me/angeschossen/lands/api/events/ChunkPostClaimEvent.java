package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChunkPostClaimEvent extends Event {

    public static HandlerList handlerList = new HandlerList();

    private final @Nullable LandPlayer landPlayer;
    private final int x, z;
    private final Land land;
    private final LandWorld world;

    public ChunkPostClaimEvent(@Nullable LandPlayer landPlayer, Land land, LandWorld landWorld, int x, int z) {
        super(!Bukkit.isPrimaryThread());

        this.landPlayer = landPlayer;
        this.land = land;
        this.x = x;
        this.world = landWorld;
        this.z = z;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    public int getZ() {
        return z;
    }

    @NotNull
    public LandWorld getWorld() {
        return world;
    }

    public int getX() {
        return x;
    }

    @Nullable
    public LandPlayer getLandPlayer() {
        return landPlayer;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
