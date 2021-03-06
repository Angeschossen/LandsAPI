package me.angeschossen.lands.api.events.war;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WarDeclareEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final @NotNull
    MemberHolder attacker, defender;
    private final LandPlayer sender;
    private boolean cancelled;

    public WarDeclareEvent(@NotNull MemberHolder attacker, @NotNull LandPlayer sender, @NotNull MemberHolder defender) {
        super(!Bukkit.isPrimaryThread());

        this.attacker = attacker;
        this.defender = defender;
        this.sender = sender;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public LandPlayer getSender() {
        return sender;
    }

    @NotNull
    public MemberHolder getAttacker() {
        return attacker;
    }

    @NotNull
    public MemberHolder getDefender() {
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
