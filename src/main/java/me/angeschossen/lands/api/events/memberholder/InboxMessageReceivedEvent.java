package me.angeschossen.lands.api.events.memberholder;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.inbox.InboxMessage;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class InboxMessageReceivedEvent extends Event {
    public static final HandlerList handlerList = new HandlerList();

    private final @NotNull InboxMessage inboxMessage;
    private final @NotNull MemberHolder memberHolder;

    public InboxMessageReceivedEvent(@NotNull MemberHolder memberHolder, @NotNull InboxMessage inboxMessage) {
        super(!Bukkit.isPrimaryThread());

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

