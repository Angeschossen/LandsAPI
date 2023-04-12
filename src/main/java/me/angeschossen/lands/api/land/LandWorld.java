package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.flags.type.NaturalFlag;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface LandWorld {

    boolean hasWildernessRoleFlag(@NotNull LandPlayer player, @NotNull Location location, @NotNull RoleFlag roleFlag, boolean sendMessage);

    @Nullable
    Area getArea(Location location);

    @Nullable
    Land getLand(int x, int z);

    @Nullable
    Area getArea(int x, int y, int z);

    boolean hasRoleFlag(@NotNull LandPlayer player, @NotNull Location location, @NotNull RoleFlag flag, @Nullable Material material, boolean sendMessage);

    boolean hasRoleFlag(@NotNull Player player, @NotNull Location location, @NotNull RoleFlag flag, @Nullable Material material, boolean sendMessage);

    boolean hasRoleFlag(@NotNull UUID playerUID, @NotNull Location location, @NotNull RoleFlag flag);

    @Deprecated
    boolean hasFlag(@NotNull LandPlayer player, @NotNull Location location, @Nullable Material material, @NotNull me.angeschossen.lands.api.flags.types.RoleFlag flag, boolean sendMessage);

    @Deprecated
    boolean hasFlag(@NotNull Player player, @NotNull Location location, @Nullable Material material, @NotNull me.angeschossen.lands.api.flags.types.RoleFlag flag, boolean sendMessage);

    boolean hasNaturalFlag(@NotNull Location location, @NotNull NaturalFlag flag);

    /**
     * Get name of world.
     *
     * @return Name of world
     */
    @NotNull
    String getName();

    /**
     * Get world
     *
     * @return World
     */
    @NotNull
    World getWorld();

    /**
     * Is landChunk loaded?
     *
     * @param x X identifier
     * @param z Z identifier
     * @return Loaded
     */
    boolean isChunkLoaded(int x, int z);
}
