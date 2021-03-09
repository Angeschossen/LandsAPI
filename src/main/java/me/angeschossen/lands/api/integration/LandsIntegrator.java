package me.angeschossen.lands.api.integration;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.land.enums.SortMode;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


public interface LandsIntegrator {

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

    Land getLand(int id);

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
    @Nullable Land getLand(@NotNull Location location);

    /**
     * Get land
     *
     * @param world  World
     * @param chunkX Chunk x
     * @param chunkZ Chunk z
     * @return Land or null if wilderness
     */
    @Nullable Land getLand(@NotNull World world, int chunkX, int chunkZ);

    @NotNull SortMode getDefaultTopSortMode();

    @NotNull
    Collection<Land> getLands();

    /**
     * Get the sub or default area of the land at this location.
     *
     * @param location Location
     * @return null, if not claimed.
     */
    @Nullable Area getAreaByLoc(@NotNull Location location);

    @Nullable
    Area getArea(@NotNull World world, int x, int y, int z);

    /**
     * Get top lands by sorting.
     *
     * @param sortMode Sortmode
     * @return Top lands in order
     */
    @NotNull List<Land> getTopLands(SortMode sortMode);

    /**
     * Get top lands by sorting.
     *
     * @param sortMode Sortmode
     * @param page     Same as /Lands top
     * @return Top lands in order
     */
    @NotNull List<Land> getTopLands(@NotNull SortMode sortMode, int page);

    /**
     * Get top land by sorting and place.
     *
     * @param sortMode Sortmode
     * @param place    Place
     * @return Top land
     */
    @NotNull Land getTopLand(@NotNull SortMode sortMode, int place);

    /**
     * Print top lands, same as /Lands top.
     *
     * @param sortMode Sortmode
     * @param page     Page
     * @return Top lands in order and message
     */
    @NotNull List<String> printTopLands(SortMode sortMode, int page);

    /**
     * Get's lands which hooks Lands.
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
     * Removes the hook
     */
    @Deprecated
    void disable();

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
