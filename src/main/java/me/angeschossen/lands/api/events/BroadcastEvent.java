package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.plugin.LandsEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;


public class BroadcastEvent extends LandsEvent {
    public static HandlerList handlerList = new HandlerList();

    private final String message;
    private final String messageKey;
    private final Collection<Player> recipients;

    public BroadcastEvent(Collection<Player> recipients, String messageKey, String message) {
        this.message = message;
        this.messageKey = messageKey;
        this.recipients = recipients;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public HandlerList getHandlers() {
        return handlerList;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageKey() {
        return messageKey;
    }

    @NotNull
    public Collection<Player> getRecipients() {
        return recipients;
    }
}

