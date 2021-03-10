package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.events.LandChatEvent;
import me.angeschossen.lands.api.exceptions.NameAlreadyTakenException;
import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.inbox.InboxCategory;
import me.angeschossen.lands.api.inbox.InboxMessage;
import me.angeschossen.lands.api.player.TrustedPlayer;
import me.angeschossen.lands.api.role.enums.ManagementSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import me.angeschossen.lands.api.war.War;
import me.angeschossen.lands.api.war.entity.WarEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface Land extends BalanceHolder, WarEntity {

    @NotNull
    List<? extends InboxMessage> getInbox();

    @NotNull
    List<? extends InboxMessage> getInbox(InboxCategory category);

    @NotNull
    Area getDefaultArea();

    /**
     * Delete this land
     *
     * @param deleter If you provide the deleter of the land, Lands will send the bank balance
     *                and cashback (from config) to the deleters economy account.
     */
    void delete(@Nullable Player deleter);

    @Nullable
    Collection<ChunkCoordinate> getChunks(@NotNull World world);

    @Nullable
    Collection<LandArea> getSubAreas(@NotNull World world);

    boolean hasArea(@NotNull String name);

    boolean banPlayer(@NotNull UUID playerUID);

    void unbanPlayer(@NotNull UUID playerUID);

    @Deprecated
    boolean canSetting(Player player, RoleSetting roleSetting);

    /**
     * Get the identification of this land.
     * This is independent of the land name.
     *
     * @return Numerical ID
     */
    int getId();

    @Deprecated
    boolean canSetting(UUID uuid, RoleSetting roleSetting);

    War getWar();

    /**
     * Get upkeep costs
     *
     * @return Upkeep costs
     */
    double getUpkeepCosts();

    @NotNull
    String getColorName();

    /**
     * Get name of the land
     * This value never changes
     *
     * @return Name of land without color
     */
    @NotNull
    String getName();

    /**
     * Set name of land
     *
     * @param name New name
     * @return
     */
    boolean setName(@NotNull String name) throws NameAlreadyTakenException, IllegalArgumentException;

    /**
     * Send message to online players of this land.
     *
     * @param playerUUID Sender
     * @param message    Message
     */
    void sendMessage(@NotNull UUID playerUUID, @NotNull String message, LandChatEvent.MessageSource messageSource);

    /**
     * Get owner UUID of land
     *
     * @return UUID of owner
     */
    @NotNull
    UUID getOwnerUID();

    /**
     * Untrust a player in the whole land.
     *
     * @param playerUID Player UID
     * @return Change
     */
    boolean untrustPlayer(@NotNull UUID playerUID);

    /**
     * Get spawn
     *
     * @return Spawn
     */
    @Nullable
    Location getSpawn();

    /**
     * Set spawn location of land
     *
     * @param location Location of spawn
     */
    void setSpawn(@Nullable Location location);

    /**
     * Get the size of an land
     *
     * @return Size of land
     */
    int getSize();

    /**
     * Trust a player to the whole land, including areas.
     *
     * @return Change
     */
    boolean trustPlayer(@NotNull UUID playerUID);

    /**
     * Get max members.
     *
     * @return Max members
     */
    int getMaxMembers();

    /**
     * Get max chunk claims.
     *
     * @return Max chunk claims
     */
    int getMaxChunks(boolean countNation);

    /**
     * Get all trusted players
     *
     * @return Trusted players
     */
    @NotNull
    Collection<UUID> getTrustedPlayers();

    /**
     * Get title mesasage.
     *
     * @return Title message.
     */
    @NotNull
    String getTitleMessage();

    /**
     * Set title message.
     *
     * @param title If title is null, it will set the default title instead.
     */
    void setTitleMessage(@Nullable String title);

    /**
     * Set an new owner for land
     *
     * @param playerUID Player for new owner
     */
    void setOwner(@NotNull UUID playerUID);

    /**
     * Check if land has a chunk
     *
     * @param world World
     * @param x     X of chunk
     * @param z     Z of chunk
     * @return true if has
     */
    boolean hasChunk(@NotNull World world, int x, int z);

    @Deprecated
    boolean isTrusted(@NotNull UUID playerUID);

    /**
     * Get a collection of all online land members
     *
     * @return Collection of online players
     */
    @NotNull
    Collection<Player> getOnlinePlayers();

    boolean canManagement(UUID playerUUID, ManagementSetting managementSetting);

    boolean canManagement(Player player, ManagementSetting managementSetting, boolean sendMessage);

    /**
     * Get trusted player.
     *
     * @param playerUUID UID of player.
     * @return Trusted player
     */
    @Nullable
    TrustedPlayer getTrustedPlayer(@NotNull UUID playerUUID);

    /**
     * Does land exist?
     *
     * @return boolean
     */
    boolean exists();

    /**
     * Get land balance
     *
     * @return Balance
     */
    double getBalance();

    /**
     * Set land bank balance
     *
     * @param balance Value
     */
    boolean setBalance(double balance);

    /**
     * Add money to land bank. Use negative numbers
     * to remove money.
     *
     * @param value Value
     * @return If value was negative and result smaller then 0, false.
     */
    boolean addBalance(double value);

}
