package me.angeschossen.lands.api.events;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.plugin.LandsEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Called when a message is sent to all players on the server.
 * This might exlude a few specific players, to prevent them getting two messages about the same topic.
 */
public class BroadcastEvent extends LandsEvent {
    public static HandlerList handlerList = new HandlerList();

    private final @Nullable String messageKey;
    private final @NotNull Collection<? extends LandPlayer> recipients;
    private final @NotNull Function<@Nullable LandPlayer, String> parseMessage;

    /**
     * Create an instance of this event.
     *
     * @param recipients   all recipients
     * @param messageKey   Message key in the Lands language file. Use null if the message isn't from Lands
     * @param parseMessage parses the message for a specific player. Lands supports per player language
     */
    public BroadcastEvent(@NotNull Collection<? extends LandPlayer> recipients, @Nullable String messageKey, @NotNull Function<@Nullable LandPlayer, String> parseMessage) {
        this.messageKey = messageKey;
        this.recipients = recipients;
        this.parseMessage = parseMessage;
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
     *
     * @return message content
     */
    @Deprecated
    @NotNull
    public String getMessage() {
        return "deprecated";
    }

    @NotNull
    public String parseMessage(@Nullable LandPlayer recipient) {
        return parseMessage.apply(recipient);
    }

    /**
     * Get the message key.
     *
     * @return null, if message isn't from Lands and a 3rd party plugin called this event
     */
    @Nullable
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * Get a collection of recipients.
     *
     * @return all recipients
     */
    @NotNull
    public Collection<? extends LandPlayer> getRecipients() {
        return recipients;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        builder.put("recipients", recipients.stream().map(LandPlayer::getUUID).collect(Collectors.toList()));
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {

    }
}

