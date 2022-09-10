package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;


public class LandChatEvent extends LandsPlayerEvent implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final String message;
    private final Collection<LandPlayer> recipients;
    private final MessageSource messageSource;
    private final MemberHolder memberHolder;
    private boolean cancelled;

    public LandChatEvent(@NotNull MemberHolder memberHolder,@NotNull  UUID playerUID,@NotNull  Collection<LandPlayer> recipients,@NotNull  String message,@NotNull  MessageSource messageSource) {
        super(playerUID);

        this.memberHolder = memberHolder;
        this.message = message;
        this.recipients = recipients;
        this.messageSource = messageSource;
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
    public String getMessage() {
        return message;
    }

    @NotNull
    public Collection<LandPlayer> getReceivers() {
        return recipients;
    }

    @Nullable
    @Deprecated
    public Player getSender() {
        assert playerUUID != null;
        return Bukkit.getPlayer(playerUUID);
    }

    @NotNull
    @Deprecated
    public UUID getSenderUID() {
        assert playerUUID != null;
        return playerUUID;
    }

    @NotNull
    public MessageSource getSource() {
        return messageSource;
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
    public String toString() {
        return "Sender: " + getSenderUID() + " MemberHolder: " + memberHolder.getName();
    }

    public enum MessageSource {
        MINECRAFT, DISCORD, SYSTEM
    }
}
