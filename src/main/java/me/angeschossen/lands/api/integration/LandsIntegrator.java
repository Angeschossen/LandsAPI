package me.angeschossen.lands.api.integration;

import me.angeschossen.lands.api.exceptions.FlagConflictException;
import me.angeschossen.lands.api.flags.Flag;
import me.angeschossen.lands.api.flags.FlagRegistry;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.land.enums.SortMode;
import me.angeschossen.lands.api.levels.LevelsHandler;
import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.OfflinePlayer;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


public interface LandsIntegrator {

    /**
     * The flag registry allows you to make some more specific actions than in the Flags class.
     *
     * @return The flag registry
     */
    @NotNull FlagRegistry getFlagRegistry();

    void onLoad(@NotNull Runnable r);

    /**
     * Register your owns flags into Lands. They will also be toggleable in the GUI menus if you set display to true.
     *
     * @param flag RoleFlag or LandFlag
     *             RoleFlags are "playerflags" and LandFlags are natural flags.
     *             For roleflags you need to specify the Category type ACTION or MANAGEMENT.
     * @throws FlagConflictException    A flag with this name already exists.
     * @throws IllegalArgumentException The name is invalid. It contains illegal characters or is too long (> 20 chars).
     */
    void registerFlag(@NotNull Flag flag) throws FlagConflictException, IllegalArgumentException;

    /**
     * Get cached landPlayer
     *
     * @param playerUUID UUID of player
     * @return LandPlayer or null, if not cached
     * @since 2.5.7
     */
    @Nullable
    LandPlayer getLandPlayer(@NotNull UUID playerUUID);

    /**
     * Get world
     *
     * @param world World
     * @return Will return null if is not a lands world
     */
    @Nullable
    LandWorld getLandWorld(@NotNull World world);

    /**
     * Is claimed land?
     *
     * @param location Location
     * @return Is claimed
     */
    boolean isClaimed(@NotNull Location location);

    /**
     * Is claimed?
     *
     * @param world  World
     * @param chunkX Chunk x
     * @param chunkZ Chunk z
     * @return true if claimed
     */
    boolean isClaimed(@NotNull World world, int chunkX, int chunkZ);

    @NotNull
    CompletableFuture<OfflinePlayer> getOfflineLandPlayer(@NotNull UUID playerUID);

    Land getLand(int id);

    @Nullable Nation getNation(int id);

    @Nullable Nation getNation(@NotNull String name);

    /**
     * Get land by name
     * Name is not case sensitive
     *
     * @param name Name
     * @return Land
     */
    Land getLand(@NotNull String name);

    /**
     * Get land by location
     * For permission you can use getArea instead.
     *
     * @param location Location
     * @return Land or null if wilderness
     */
    @Nullable
    Land getLand(@NotNull Location location);

    /**
     * Get land
     *
     * @param world  World
     * @param chunkX Chunk x
     * @param chunkZ Chunk z
     * @return Land or null if wilderness
     */
    @Nullable
    Land getLand(@NotNull World world, int chunkX, int chunkZ);
    /**
     * Randomly teleport a player in the given world.
     * @param landPlayer The player
     * @param world The destination world
     */
    void wild(@NotNull LandPlayer landPlayer, @NotNull World world);

    @NotNull
    Collection<Land> getLands();

    @Nullable
    Area getArea(@NotNull World world, int x, int y, int z);

    /**
     * Get the sub or default area of the land at this location.
     *
     * @param location Location
     * @return null, if not claimed.
     */
    @Nullable
    Area getAreaByLoc(@NotNull Location location);

    /**
     * Get top lands by sorting.
     *
     * @param sortMode Sortmode
     * @return Top lands in order
     */
    @NotNull
    List<Land> getTopLands(SortMode sortMode);

    /**
     * Add requirements to levels.
     *
     * @return LevelsHandler
     * @since 5.14.0
     */
    @NotNull LevelsHandler getLevelsHandler();

    /**
     * Get top lands by sorting.
     *
     * @param sortMode Sortmode
     * @param page     Same as /Lands top
     * @return Top lands in order
     */
    @NotNull
    List<Land> getTopLands(@NotNull SortMode sortMode, int page);

    /**
     * Get top land by sorting and place.
     *
     * @param sortMode Sortmode
     * @param place    Place
     * @return Top lands in order
     */
    @NotNull
    Land getTopLand(@NotNull SortMode sortMode, int place);

    /**
     * Print top lands, same as /Lands top.
     *
     * @param sortMode Sortmode
     * @param page     Page
     * @return Top lands in order and message
     */
    @NotNull
    List<String> printTopLands(SortMode sortMode, int page);

    /**
     * Get's lands wich hooks Lands.
     *
     * @return Plugin
     */
    @Nullable
    Plugin getPlugin();

    /**
     * Get name of integration.
     *
     * @return Name
     */
    @NotNull
    String getName();

    /**
     * Disables the APIHook
     */
    void disable();

    /**
     * Check if hook is enabled.
     *
     * @return Status
     */
    boolean isEnabled();

    @NotNull
    SortMode getDefaultTopSortMode();

    /**
     * Check if two players can attack each other at the given location.
     *
     * @param attacker     The attacker
     * @param target       The defender
     * @param location     Location of the fight
     * @param setCombatTag Should Lands set a combat tag at these two players, if they are allowed to fight at the given location?
     *                     Depending on the servers configuration this will result in players beeing allowed to fight for a configured period, even if they move into a safe claim.
     *                     This prevents players running away into their claim to escape a fight, which they have started.
     * @param sendMessage  Should Lands send a deny message if result is false?
     * @return This will return true, if the world is not a Lands world or the players are allowed to fight at the given location.
     */
    boolean canPvP(@NotNull Player attacker, @NotNull Player target, @NotNull Location location, boolean setCombatTag, boolean sendMessage);
}
