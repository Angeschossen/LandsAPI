package me.angeschossen.lands.api.integration;


import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandArea;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.land.enums.SortMode;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


public class LandsIntegration implements LandsIntegrator {

    @Deprecated
    public LandsIntegration(@NotNull String name, boolean isPublic) {
    }

    @Deprecated
    public LandsIntegration(@NotNull Plugin plugin, boolean isPublic) {
    }


    public LandsIntegration(@NotNull Plugin plugin) {
    }


    @Override
    public @Nullable LandPlayer getLandPlayer(@NotNull UUID playerUUID) {
        return null;
    }

    @Override
    public @Nullable LandWorld getLandWorld(@NotNull World world) {
        return null;
    }

    @Override
    public boolean isClaimed(@NotNull Location location) {
        return false;
    }

    @Override
    public CompletableFuture<Boolean> isClaimed(@NotNull String worldName, int chunkX, int chunkZ) {
        return null;
    }

    @Override
    public boolean isClaimed(@NotNull World world, int chunkX, int chunkZ) {
        return false;
    }

    @Override
    public Land getLand(@NotNull String worldName, @NotNull String landName) {
        return null;
    }

    @Override
    public LandWorld getLandWorld(@NotNull String worldName) {
        return null;
    }

    @Override
    public Land getLand(@NotNull String name) {
        return null;
    }

    @Override
    public @Nullable Land getLand(@NotNull Location location) {
        return null;
    }

    @Override
    public @Nullable Land getLand(@NotNull World world, int chunkX, int chunkZ) {
        return null;
    }

    @Override
    @Deprecated
    public @Nullable LandArea getArea(@NotNull Location location) {
        return null;
    }

    @Override
    public @Nullable Area getAreaByLoc(@NotNull Location location) {
        return null;
    }

    @Override
    public @NotNull List<Land> getTopLands(SortMode sortMode) {
        return null;
    }

    @Override
    public @NotNull List<Land> getTopLands(@NotNull SortMode sortMode, int page) {
        return null;
    }

    @Override
    public @NotNull List<Land> getTopLand(@NotNull SortMode sortMode, int place) {
        return null;
    }

    @Override
    public @NotNull List<String> printTopLands(SortMode sortMode, int page) {
        return null;
    }

    @Override
    public @Nullable Plugin getPlugin() {
        return null;
    }

    @Override
    public @NotNull String getName() {
        return null;
    }

    @Override
    public void disable() {

    }

    @Override
    public void disable(@Nullable String hookKey) {

    }

    @Override
    public @NotNull String initialize() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean getAccess(@NotNull String hookKey) {
        return false;
    }

    @Override
    public boolean isPublic() {
        return false;
    }
}
