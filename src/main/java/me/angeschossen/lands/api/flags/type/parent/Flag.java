package me.angeschossen.lands.api.flags.type.parent;

import me.angeschossen.lands.api.flags.enums.FlagModule;
import me.angeschossen.lands.api.flags.enums.FlagTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Flag<T> {

    @NotNull Plugin getPlugin();

    @NotNull ItemStack getIcon();

    @NotNull T setIcon(@Nullable ItemStack icon);

    boolean isDisplayInWilderness();

    boolean isAlwaysAllowInWilderness();

    T setAlwaysAllowInWilderness(boolean allow);

    boolean isApplyInSubareas();

    T setApplyInSubareas(boolean set);

    @Nullable List<String> getDescription();

    @NotNull T setDescription(@Nullable List<String> description);

    @NotNull T setDescription(@Nullable String description);

    boolean isDisplay();

    @NotNull T setDisplay(boolean display);

    @NotNull String getDisplayName();

    @NotNull T setDisplayName(@Nullable String displayName);

    @NotNull String getName();

    boolean isActiveInWar();

    @NotNull T setActiveInWar(boolean activeInWar);

    @NotNull String getTogglePermission();

    @NotNull FlagModule getModule();

    @NotNull FlagTarget getTarget();
}
