package me.angeschossen.lands.api.flags;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.exceptions.FlagConflictException;
import me.angeschossen.lands.api.flags.enums.FlagTarget;
import me.angeschossen.lands.api.flags.enums.RoleFlagCategory;
import me.angeschossen.lands.api.flags.type.NaturalFlag;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface FlagFactory {

    @NotNull RoleFlag roleFlagOf(@NotNull LandsIntegration plugin, @NotNull FlagTarget flagTarget, @NotNull RoleFlagCategory category, @NotNull String name) throws FlagConflictException, IllegalArgumentException;

    @NotNull NaturalFlag naturalFlagOf(@NotNull LandsIntegration plugin, @NotNull FlagTarget flagTarget, @NotNull String name) throws FlagConflictException, IllegalArgumentException;
}
