package me.angeschossen.lands.api.integration;


import me.angeschossen.lands.Lands;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandArea;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.database.Database;
import me.angeschossen.lands.database.objects.land.ILandWorld;
import me.angeschossen.lands.utils.AddonManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


public class LandsIntegration implements LandsIntegrator {

    private Database database;
    private String key;

    private final Plugin plugin;
    private final boolean isPublic;
    private final String name;

    @Deprecated
    public LandsIntegration(@NotNull String name, boolean isPublic) {
        this(name, Bukkit.getPluginManager().getPlugin(name), isPublic);
    }

    @Deprecated
    public LandsIntegration(@NotNull Plugin plugin, boolean isPublic) {
        this(plugin.getName(), plugin, isPublic);
    }


    public LandsIntegration(@NotNull String name) {
        this(name, Bukkit.getPluginManager().getPlugin(name), false);
    }

    public LandsIntegration(@NotNull Plugin plugin) {
        this(plugin.getName(), plugin, false);
    }

    private LandsIntegration(@NotNull String name, @Nullable Plugin plugin, boolean isPublic) {
        if (plugin != null && !plugin.isEnabled()) {
            throw new IllegalArgumentException("Plugin " + name + " needs to be enabled.");
        }

        this.name = name;
        this.plugin = plugin;
        this.isPublic = isPublic;
        initialize();
    }

    @Override
    public LandPlayer getLandPlayer(@NotNull UUID playerUUID) {
        return database.getLandPlayer(playerUUID);
    }

    @Override
    @Deprecated
    public LandWorld getLandWorld(@NotNull String worldName) {
        return database.getLandWorld(worldName);
    }

    @Override
    public LandWorld getLandWorld(@NotNull World world) {
        return database.getLandWorld(world.getName());
    }

    @Override
    public boolean isClaimed(@NotNull Location location) {
        return isClaimed(location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4);
    }


    @Override
    public boolean isClaimed(@NotNull World world, int x, int z) {
        ILandWorld landWorld = database.getLandWorld(world);
        return landWorld != null && landWorld.isChunkClaimed(x, z);
    }

    @Override
    @Deprecated
    public CompletableFuture<Boolean> isClaimed(@NotNull String worldName, int x, int z) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            return CompletableFuture.completedFuture(isClaimed(world, x, z));
        }

        return CompletableFuture.completedFuture(false);
    }

    @Override
    @Deprecated
    public Land getLand(@NotNull String worldName, @NotNull String name) {
        return ILandWorld.getLandStatic(name);
    }

    @Override
    @Nullable
    public Land getLand(@NotNull String name) {
        return ILandWorld.getLandStatic(name);
    }

    @Override
    @Nullable
    public Land getLand(@NotNull Location location) {
        return database.getLand(location);
    }

    @Override
    @Nullable
    public Land getLand(@NotNull World world, int x, int z) {
        return database.getLand(world.getName(), x, z);
    }

    @Override
    @Nullable
    public LandArea getArea(@NotNull Location location) {
        return database.getArea(location);
    }

    @Override
    @Nullable
    public Plugin getPlugin() {
        return plugin;
    }

    @Override
    @NotNull
    public String getName() {
        return name;
    }

    @Override
    public void disable() {

        //ignore if lands isnt enabled aynway
        if (!Bukkit.getPluginManager().isPluginEnabled("Lands")) {
            return;
        }

        database = null;
        AddonManager.getInstance().removeLandsAPIHook(this, key);
    }

    @Override
    @Deprecated
    public void disable(@Nullable String hookKey) {
        disable();
    }

    @NotNull
    @Override
    @Deprecated
    public String initialize() {
        checkEnabled();

        if (key != null) {
            return key;
        }

        database = Lands.database;
        key = AddonManager.getInstance().getSaltString();
        AddonManager.getInstance().addLandsAPIHook(this, key);
        return key;
    }

    @Override
    public boolean isEnabled() {
        return database != null;
    }

    @Override
    @Deprecated
    public boolean getAccess(@NotNull String hookKey) {
        return hookKey.equals(key);
    }

    @Override
    @Deprecated
    public boolean isPublic() {
        return isPublic;
    }

    private void checkEnabled() {
        if (!Bukkit.getPluginManager().isPluginEnabled("Lands")) {
            throw new IllegalStateException("[Lands] Lands isn't enabled yet. Plugin " + getName() + " needs to be enabled after Lands.");
        }
    }
}
