package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;


public class LandChatEvent extends Event implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    private final String message;
    private final UUID playerUID;
    private final Land land;
    private final Collection<UUID> recipients;
    private final MessageSource messageSource;

    public LandChatEvent(Land land, UUID playerUID, Collection<UUID> recipients, String message, MessageSource messageSource) {
        this.land = land;
        this.playerUID = playerUID;
        this.message = message;
        this.recipients = recipients;
        this.messageSource = messageSource;
    }

    public Collection<UUID> getRecipients() {
        return recipients;
    }

    public Land getLand() {
        return land;
    }

    public MessageSource getSource() {
        return messageSource;
    }

    public enum MessageSource {
        MINECRAFT, DISCORD
    }

    @NotNull
    public UUID getSenderUID() {
        return playerUID;
    }

    @Nullable
    public Player getSender() {
        return Bukkit.getPlayer(playerUID);
    }

    public String getMessage() {
        return message;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public String toString() {
        return "Sender: " + getSenderUID().toString() + " Land: " + land.getName();
    }
}
