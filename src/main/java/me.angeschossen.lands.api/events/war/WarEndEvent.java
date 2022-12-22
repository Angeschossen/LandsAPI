package me.angeschossen.lands.api.events.war;

import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.war.War;
import me.angeschossen.lands.api.war.enums.WarResult;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class WarEndEvent extends WarEvent {
    public static HandlerList handlerList = new HandlerList();
    private final WarResult warResult;
    private final MemberHolder winner;

    public WarEndEvent(@NotNull War war, @NotNull WarResult warResult, @NotNull MemberHolder winner) {
        super(war);

        this.warResult = warResult;
        this.winner = winner;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public MemberHolder getLoser() {
        return war.getEnemy(winner);
    }

    @NotNull
    public WarResult getResult() {
        return warResult;
    }

    @NotNull
    public MemberHolder getWinner() {
        return winner;
    }
}
