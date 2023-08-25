package me.angeschossen.lands.api.events;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.plugin.LandsEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Called when a message is sent to all players on the server.
 * This might exlude a few specific players, to prevent them getting two messages about the same topic.
 */
public class BroadcastEvent extends LandsEvent {
    public static HandlerList handlerList = new HandlerList();

    private final @NotNull String message;
    private final @Nullable String messageKey;
    private final @NotNull Collection<Player> recipients;

    /**
     * Create an instance of this event.
     * @param recipients all recipients
     * @param messageKey Message key in the Lands language file. Use null if the message isn't from Lands
     * @param message the message content
     */
    public BroadcastEvent(@NotNull Collection<Player> recipients, @Nullable String messageKey, @NotNull String message) {
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

    /**
     * Get the message content.
     * @return message content
     */
    @NotNull
    public String getMessage() {
        return message;
    }

    /**
     * Get the message key.
     * @return null, if message isn't from Lands and a 3rd party plugin called this event
     */
    @Nullable
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * Get a collection of recipients.
     * @return all recipients
     */
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

