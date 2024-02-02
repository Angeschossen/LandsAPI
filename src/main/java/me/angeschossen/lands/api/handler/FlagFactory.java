package me.angeschossen.lands.api.handler;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.exceptions.FlagConflictException;
import me.angeschossen.lands.api.flags.enums.FlagTarget;
import me.angeschossen.lands.api.flags.enums.RoleFlagCategory;
import me.angeschossen.lands.api.flags.type.NaturalFlag;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import me.angeschossen.lands.api.role.system.SystemFlagStates;
import org.jetbrains.annotations.NotNull;

/**
 * This interface is not intended for direct usage and might change at any time.
 */
public interface FlagFactory {

    @NotNull RoleFlag roleFlagOf(@NotNull LandsIntegration plugin, @NotNull FlagTarget flagTarget, @NotNull RoleFlagCategory category, @NotNull String name) throws FlagConflictException, IllegalArgumentException;

    @NotNull NaturalFlag naturalFlagOf(@NotNull LandsIntegration plugin, @NotNull FlagTarget flagTarget, @NotNull String name) throws FlagConflictException, IllegalArgumentException;

    void dropSystemFlagStatesCache(@NotNull SystemFlagStates systemFlagStates);
}
