package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;


public class LandChatEvent extends Event implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final String message;
    private final UUID playerUID;
    private final Collection<LandPlayer> recipients;
    private final MessageSource messageSource;
    private final MemberHolder memberHolder;
    private boolean cancelled;

    public LandChatEvent(MemberHolder memberHolder, UUID playerUID, Collection<LandPlayer> recipients, String message, MessageSource messageSource) {
        this.memberHolder = memberHolder;
        this.playerUID = playerUID;
        this.message = message;
        this.recipients = recipients;
        this.messageSource = messageSource;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Deprecated
    public Collection<UUID> getRecipients() {
        Collection<UUID> uuids = new ArrayList<>();
        recipients.forEach(r -> uuids.add(r.getUID()));
        return uuids;
    }

    @NotNull
    public Collection<LandPlayer> getReceivers() {
        return recipients;
    }

    @Deprecated
    @Nullable
    public Land getLand() {
        return memberHolder instanceof Land ? (Land) memberHolder : null;
    }

    @NotNull
    public MemberHolder getMemberHolder() {
        return memberHolder;
    }

    public MessageSource getSource() {
        return messageSource;
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
        return "Sender: " + getSenderUID() + " MemberHolder: " + memberHolder.getName();
    }

    public enum MessageSource {
        MINECRAFT, DISCORD
    }
}
