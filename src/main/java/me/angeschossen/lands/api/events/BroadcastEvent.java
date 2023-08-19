package me.angeschossen.lands.api.events;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.plugin.LandsEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;


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

    @Override
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

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        builder.put("recipients", recipients.stream().map(Player::getUniqueId).collect(Collectors.toList()));
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {

    }
}

