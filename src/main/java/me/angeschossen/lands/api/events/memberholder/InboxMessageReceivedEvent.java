package me.angeschossen.lands.api.events.memberholder;

import me.angeschossen.lands.api.inbox.InboxMessage;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class InboxMessageReceivedEvent extends MemberHolderEvent {
    public static final HandlerList handlerList = new HandlerList();

    private final @NotNull InboxMessage inboxMessage;
    private final @NotNull MemberHolder memberHolder;

    public InboxMessageReceivedEvent(@NotNull MemberHolder memberHolder, @NotNull InboxMessage inboxMessage) {
        super(memberHolder);

        this.inboxMessage = inboxMessage;
        this.memberHolder = memberHolder;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public MemberHolder getMemberHolder() {
        return memberHolder;
    }

    @NotNull
    public InboxMessage getMessage() {
        return inboxMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}

