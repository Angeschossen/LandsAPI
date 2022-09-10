package me.angeschossen.lands.api.events.war;

import me.angeschossen.lands.api.war.War;
import me.angeschossen.lands.api.war.enums.WarResult;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WarEndEvent extends WarEvent {
    public static HandlerList handlerList = new HandlerList();
    private final WarResult warResult;

    public WarEndEvent(@NotNull War war, @NotNull WarResult warResult) {
        super(war);

        this.warResult = warResult;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public WarResult getResult() {
        return warResult;
    }

}
