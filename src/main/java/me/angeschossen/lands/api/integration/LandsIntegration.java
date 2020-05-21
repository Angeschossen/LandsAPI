package me.angeschossen.lands.api.integration;


import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandArea;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


public class LandsIntegration implements LandsIntegrator {

    @Deprecated
    public LandsIntegration(@NotNull String name, boolean isPublic) {
    }

    @Deprecated
    public LandsIntegration(@NotNull Plugin plugin, boolean isPublic) {
    }

    public LandsIntegration(@NotNull String name) {
    }

    public LandsIntegration(@NotNull Plugin plugin) {
    }


    @Override
    public LandPlayer getLandPlayer(@NotNull UUID playerUUID) {
        return null;
    }

    @Override
    @Deprecated
    public LandWorld getLandWorld(@NotNull String worldName) {
        return null;
    }

    @Override
    public LandWorld getLandWorld(@NotNull World world) {
        return null;
    }

    @Override
    public boolean isClaimed(@NotNull Location location) {
        return false;
    }


    @Override
    public boolean isClaimed(@NotNull World world, int x, int z) {
        return false;
    }

    @Override
    @Deprecated
    public CompletableFuture<Boolean> isClaimed(@NotNull String worldName, int x, int z) {
        return null;
    }

    @Override
    @Deprecated
    public Land getLand(@NotNull String worldName, @NotNull String name) {
        return null;
    }

    @Override
    @Nullable
    public Land getLand(@NotNull String name) {
        return null;
    }

    @Override
    @Nullable
    public Land getLand(@NotNull Location location) {
        return null;
    }

    @Override
    @Nullable
    public Land getLand(@NotNull World world, int x, int z) {
        return null;
    }

    @Override
    @Nullable
    public LandArea getArea(@NotNull Location location) {
        return null;
    }

    @Override
    @Nullable
    public Plugin getPlugin() {
        return null;
    }

    @Override
    @NotNull
    public String getName() {
        return null;
    }

    @Override
    public void disable() {

    }

    @Override
    @Deprecated
    public void disable(@Nullable String hookKey) {
    }

    @NotNull
    @Override
    @Deprecated
    public String initialize() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    @Deprecated
    public boolean getAccess(@NotNull String hookKey) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isPublic() {
        return false;
    }
}
