package me.angeschossen.lands.api.inbox;


import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import com.github.angeschossen.pluginframework.api.player.PlayerData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Inbox messages notify the land about events, such as newly trusted players, paid upkeep etc.
 */
public interface InboxMessage extends ExpressionEntity {
    /**
     * Get the category of this message.
     *
     * @return The category this message belongs to
     */
    @NotNull
    InboxCategory getCategory();

    /**
     * Get the message content {@link #getText(PlayerData)} with the messages date when it was received ({@link #getDateString(PlayerData)}).
     *
     * @param sender Used for per user language. If no player provided, uses default language.
     * @return Format: date ({@link #getDateString(PlayerData)} ()}): content ({@link {@link #getText(PlayerData)}})
     */
    @NotNull
    String getTextWithDate(@Nullable PlayerData sender);

    /**
     * Get the date in text format.
     *
     * @param player will take the players locale
     * @return formatted date
     */
    @NotNull
    String getDateString(@Nullable PlayerData player);

    /**
     * Timestamp in milliseconds when the message was received.
     *
     * @return Milliseconds
     */
    long getTime();

    /**
     * Get the message text without the date.
     *
     * @return Content of the message without the date
     * @deprecated Use {{@link #getText(PlayerData)}} instead.
     */
    @Deprecated
    @NotNull
    String getText();

    /**
     * Get the message text without the date.
     * @param player depends on players locale
     * @return Content of the message without the date
     */
    @NotNull
    String getText(@Nullable PlayerData player);

    /**
     * Use {@link #getTextWithDate(PlayerData)} instead.
     *
     * @return Format: time ({@link #getTime()}): content ({@link #getText()})
     */
    @Deprecated
    @NotNull
    String getTextWithDate();

    /**
     * Check if this message is an alert. Some messages are really important, such as the reminder to deposit money for upkeep, if a land
     * is lacking funds.
     *
     * @return true, if this message is an alert
     */
    boolean shouldAlertMembers();

    /**
     * Check if this message belongs to a specific inbox category.
     *
     * @param type The inbox category
     * @return true, if the inbox category is the same or the provided inbox category equals {@link InboxCategory#ALL}
     */
    boolean appliesToFilter(@NotNull InboxCategory type);
}
