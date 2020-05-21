package me.angeschossen.lands.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class BroadcastEvent extends Event {
    public static HandlerList handlerList = new HandlerList();

    private final String message;
    private final String messageKey;

    public BroadcastEvent(String messageKey, String message) {
        super(true);

        this.message = message;
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String getMessage() {
        return message;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}

