package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.events.land.DeleteReason;
import me.angeschossen.lands.api.land.enums.LandType;
import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.TrustedPlayer;
import me.angeschossen.lands.api.war.War;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface Land extends MemberHolder {

    /**
     * Add money to land bank. Use negative numbers
     * to remove money.
     *
     * @param value Value
     * @return If value was negative and result smaller then 0, false.
     */
    boolean addBalance(double value);

    boolean banPlayer(@NotNull UUID playerUID);

    /**
     * Claim a chunk. It's recommended to call {@link #calculateLevel(boolean)}, if this method returns true (successful claim), in order to calculate the level as it might has changed after the claim.
     *
     * @param landPlayer The player that is claiming the chunk.
     * @param world      The world
     * @param x          Chunk x
     * @param z          Chunk z
     * @return false, if the chunk a 3rd party plugin cancels the claiming or the chunk is already claimed.
     */
    boolean claimChunk(@Nullable LandPlayer landPlayer, @NotNull World world, int x, int z);

    CompletableFuture<Boolean> delete(@Nullable LandPlayer landPlayer, @NotNull DeleteReason reason);

    /**
     * Delete this land
     *
     * @param deleter If you provide the deleter of the land, Lands will send the bank balance
     *                and cashback (from config) to the deleters economy account.
     */
    void delete(@Nullable Player deleter);

    /**
     * Does land exist?
     *
     * @return boolean
     */
    boolean exists();

    @Nullable
    Area getArea(Location location);

    /**
     * Get land balance
     *
     * @return Balance
     */
    double getBalance();

    @Nullable LandCategory getCategory();

    @Nullable
    Collection<ChunkCoordinate> getChunks(@NotNull World world);

    @NotNull
    String getColorName();

    @Nullable Container getContainer(World world);

    @NotNull Collection<? extends Container> getContainers();

    @NotNull
    Area getDefaultArea();

    /**
     * Get the identification of this land.
     * This is independent of the land name.
     *
     * @return Numerical ID
     */
    int getId();

    LandType getLandType();

    /**
     * Get max chunk claims.
     *
     * @return Max chunk claims
     */
    int getMaxChunks(boolean countNation);

    /**
     * Get max members.
     *
     * @return Max members
     */
    int getMaxMembers();

    /**
     * Get name of the land
     * This value never changes
     *
     * @return Name of land without color
     */
    @NotNull
    String getName();

    @Nullable Nation getNation();

    /**
     * Get a collection of all online land members
     *
     * @return Collection of online players
     */
    @NotNull
    Collection<Player> getOnlinePlayers();

    /**
     * Get owner UUID of land
     *
     * @return UUID of owner
     */
    @NotNull
    UUID getOwnerUID();

    /**
     * Get the size of an land
     *
     * @return Size of land
     */
    int getSize();

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

    Collection<? extends LandArea> getSubAreas(@NotNull World world);

    /**
     * Get the enter title that would be sent to a entering player.
     *
     * @param player The player that enters the land.
     * @return Messages with placeholders replaced with the values.
     */
    @NotNull
    String getTitleMessage(@Nullable Player player);

    /**
     * Use getTitleMessage(player) instead.
     */
    @Deprecated
    @NotNull
    String getTitleMessage();

    /**
     * Set title message.
     *
     * @param title If title is null, it will set the default title instead.
     */
    void setTitleMessage(@Nullable String title);

    /**
     * Get trusted player.
     *
     * @param playerUUID UID of player.
     * @return Trusted player
     */
    @Nullable
    TrustedPlayer getTrustedPlayer(@NotNull UUID playerUUID);

    /**
     * Get upkeep costs
     *
     * @return Upkeep costs
     */
    double getUpkeepCosts();

    War getWar();

    boolean hasArea(@NotNull String name);

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
     * Set land bank balance
     *
     * @param balance Value
     */
    boolean setBalance(double balance);

    /**
     * Set an new owner for land
     *
     * @param playerUID Player for new owner
     */
    void setOwner(@NotNull UUID playerUID);

    /**
     * Trust a player to the whole land, including areas.
     *
     * @return Change
     */
    boolean trustPlayer(@NotNull UUID playerUID);

    void unbanPlayer(@NotNull UUID playerUID);

    /**
     * Untrust a player in the whole land.
     *
     * @param playerUID Player UID
     * @return Change
     */
    boolean untrustPlayer(@NotNull UUID playerUID);

}
