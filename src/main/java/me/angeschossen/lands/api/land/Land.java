package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.events.LandChatEvent;
import me.angeschossen.lands.api.exceptions.PlayerTrustedException;
import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.player.TrustedPlayer;
import me.angeschossen.lands.api.role.Role;
import me.angeschossen.lands.api.role.enums.ManagementSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import me.angeschossen.lands.api.war.War;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface Land extends BalanceHolder {

    boolean hasArea(@NotNull String name);

    void banPlayer(@NotNull UUID playerUID) throws PlayerTrustedException;

    void unBanPlayer(@NotNull UUID playerUID);

    War getWar();

    /**
     * Get upkeep costs
     *
     * @return Upkeep costs
     */
    double getUpkeepCosts(boolean countNation);

    @NotNull String getColorName();

    /**
     * Get name of the land
     * This value never changes
     *
     * @return Name of land without color
     */
    @NotNull
    String getName();

    Role getRole(UUID playerUID);

    /**
     * Send message to online players of this land.
     *
     * @param playerUUID Sender
     * @param message    Message
     */
    void sendMessage(@NotNull UUID playerUUID, @NotNull String message, LandChatEvent.MessageSource messageSource);

    /**
     * Get id of land.
     *
     * @return Id
     */
    int getId();

    boolean untrustMember(@NotNull UUID playerUID);

    /**
     * Get owner UUID of land
     *
     * @return UUID of owner
     */
    @NotNull
    UUID getOwnerUID();

    /**
     * Get spawn
     *
     * @return Spawn
     */
    @Nullable
    Location getSpawn();

    /**
     * Get the size of an land
     *
     * @return Size of land
     */
    @NotNull
    int getSize();

    /**
     * Trust a player to the whole land, including areas.
     *
     * @return
     */
    boolean trustPlayer(UUID playerUID);

    /**
     * Get max members.
     *
     * @return Max members
     */
    @NotNull
    int getMaxMembers();

    /**
     * Get max chunk claims.
     *
     * @return Max chunk claims
     */
    @NotNull
    int getMaxChunks(boolean countNation);

    /**
     * Get all trusted players
     *
     * @return Trusted players
     */
    @NotNull
    Collection<UUID> getTrustedPlayers();

    /**
     * Check is land loaded
     *
     * @return Boolean
     */
    @NotNull
    boolean isLoaded();

    /**
     * Set title message.
     *
     * @param title Message
     */
    void setTitleMessage(@NotNull String title);

    /**
     * Get title mesasage.
     *
     * @return Title message.
     */
    @NotNull
    String getTitleMessage();

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

    /**
     * Set name of land
     *
     * @param name New name
     * @return
     */
    boolean setName(@NotNull String name);

    /**
     * Check has land setting
     * @param landSetting
     * @return
     */
    boolean hasLandSetting(LandSetting landSetting);

    /**
     * Check if player is trusted in whole land.
     *
     * @param playerUUID UUID of player
     * @return true if is
     */
    boolean isTrustedInLand(@NotNull UUID playerUUID);

    /**
     * Get a collection of all online land members
     *
     * @return Collection of online players
     */
    @NotNull
    Collection<Player> getOnlinePlayers();

    /**
     * Check if player can action
     *
     * @param playerUUID UUID of player
     * @param action     Action
     * @return Result
     */
    boolean canSetting(@NotNull UUID playerUUID, @NotNull RoleSetting action);

    boolean canManagement(UUID playerUUID, ManagementSetting managementSetting);

    /**
     * Check if player can action with checking bypass permission
     * This will send a message to the player if he can't access the action and has no required bypass permission.
     *
     * @param player      Player
     * @param action      Action
     * @param sendMessage Send message?
     * @return Will return false if player has no access and has no bypass permission
     */
    boolean canSetting(@NotNull Player player, @NotNull RoleSetting action, @NotNull boolean sendMessage);

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
     * Set spawn location of land
     *
     * @param location Location of spawn
     */
    void setSpawn(@Nullable Location location);


    /**
     * Get land balance
     *
     * @return Balance
     */
    @NotNull
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
     * @return
     */
    boolean addBalance(double value);

}
