package me.angeschossen.lands.api.events.player.database;

import me.angeschossen.lands.api.events.player.PlayerEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called once the player data of a player that just joined, is fully loaded.
 */
public class PlayerDataLoadedEvent extends PlayerEvent {
    public static final HandlerList handlerList = new HandlerList();

    /**
     * Create instaince
     *
     * @param landPlayer the joined player
     */
    public PlayerDataLoadedEvent(@NotNull LandPlayer landPlayer) {
        super(landPlayer);
    }

    /**
     * Get the joined player.
     *
     * @return never null
     */
    @Override
    public @NotNull LandPlayer getLandPlayer() {
        assert super.getLandPlayer() != null;
        return super.getLandPlayer();
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
