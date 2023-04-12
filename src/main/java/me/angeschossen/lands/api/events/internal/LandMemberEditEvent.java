package me.angeschossen.lands.api.events.internal;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerNullableEvent;
import me.angeschossen.lands.api.events.internal.plugin.TargetableEvent;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public abstract class LandMemberEditEvent extends LandsPlayerNullableEvent implements TargetableEvent {
    protected final UUID initiator, target;
    protected final Land land;
    protected final @Nullable
    Area area;

    public LandMemberEditEvent(Land land, @Nullable Area area, @NotNull UUID initiator, @NotNull UUID target) {
        super(initiator);

        this.initiator = initiator;
        this.target = target;
        this.land = land;
        this.area = area;
    }

    @Nullable
    public Area getArea() {
        return area;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    @NotNull
    @Deprecated
    public UUID getTargetUUID() {
        return getTargetUID();
    }

    @NotNull
    public UUID getTargetUID() {
        return target;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);

        builder.put("player_target", Collections.singleton(target));

        if (area != null) {
            area.setAffectedPlayers("area_", builder);
        } else {
            land.setAffectedPlayers("land_", builder);
        }
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("target_name", APIHandler.getInstance().getPlayerUtils().getName(target));
        builder.put("target_uuid", target);

        UUID uuid = getPlayerUID();
        if (area != null) {
            area.setExpressionVariables("area_", builder, uuid);
        } else {
            land.setExpressionVariables("land_", builder, uuid);
        }
    }
}
