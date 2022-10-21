package me.angeschossen.lands.api.events.war;

import me.angeschossen.lands.api.war.War;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WarStartEvent extends WarEvent {
    public static HandlerList handlerList = new HandlerList();

    public WarStartEvent(@NotNull War war) {
        super(war);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
