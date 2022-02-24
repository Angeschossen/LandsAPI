package me.angeschossen.lands.api;

import me.angeschossen.lands.api.events.LandChatEvent;
import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.inbox.InboxCategory;
import me.angeschossen.lands.api.inbox.InboxMessage;
import me.angeschossen.lands.api.levels.Level;
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
import java.util.concurrent.CompletableFuture;

public interface MemberHolder extends BalanceHolder {
    @NotNull
    String getName();

    @NotNull
    String getColorName();

    int getChunksAmount();

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
     * @param messageSource Specify if the message is sent from in-game or Discord for example.
     */
    void sendMessage(@NotNull UUID playerUUID, @NotNull String message, LandChatEvent.MessageSource messageSource);

    HolderType getType();

    @NotNull
    Level getLevel();

    CompletableFuture<Float> modifyRequirementCache(@NotNull String requirement, float modify, boolean allowNegative);

    boolean isRequirementCached(@NotNull String requirement);

    float getCachedRequirement(@NotNull String requirement);

    void markLevelUpdate();

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

    int getMembersAmount();

    @NotNull
    List<? extends InboxMessage> getInbox();

    @NotNull
    List<? extends InboxMessage> getInbox(InboxCategory category);

    @NotNull
    WarStats getStats();

    void updateRequirementCache(@NotNull String requirement, float val, boolean levelCalc) throws IllegalArgumentException;
}
