package me.angeschossen.lands.api.events.war;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public class WarDeclareEvent extends LandsPlayerEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final @NotNull
    MemberHolder attacker, defender;
    private final LandPlayer sender;
    private boolean cancelled;

    public WarDeclareEvent(@NotNull MemberHolder attacker, LandPlayer sender, @NotNull MemberHolder defender) {
        super(sender);

        this.attacker = attacker;
        this.defender = defender;
        this.sender = sender;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
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
    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    @Deprecated
    public LandPlayer getSender() {
        return sender;
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
        attacker.setAffectedPlayers("war_attacker_", builder);
        defender.setAffectedPlayers("war_defender_",builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        UUID uuid = getPlayerUID();
        attacker.setExpressionVariables("war_attacker_", builder,uuid);
        defender.setExpressionVariables("war_defender_", builder, uuid);
    }

    @Override
    public String toString() {
        return "WarDeclareEvent{attacker=" + attacker.toString() + ",defender=" + defender.toString() + "}";
    }
}
