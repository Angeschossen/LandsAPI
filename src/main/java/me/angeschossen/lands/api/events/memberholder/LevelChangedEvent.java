package me.angeschossen.lands.api.events.memberholder;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.levels.Level;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LevelChangedEvent extends MemberHolderEvent {
    public static final HandlerList handlerList = new HandlerList();

    private final @NotNull MemberHolder memberHolder;
    private final @NotNull Level previous;

    public LevelChangedEvent(@NotNull MemberHolder memberHolder, @NotNull Level previous) {
        super(memberHolder);

        this.memberHolder = memberHolder;
        this.previous = previous;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public MemberHolder getMemberHolder() {
        return memberHolder;
    }

    @NotNull
    public Level getNew() {
        return memberHolder.getLevel();
    }

    @NotNull
    public Level getPrevious() {
        return previous;
    }
}
