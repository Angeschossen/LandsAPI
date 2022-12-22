package me.angeschossen.lands.api.events.memberholder;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.memberholder.MemberHolder;
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
    public HandlerList getHandlers() {
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

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        previous.setExpressionVariables("level_previous_", builder, null);
        memberHolder.getLevel().setExpressionVariables("level_new_", builder,null);
    }
}
