package me.angeschossen.lands.api;

import me.angeschossen.lands.api.flags.FlagRegistry;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandWorld;
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
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface LandsIntegration {

    /**
     * Get an instance of the implementation.
     * You should assign this instance to a class variable, if possible.
     *
     * @param plugin Your plugin
     * @return instance
     */
    @NotNull
    static LandsIntegration of(@NotNull Plugin plugin) {
        return APIHandler.getLandsIntegrationFactory().of(plugin);
    }

    /**
     * Check if two players can attack each other at the given location.
     * Besides checking flags, this does also take combat tags into account.
     *
     * @param attacker     The attacker
     * @param target       The defender
     * @param location     Location
     * @param setCombatTag Should Lands set a combat tag at these two players, if they are allowed to fight at the given location?
     *                     Depending on the servers configuration this will result in players beeing allowed to fight for a configured period, even if they move into a safe claim.
     *                     This prevents players running away into their claim to escape a fight, which they have started.
     * @param sendMessage  Should Lands send a deny message if result is false?
     * @return This will return true, if the world is not a Lands world or the players are allowed to fight at the given location.
     */
    boolean canPvP(@NotNull Player attacker, @NotNull Player target, @NotNull Location location, boolean setCombatTag, boolean sendMessage);

    /**
     * Get area at the specified coordinate.
     * If you need to retrieve an area that is located insice an unloaded chunk, use {@link #getUnloadedArea(Location)} instead.
     * However, this method should always be prefered if possible.
     *
     * @param location The location
     * @return null, if the target chunk isn't claimed or loaded.
     */
    @Nullable
    Area getArea(@NotNull Location location);

    /**
     * Get an area at the specified coordinate, even if the chunk isn't loaded.
     * This method can be called async. It doesn't make any database calls, but requires a deep lookup in cached data.
     *
     * @param location The location
     * @return null, if the target chunk isn't claimed.
     */
    @Nullable Area getUnloadedArea(@NotNull Location location);

    /**
     * The flag registry allows you to make some more specific actions than in the Flags class.
     *
     * @return The flag registry
     */
    @NotNull FlagRegistry getFlagRegistry();

    /**
     * Get land claimed land from a loaded chunk.
     * This shouldn't be used, if you want to check flag states. Use {@link #getArea(Location)} instead.
     *
     * @param world  The world
     * @param chunkX Chunk x value
     * @param chunkZ Chunk z value
     * @return null, if the chunk isn't claimed or not loaded. If you want to get the land from an unloaded chunk, use {@link #getLandByUnloadedChunk(World, int, int)} instead.
     * However, this method should always prefered, if possible. Most bukkit events etc. usually have chunks already loaded.
     */
    @Nullable
    Land getLandByChunk(@NotNull World world, int chunkX, int chunkZ);

    /**
     * Get land claimed land from a unloaded or loaded chunk. If you're using this method in an event handler or something else
     * where the chunk is loaded anyway, make sure to use {@link #getLandByChunk(World, int, int)} instead.
     * This shouldn't be used, if you want to check flag states. Use {@link #getArea(Location)} instead.
     * This method can be called async. It doesn't make any database calls, but requires a deep lookup in cached data.
     *
     * @param world  The world
     * @param chunkX Chunk x value
     * @param chunkZ Chunk z value
     * @return null, if the chunk isn't claimed
     */
    @Nullable
    Land getLandByUnloadedChunk(@NotNull World world, int chunkX, int chunkZ);

    /**
     * Get land by its id.
     *
     * @param id The id of the land.
     * @return null, if no land with this id exists.
     */
    @Nullable
    Land getLandById(int id);

    /**
     * Get land by name
     * Name is not case sensitive
     *
     * @param name Name
     * @return Land
     */
    @Nullable
    Land getLandByName(@NotNull String name);

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
    LandWorld getWorld(@NotNull World world);

    /**
     * Get all lands.
     *
     * @return Includes camps and admin lands
     */
    @NotNull
    Collection<Land> getLands();

    /**
     * Manage levels.
     *
     * @return LevelsHandler
     * @since 5.14.0
     */
    @NotNull LevelsHandler getLevelsHandler();

    /**
     * Get name of integration.
     *
     * @return Name of the plugin.
     */
    @NotNull
    String getName();

    /**
     * Get a nation by its ID.
     *
     * @param id ID of the nation
     * @return null, if no nation with this id exists
     */
    @Nullable Nation getNationById(int id);

    /**
     * Get a nation by its name.
     *
     * @param name The name without color codes
     * @return null, if no nation with this name exists.
     */
    @Nullable Nation getNationByName(@NotNull String name);

    /**
     * Get all nations.
     *
     * @return Includes nations owned by the server
     */
    @NotNull Collection<Nation> getNations();

    /**
     * Get data for an player that is offline.
     *
     * @param playerUID UUID of the player
     * @return Offline player or instance of the loaded player, if the player is online
     */
    @NotNull
    CompletableFuture<OfflinePlayer> getOfflineLandPlayer(@NotNull UUID playerUID);

    /**
     * Get plugin which hooks into Lands.
     *
     * @return Plugin
     */
    @NotNull
    Plugin getPlugin();

    /**
     * Get a sorted context.
     *
     * @param id The context id. Default: land, nation
     * @return null, if the sorting context does not exist.
     */
    @Nullable SortingContext<?> getSortingContext(@NotNull String id);

    /**
     * Execute actions once Lands is loaded.
     * This is not needed in most use cases.
     *
     * @param runnable The runnable that will be executed.
     * @since 5.13.0
     */
    void onLoad(@NotNull Runnable runnable);

    /**
     * Randomly teleport a player in the given world.
     *
     * @param landPlayer The player
     * @param world      The destination world
     */
    void randomTeleport(@NotNull LandPlayer landPlayer, @NotNull World world);
}
