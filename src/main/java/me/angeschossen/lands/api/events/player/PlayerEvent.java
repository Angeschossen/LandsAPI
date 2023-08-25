package me.angeschossen.lands.api.events.player;

import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.UUID;

/**
 * Used for events that affect a player.
 */
public abstract class PlayerEvent extends PlayerNullableEvent {

    /**
     * Constructor
     * @param landPlayer the player that is online
     */
    public PlayerEvent(@NotNull LandPlayer landPlayer) {
        super(landPlayer);

        Objects.requireNonNull(landPlayer, "LandPlayer can't be null");
    }

    /**
     * Constructor
     * @param playerUUID UUID of the player, that might be offline
     */
    public PlayerEvent(@NotNull UUID playerUUID) {
        super(playerUUID);

        Objects.requireNonNull(playerUUID, "UUID can't be null");
    }

    /**
     * Get the player that is online
     * @return the affected player that is online
     */
    @Override
    @Nullable
    public final LandPlayer getLandPlayer() {
        return landPlayer;
    }

    /**
     * Get the player's UUID.
     * @return the player might be offline
     */
    @Override
    @Nullable
    public final UUID getPlayerUID() {
        return playerUUID;
    }
}
