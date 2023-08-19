package me.angeschossen.lands.api.events;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.land.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandRenameEvent extends LandEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private final String oldName;
    private final String newName;
    private boolean cancelled = false;

    public LandRenameEvent(LandPlayer landPlayer,@NotNull  Land land,@NotNull  String oldName,@NotNull  String newName) {
        super(land, landPlayer);

        this.oldName = oldName;
        this.newName = newName;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public String getCurrentName() {
        return oldName;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public String getNewName() {
        return newName;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("name_old", oldName);
        builder.put("name_new", newName);
    }
}
