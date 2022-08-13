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

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface MemberHolder extends BalanceHolder {
    void addWarshield(long seconds);

    /**
     * Calculate the level
     *
     * @param executeCmds Execute level-up or level-down configured "reward" commands?
     */
    void calculateLevel(boolean executeCmds);

    boolean exists();

    /**
     * Get all allies.
     *
     * @return Current allies
     */
    @NotNull
    Collection<? extends MemberHolder> getAllies();

    float getCachedRequirement(@NotNull String requirement);

    int getChunksAmount();

    @NotNull
    String getColorName();

    /**
     * Get the creation timestamp.
     *
     * @return Time milliseconds
     */
    long getCreationTime();

    /**
     * Get all enemies.
     *
     * @return Current enemies
     */
    @NotNull
    Collection<? extends MemberHolder> getEnemies();

    int getId();

    @NotNull
    java.util.List<? extends InboxMessage> getInbox();

    @NotNull
    List<? extends InboxMessage> getInbox(InboxCategory category);

    @NotNull
    Level getLevel();

    int getMembersAmount();

    @NotNull
    String getName();

    @NotNull
    Collection<? extends LandPlayer> getOnlineLandPlayers();

    @NotNull
    Collection<Player> getOnlinePlayers();

    @NotNull
    UUID getOwnerUID();

    @NotNull
    WarStats getStats();

    /**
     * Get all trusted players
     *
     * @return Trusted players
     */
    @NotNull
    Collection<UUID> getTrustedPlayers();

    HolderType getType();

    @Nullable
    War getWar();

    String getWarName();

    @Nullable
    WarTeam getWarTeam();

    long getWarshield();

    @Nullable
    Integer getWebMapBorderColor();

    @Nullable
    Integer getWebMapFillColor();

    boolean hasWarEntity(@NotNull MemberHolder entity);

    boolean hasWarshield();

    /**
     * Check if memberHolder has alliance with this once.
     *
     * @param memberHolder The target
     * @return true, if they're in an alliance.
     */
    boolean isAlly(@NotNull MemberHolder memberHolder);

    /**
     * Check if memberHolder is an enemy to this one.
     *
     * @param memberHolder The target
     * @return true, if they're enemies.
     */
    boolean isEnemy(@NotNull MemberHolder memberHolder);

    boolean isInWar();

    boolean isRequirementCached(@NotNull String requirement);

    boolean isTrusted(LandPlayer landPlayer);

    boolean isTrusted(@NotNull UUID uuid);

    boolean isWarField();

    boolean leaveWar();

    void markLevelUpdate();

    CompletableFuture<Float> modifyRequirementCache(@NotNull String requirement, float modify, boolean allowNegative);

    /**
     * Send message to online players of this land.
     *
     * @param playerUUID Sender
     * @param message    Message
     */
    void sendMessage(@NotNull UUID playerUUID, @NotNull String message, LandChatEvent.MessageSource messageSource);

    void setWarShield(long seconds);

    void updateRequirementCache(@NotNull String requirement, float val, boolean levelCalc) throws IllegalArgumentException;
}
