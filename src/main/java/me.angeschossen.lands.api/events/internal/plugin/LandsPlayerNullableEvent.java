package me.angeschossen.lands.api.events.internal.plugin;

import com.github.angeschossen.pluginframework.api.events.PlayerEvent;
import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public abstract class LandsPlayerNullableEvent extends LandsEvent implements PlayerEvent {
    protected final UUID playerUUID;
    protected LandPlayer landPlayer;

    public LandsPlayerNullableEvent(@Nullable LandPlayer landPlayer) {
        this.landPlayer = landPlayer;
        this.playerUUID = landPlayer == null ? null : landPlayer.getUID();
    }

    public LandsPlayerNullableEvent(@Nullable UUID playerUUID) {
        this.landPlayer = playerUUID == null ? null : APIHandler.getInstance().getLegacySupport().getLandPlayer(playerUUID);
        this.playerUUID = playerUUID;
    }

    protected static String parsePrefix(String prefix) {
        return StringUtils.toLowerCase(prefix);
    }

    public @Nullable LandPlayer getLandPlayer() {
        return landPlayer;
    }

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
