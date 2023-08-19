package me.angeschossen.lands.api.events.memberholder;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.plugin.LandsEvent;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public abstract class MemberHolderEvent extends LandsEvent {

    protected final MemberHolder memberHolder;

    public MemberHolderEvent(@NotNull MemberHolder memberHolder) {
        this.memberHolder = memberHolder;
    }

    @NotNull
    public MemberHolder getMemberHolder() {
        return memberHolder;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        memberHolder.setAffectedPlayers(memberHolder.getExpressionPrefix(), builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        memberHolder.setExpressionVariables(memberHolder.getExpressionPrefix(), builder,null);
    }
}
