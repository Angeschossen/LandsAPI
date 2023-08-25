package me.angeschossen.lands.api.events.player;

import com.github.angeschossen.pluginframework.api.events.PlayerEvent;
import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.plugin.LandsEvent;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * Used for events that affect a land and might as well affect a player.
 */
public abstract class PlayerNullableEvent extends LandsEvent implements PlayerEvent {
    protected final @Nullable UUID playerUUID;
    protected @Nullable LandPlayer landPlayer;

    public PlayerNullableEvent(@Nullable LandPlayer landPlayer) {
        this.landPlayer = landPlayer;
        this.playerUUID = landPlayer == null ? null : landPlayer.getUID();
    }

    public PlayerNullableEvent(@Nullable UUID playerUUID) {
        this.landPlayer = playerUUID == null ? null : APIHandler.getInstance().getLegacySupport().getLandPlayer(playerUUID);
        this.playerUUID = playerUUID;
    }

    /**
     * Get the affected online player.
     * @return if null and {@link #getPlayerUID()} is null as well, no player is involved in this event
     */
    public @Nullable LandPlayer getLandPlayer() {
        return landPlayer;
    }

    /**
     * Get the affected player, which might be offline.
     * @return if null, no player is involved in this event
     */
    @Nullable
    public UUID getPlayerUID() {
        return playerUUID;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        if (landPlayer != null) {
            landPlayer.setAffectedPlayers("player_", builder);
        }else if(playerUUID != null){
            builder.put("player_self", Collections.singleton(playerUUID));
        }
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        if (landPlayer != null) {
            landPlayer.setExpressionVariables("player_", builder, getPlayerUID());
        } else if (playerUUID != null) {
            builder.put("player_name", APIHandler.getInstance().getPlayerUtils().getName(playerUUID))
                    .put("player_uuid", playerUUID);
        }
    }
}
