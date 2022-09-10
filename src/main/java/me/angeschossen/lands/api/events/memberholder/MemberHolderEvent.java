package me.angeschossen.lands.api.events.memberholder;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.events.internal.plugin.LandsEvent;
import org.jetbrains.annotations.NotNull;

public abstract class MemberHolderEvent extends LandsEvent {

    protected final MemberHolder memberHolder;

    public MemberHolderEvent(@NotNull MemberHolder memberHolder) {
        this.memberHolder = memberHolder;
    }

    @NotNull
    public MemberHolder getMemberHolder() {
        return memberHolder;
    }
}
