package me.angeschossen.lands.api.events.player;

import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public abstract class PlayerEvent extends PlayerNullableEvent {

    public PlayerEvent(@NotNull LandPlayer landPlayer) {
        super(landPlayer);

        Objects.requireNonNull(landPlayer, "LandPlayer can't be null");
    }

    public PlayerEvent(@NotNull UUID playerUUID) {
        super(playerUUID);

        Objects.requireNonNull(playerUUID, "UUID can't be null");
    }

    @Override
    public final @NotNull LandPlayer getLandPlayer() {
        return landPlayer;
    }

    @Override
    @NotNull
    public final UUID getPlayerUID() {
        return playerUUID;
    }
}
