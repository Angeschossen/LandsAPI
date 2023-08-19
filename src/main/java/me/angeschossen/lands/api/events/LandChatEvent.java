package me.angeschossen.lands.api.events;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.player.PlayerEvent;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;


public class LandChatEvent extends PlayerEvent implements Cancellable {
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
        return "Sender: " + getPlayerUID() + " MemberHolder: " + memberHolder.getName();
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);
        builder.put("receivers", getReceivers().stream().map(LandPlayer::getUID).collect(Collectors.toList()));
        memberHolder.setAffectedPlayers(memberHolder.getExpressionPrefix(), builder);
    }

    public enum MessageSource {
        MINECRAFT, DISCORD, SYSTEM
    }
}
