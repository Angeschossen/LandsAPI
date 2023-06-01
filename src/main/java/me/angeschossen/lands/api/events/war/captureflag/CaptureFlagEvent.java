package me.angeschossen.lands.api.events.war.captureflag;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.war.WarEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.captureflag.CaptureFlag;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public abstract class CaptureFlagEvent extends WarEvent implements Cancellable {
    protected final LandPlayer player;
    private boolean cancelled;
    protected final @NotNull CaptureFlag captureFlag;

    public CaptureFlagEvent(@NotNull CaptureFlag captureFlag, LandPlayer player) {
        super(captureFlag.getWar());

        this.player = player;
        this.captureFlag = captureFlag;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);

        player.setAffectedPlayers("placer_", builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        final UUID uuid = player.getUID();
        player.setExpressionVariables("placer_", builder, uuid);
        captureFlag.setExpressionVariables("flag_", builder, uuid);
    }
}
