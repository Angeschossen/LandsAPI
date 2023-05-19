package me.angeschossen.lands.api.events.land.spawn;

import me.angeschossen.lands.api.events.LandDeleteEvent;
import me.angeschossen.lands.api.events.internal.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This event is called each time the spawn is removed.
 * It mostly fires when an admin deletes world data or the world, in which the spawn was located
 * in doesn't exist any longer. This is not called upon land deletion.
 * If you want to handle this case too, just listen to {@link LandDeleteEvent}.
 */
public class LandSpawnRemoveEvent extends LandEvent {
    public static HandlerList handlerList = new HandlerList();
    private final Location current;

    public LandSpawnRemoveEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, @NotNull Location current) {
        super(land, landPlayer);

        this.current = current;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    /**
     * Get the current spawn.
     *
     * @return Location of the spawn
     */
    @NotNull
    public Location getCurrent() {
        return current;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}