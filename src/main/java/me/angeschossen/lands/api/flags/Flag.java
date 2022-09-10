package me.angeschossen.lands.api.flags;

import com.google.common.base.Preconditions;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public abstract class Flag {

    public static final ItemStack ICON_DEFAULT = new ItemStack(Material.NAME_TAG);

    public final Target target;
    protected final String name;
    protected final @NotNull Plugin plugin;
    private final int hashCode;
    private final boolean applyInSubAreas, alwaysAllowInWilderness;
    protected ItemStack icon = ICON_DEFAULT;
    private @Nullable List<String> description;
    private @Nullable String displayName;
    private boolean warState;
    private boolean display = true;

    public Flag(@NotNull Plugin plugin, @NotNull Flag.Target target, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
        Preconditions.checkNotNull(name, "Name cannot be null");
        Preconditions.checkNotNull(plugin, "Plugin cannot be null");

        this.target = target;
        this.name = name;
        this.applyInSubAreas = applyInSubAreas;
        this.alwaysAllowInWilderness = alwaysAllowInWilderness;
        this.hashCode = Objects.hash(this.name);
        this.plugin = plugin;
    }

    @NotNull
    public final Plugin getPlugin() {
        return plugin;
    }

    @NotNull
    public final ItemStack getIcon() {
        return icon;
    }

    @NotNull
    public Flag setIcon(@Nullable ItemStack icon) {
        this.icon = icon == null ? new ItemStack(Material.NAME_TAG) : icon.clone();
        ItemMeta iconMeta = this.icon.getItemMeta();
        iconMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        this.icon.setItemMeta(iconMeta);
        return this;
    }

    public final boolean isDisplayInWild() {
        return !alwaysAllowInWilderness;
    }

    public final boolean isAlwaysAllowInWild() {
        return alwaysAllowInWilderness;
    }

    public final boolean isApplyInSubareas() {
        return applyInSubAreas;
    }

    @Nullable
    public final List<String> getDescription() {
        return description;
    }

    @NotNull
    public Flag setDescription(@Nullable List<String> description) {
        this.description = description;
        return this;
    }

    @NotNull
    public Flag setDescription(@Nullable String description) {
        return this;
    }

    public boolean isDisplay() {
        return display;
    }

    @NotNull
    public Flag setDisplay(boolean display) {
        this.display = display;
        return this;
    }

    @NotNull
    public String getDisplayName() {
        return displayName == null ? name : displayName;
    }

    @NotNull
    public Flag setDisplayName(@Nullable String displayName) {
        this.displayName = displayName;
        return this;
    }

    @NotNull
    public final String getName() {
        return name;
    }

    public boolean getWarState() {
        return warState;
    }

    @NotNull
    public Flag setWarState(boolean state) {
        this.warState = state;
        return this;
    }

    @NotNull
    public abstract String getTogglePerm();

    @Override
    public int hashCode() {
        return hashCode;
    }

    @NotNull
    public abstract Module getModule();

    public final @NotNull Target getTarget() {
        return target;
    }

    public enum Target {
        PLAYER, ADMIN
    }

    public enum Module {
        LAND, WAR, NATION
    }
}
