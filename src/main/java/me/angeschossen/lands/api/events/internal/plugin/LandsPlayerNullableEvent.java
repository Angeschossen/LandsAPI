package me.angeschossen.lands.api.events.internal.plugin;

import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class LandsPlayerNullableEvent extends LandsEvent {
    protected final UUID playerUUID;
    protected LandPlayer landPlayer;

    public LandsPlayerNullableEvent(@Nullable LandPlayer landPlayer) {
        this.landPlayer = landPlayer;
        this.playerUUID = landPlayer == null ? null :landPlayer.getUID();
    }

    public LandsPlayerNullableEvent(@Nullable UUID playerUUID) {
        this.landPlayer = null;
        this.playerUUID = playerUUID;
    }

    public @Nullable LandPlayer getLandPlayer() {
        return landPlayer;
    }

    @Nullable
    public UUID getPlayerUID() {
        return playerUUID;
    }
}
