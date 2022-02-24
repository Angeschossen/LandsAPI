package me.angeschossen.lands.api.flags;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class Flag {

    public Flag(@NotNull Plugin plugin, @NotNull Flag.Target target, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
    }

    @NotNull
    public final Plugin getPlugin() {
        return null;
    }

    @NotNull
    public final ItemStack getIcon() {
        return null;
    }

    @NotNull
    public Flag setIcon(@Nullable ItemStack icon) {
        return this;
    }

    public final boolean isDisplayInWild() {
        return false;
    }

    public final boolean isAlwaysAllowInWild() {
        return false;
    }

    public final boolean isApplyInSubareas() {
        return false;
    }

    @Nullable
    public final List<String> getDescription() {
        return null;
    }

    @NotNull
    public Flag setDescription(@Nullable List<String> description) {
        return this;
    }

    @NotNull
    public Flag setDescription(@Nullable String description) {
        return this;
    }

    public boolean isDisplay() {
        return false;
    }

    @NotNull
    public Flag setDisplay(boolean display) {
        return this;
    }

    @NotNull
    public String getDisplayName() {
        return null;
    }

    @NotNull
    public Flag setDisplayName(@Nullable String displayName) {
        return this;
    }

    @NotNull
    public final String getName() {
        return null;
    }

    public boolean getWarState() {
        return false;
    }

    @NotNull
    public Flag setWarState(boolean state) {
        return this;
    }

    @NotNull
    public abstract String getTogglePerm();

    @NotNull
    public abstract Module getModule();

    public final @NotNull Target getTarget() {
        return null;
    }

    public enum Target {
        PLAYER, ADMIN
    }

    public enum Module {
        LAND, WAR, NATION
    }
}
