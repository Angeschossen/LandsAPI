package me.angeschossen.lands.api.flags;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class Flag {


    public Flag(@NotNull Plugin plugin, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {

    }

    @NotNull
    public final Plugin getPlugin() {
        return null;
    }

    @Nullable
    public final ItemStack getIcon() {
        return null;
    }

    @NotNull
    public Flag setIcon(@NotNull ItemStack icon) {
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
    public Flag setDescription(@Nullable String description) {
        return this;
    }

    public boolean isDisplay() {
        return false;
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

    @NotNull
    public abstract Type getType();

    public enum Module {
        LAND, WAR, NATION
    }

    public enum Type {
        ROLE, LAND
    }
}
