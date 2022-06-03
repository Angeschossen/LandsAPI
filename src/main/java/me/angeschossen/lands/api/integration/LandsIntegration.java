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


public class LandsIntegration implements LandsIntegrator {

    public LandsIntegration(@NotNull Plugin plugin) {
    }

    @Override
    public boolean canPvP(@NotNull Player attacker, @NotNull Player target, @NotNull Location location, boolean setCombatTag, boolean sendMessage) {
        return false;
    }

    @Override
    public void disable() {

    }

    @Override
    public void disable(@Nullable String hookKey) {

    }

    @Override
    public boolean getAccess(@NotNull String hookKey) {
        return false;
    }

    @Override
    public @Nullable LandArea getArea(@NotNull Location location) {
        return null;
    }

    @Override
    public @Nullable Area getArea(@NotNull World world, int x, int y, int z) {
        return null;
    }

    @Override
    public @Nullable Area getAreaByLoc(@NotNull Location location) {
        return null;
    }

    @Override
    @Deprecated
    public @NotNull SortMode getDefaultTopSortMode() {
        return null;
    }

    @Override
    public @NotNull FlagRegistry getFlagRegistry() {
        return null;
    }

    @Override
    public Land getLand(@NotNull String worldName, @NotNull String landName) {
        return null;
    }

    @Override
    public Land getLand(int id) {
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
    public @Nullable LandPlayer getLandPlayer(@NotNull UUID playerUUID) {
        return null;
    }

    @Override
    public @Nullable LandWorld getLandWorld(@NotNull World world) {
        return null;
    }

    @Override
    public LandWorld getLandWorld(@NotNull String worldName) {
        return null;
    }

    @Override
    public @NotNull Collection<Land> getLands() {
        return null;
    }

    @Override
    public @NotNull LevelsHandler getLevelsHandler() {
        return null;
    }

    @Override
    public @NotNull String getName() {
        return null;
    }

    @Override
    public @Nullable Nation getNation(int id) {
        return null;
    }

    @Override
    public @Nullable Nation getNation(@NotNull String name) {
        return null;
    }

    @Override
    public @NotNull CompletableFuture<OfflinePlayer> getOfflineLandPlayer(@NotNull UUID playerUID) {
        return null;
    }

    @Override
    public @Nullable Plugin getPlugin() {
        return null;
    }

    @Override
    @Deprecated
    public @NotNull Land getTopLand(@NotNull SortMode sortMode, int place) {
        return null;
    }

    @Override
    @Deprecated
    public @NotNull List<Land> getTopLands(SortMode sortMode) {
        return null;
    }

    @Override
    @Deprecated
    public @NotNull List<Land> getTopLands(@NotNull SortMode sortMode, int page) {
        return null;
    }

    @Override
    public @Nullable SortingContext<?> getSortingContext(@NotNull String id) {
        return null;
    }

    @Override
    public @NotNull String initialize() {
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
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isPublic() {
        return false;
    }

    @Override
    public void onLoad(@NotNull Runnable runnable) {

    }

    @Override
    public @NotNull List<String> printTopLands(SortMode sortMode, int page) {
        return null;
    }

    @Override
    public void registerFlag(@NotNull Flag flag) throws FlagConflictException, IllegalArgumentException {

    }

    @Override
    public void wild(@NotNull LandPlayer landPlayer, @NotNull World world) {

    }
}
