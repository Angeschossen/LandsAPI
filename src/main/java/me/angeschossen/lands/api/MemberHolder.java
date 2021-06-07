package me.angeschossen.lands.api;

import me.angeschossen.lands.api.events.LandChatEvent;
import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.inbox.InboxCategory;
import me.angeschossen.lands.api.inbox.InboxMessage;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.War;
import me.angeschossen.lands.api.war.WarStats;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface MemberHolder extends BalanceHolder {
    @NotNull
    String getName();

    @NotNull
    String getColorName();

    @Nullable
    War getWar();

    @Nullable
    Color getWebMapColor();

    @NotNull
    Collection<? extends LandPlayer> getOnlineLandPlayers();

    @NotNull
    UUID getOwnerUID();

    @NotNull
    Collection<Player> getOnlinePlayers();

    boolean isTrusted(@NotNull UUID uuid);

    int getId();

    boolean exists();

    /**
     * Send message to online players of this land.
     *
     * @param playerUUID Sender
     * @param message    Message
     */
    void sendMessage(@NotNull UUID playerUUID, @NotNull String message, LandChatEvent.MessageSource messageSource);

    HolderType getType();

    @Nullable
    WarTeam getWarTeam();

    boolean leaveWar();

    void addWarshield(long seconds);

    boolean hasWarshield();

    long getWarshield();

    boolean hasWarEntity(@NotNull MemberHolder entity);

    boolean isInWar();

    boolean isWarField();

    /**
     * Get all trusted players
     *
     * @return Trusted players
     */
    @NotNull
    Collection<UUID> getTrustedPlayers();

    String getWarName();

    @NotNull
    List<? extends InboxMessage> getInbox();

    @NotNull
    List<? extends InboxMessage> getInbox(InboxCategory category);

    @NotNull
    WarStats getStats();
}
