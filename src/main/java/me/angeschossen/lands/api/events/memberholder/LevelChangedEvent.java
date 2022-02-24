package me.angeschossen.lands.api.events.memberholder;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.levels.Level;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LevelChangedEvent extends Event {
    public static final HandlerList handlerList = new HandlerList();

    private final @NotNull MemberHolder memberHolder;
    private final @NotNull Level previous;

    public LevelChangedEvent(@NotNull MemberHolder memberHolder, @NotNull Level previous) {
        super(!Bukkit.isPrimaryThread());

        this.memberHolder = memberHolder;
        this.previous = previous;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Level getNew() {
        return memberHolder.getLevel();
    }

    @NotNull
    public Level getPrevious() {
        return previous;
    }

    @NotNull
    public MemberHolder getMemberHolder() {
        return memberHolder;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
