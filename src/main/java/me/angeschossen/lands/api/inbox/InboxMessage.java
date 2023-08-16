package me.angeschossen.lands.api.inbox;


import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import org.jetbrains.annotations.NotNull;

/**
 * Inbox messages notify the land about events, such as newly trusted players, paid upkeep etc.
 */
public interface InboxMessage extends ExpressionEntity {
    /**
     * Get the category of this message.
     * @return The category this message belongs to
     */
    @NotNull
    InboxCategory getCategory();

    /**
     * Timestamp in milliseconds when the message was received.
     * @return Milliseconds
     */
    long getTime();

    /**
     * Get the message text
     * @return Content of the message
     */
    @NotNull
    String getText();

    /**
     * Get the message content {@link #getText()} with the messages date when it was received ({@link #getText()}).
     * @return Format: time ({@link #getTime()}): content ({@link #getText()})
     */
    @NotNull
    String getTextWithDate();

    /**
     * Check if this message belongs to a specific inbox category.
     * @param type The inbox category
     * @return true, if the inbox category is the same or the provided inbox category equals {@link InboxCategory#ALL}
     */
    boolean appliesToFilter(@NotNull InboxCategory type);
}
