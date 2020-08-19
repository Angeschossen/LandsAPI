package me.angeschossen.lands.api.events.war;

import me.angeschossen.lands.api.war.entity.WarEntity;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WarDeclareEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final @NotNull
    WarEntity attacker, defender;
    private boolean cancelled;

    public WarDeclareEvent(@NotNull WarEntity attacker, @NotNull WarEntity defender) {
        super(!Bukkit.isPrimaryThread());

        this.attacker = attacker;
        this.defender = defender;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public WarEntity getAttacker() {
        return attacker;
    }

    @NotNull
    public WarEntity getDefender() {
        return defender;
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
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public String toString() {
        return "WarDeclareEvent{attacker=" + attacker.toString() + ",defender=" + defender.toString() + "}";
    }
}
