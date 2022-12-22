package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.enums.FlagTarget;
import me.angeschossen.lands.api.flags.enums.RoleFlagCategory;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.role.Role;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public interface RoleFlag extends Flag<RoleFlag>, DefaultStateFlag<RoleFlag> {

    @NotNull
    static RoleFlag of(@NotNull Plugin plugin, @NotNull FlagTarget flagTarget, @NotNull RoleFlagCategory category, @NotNull String name) {
      return APIHandler.getFlagFactory().roleFlagOf(plugin, flagTarget, category, name);
    }

    @NotNull RoleFlag setUpdatePredicate(@NotNull Predicate<Role> predicate);

    boolean isToggleableByNation();

    @NotNull RoleFlag setToggleableByNation(boolean toggleable);

    void sendDenied(@NotNull LandPlayer landPlayer, @Nullable Area area);

    void sendDeniedInWar(@NotNull LandPlayer landPlayer, @Nullable Land land);

    @NotNull Predicate<Role> getUpdatePredicate();

    @NotNull String getBypassPermission();

    @NotNull String getBypassPermissionWilderness();

    @NotNull RoleFlagCategory getCategory();
}
