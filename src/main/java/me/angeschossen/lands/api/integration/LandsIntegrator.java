package me.angeschossen.lands.api.integration;

import me.angeschossen.lands.api.exceptions.FlagConflictException;
import me.angeschossen.lands.api.flags.Flag;
import me.angeschossen.lands.api.flags.FlagRegistry;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandArea;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.land.enums.SortMode;
import me.angeschossen.lands.api.levels.LevelsHandler;
import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.OfflinePlayer;
import me.angeschossen.lands.api.sorting.SortingContext;
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
     * Get a list of all nations.
     * @return All nations of the server.
     */
    @NotNull Collection<Nation> getNations();

    /**
     * Add requirements to levels.
     *
     * @return LevelsHandler
     * @since 5.14.0
     */
    @NotNull LevelsHandler getLevelsHandler();

    /**
     * Execute actions once Lands is loaded.
     * This is not needed in most use cases.
     *
     * @param runnable The runnable that will be executed.
     * @since 5.13.0
     */
    void onLoad(@NotNull Runnable runnable);

    /**
     * The flag registry allows you to make some more specific actions than in the Flags class.
     *
     * @return The flag registry
     */
    @NotNull FlagRegistry getFlagRegistry();

    /**
     * Register your owns flags into Lands. They will also be toggleable in the GUI menus if you set display to true.
     *
     * @param flag RoleFlag or LandFlag
     *             RoleFlags are "playerflags" and LandFlags are natural flags.
     *             For roleflags you need to specify the Category type ACTION or MANAGEMENT.
     * @throws FlagConflictException    A flag with this name already exists.
     * @throws IllegalArgumentException The name is invalid. It contains illegal characters or is too long (greater than 20 chars).
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
     * @return true, if the chunk of the location is claimed.
     * Works also in unloaded regions.
     */
    boolean isClaimed(@NotNull Location location);

    @Deprecated
    CompletableFuture<Boolean> isClaimed(@NotNull String worldName, int chunkX, int chunkZ);

    /**
     * Is claimed?
     *
     * @param world  World
     * @param chunkX Chunk x
     * @param chunkZ Chunk z
     * @return true, if the chunk of the location is claimed.
     * Works also in unloaded regions.
     */
    boolean isClaimed(@NotNull World world, int chunkX, int chunkZ);

    /**
     * Get land.
     *
     * @param worldName Name of world, where land is located
     * @param landName  Name or displayname of land
     * @return Land or null, if not exists.
     * @since 2.5.7
     */
    @Deprecated
    Land getLand(@NotNull String worldName, @NotNull String landName);

    @NotNull
    CompletableFuture<OfflinePlayer> getOfflineLandPlayer(@NotNull UUID playerUID);

    /**
     * Get landWorld.
     *
     * @param worldName Name of world.
     * @return LandWorld or null, if it's not an landWorld.
     */
    @Deprecated
    LandWorld getLandWorld(@NotNull String worldName);

    Land getLand(int id);

    @Nullable Nation getNation(int id);

    @Nullable Nation getNation(@NotNull String name);

    /**
     * Randomly teleport a player in the given world.
     *
     * @param landPlayer The player
     * @param world      The destination world
     */
    void wild(@NotNull LandPlayer landPlayer, @NotNull World world);

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

    @NotNull
    Collection<Land> getLands();

    /**
     * Use {@link #getArea(World, int, int, int)} or {@link #getAreaByLoc(Location)} instead.
     * Get the sub area of the land at this location. This does not include the default area.
     * It is recommended to use {@link #getAreaByLoc(Location)} instead, if you want to cover the default area too.
     *
     * @param location Location
     * @return null, if not claimed or the area is not a sub area (default area)
     */
    @Deprecated
    @Nullable
    LandArea getArea(@NotNull Location location);

    /**
     * Get area at the specified coordinate.
     *
     * @param world World
     * @param x     Block x
     * @param y     Block y
     * @param z     Block z
     * @return The area at the specific coordinate. Might return null, if the coordinate is unloaded.
     */
    @Nullable
    Area getArea(@NotNull World world, int x, int y, int z);

    /**
     * Get the sub or default area of the land at this location. It is recommended to use this instead of {@link #getArea(Location)}
     *
     * @param location Location
     * @return Will return null if the location is not claimed or the location is unloaded.
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
    @Deprecated
    List<Land> getTopLands(SortMode sortMode);

    /**
     * Get top lands by sorting.
     *
     * @param sortMode Sortmode
     * @param page     Same as /lands top
     * @return Top lands in order
     */
    @NotNull
    @Deprecated
    List<Land> getTopLands(@NotNull SortMode sortMode, int page);

    /**
     * Get a sorted context.
     * @param id The context id. Default: land, nation
     * @return null, if the sorting context does not exist.
     */
    @Nullable SortingContext<?> getSortingContext(@NotNull String id);

    /**
     * Get top land by sorting and place.
     *
     * @param sortMode Sortmode
     * @param place    Place
     * @return Top lands in order
     */
    @Nullable
    @Deprecated
    Land getTopLand(@NotNull SortMode sortMode, int place);

    /**
     * Print top lands, same as /lands top.
     *
     * @param sortMode Sortmode
     * @param page     Page
     * @return Top lands in order and message
     */
    @NotNull
    @Deprecated
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

    @Deprecated
    void disable();

    @Deprecated
    void disable(@Nullable String hookKey);

    @NotNull
    @Deprecated
    String initialize();

    @Deprecated
    boolean isEnabled();

    @Deprecated
    boolean getAccess(@NotNull String hookKey);

    @Deprecated
    boolean isPublic();

    @NotNull
    @Deprecated
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
