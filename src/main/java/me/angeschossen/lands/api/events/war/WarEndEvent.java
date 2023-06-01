package me.angeschossen.lands.api.events.war;

import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.war.War;
import me.angeschossen.lands.api.war.enums.WarResult;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WarEndEvent extends WarEvent {
    public static HandlerList handlerList = new HandlerList();
    private final WarResult warResult;
    private final @Nullable MemberHolder winner;

    public WarEndEvent(@NotNull War war, @NotNull WarResult warResult, @Nullable MemberHolder winner) {
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

    /**
     * Get winner.
     *
     * @return null, if {@link #getResult()} returns DRAW
     */
    @Nullable
    public MemberHolder getLoser() {
        return winner == null ? null : war.getEnemy(winner);
    }

    @NotNull
    public WarResult getResult() {
        return warResult;
    }

    /**
     * Get winner.
     *
     * @return null, if {@link #getResult()} returns DRAW
     */
    @Nullable
    public MemberHolder getWinner() {
        return winner;
    }
}
