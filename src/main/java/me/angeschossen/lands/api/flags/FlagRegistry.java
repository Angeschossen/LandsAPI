package me.angeschossen.lands.api.flags;

import me.angeschossen.lands.api.exceptions.FlagConflictException;
import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public interface FlagRegistry {
    @NotNull
    Flag register(@NotNull Flag flag) throws FlagConflictException, IllegalArgumentException;

    boolean isValidName(String name);

    @Nullable RoleFlag getRole(@NotNull String name);

    @Nullable LandFlag getLand(@NotNull String name);

    @Nullable Flag get(@NotNull String name);

    @NotNull
    Collection<RoleFlag> getRoleFlags();

    @NotNull
    List<RoleFlag> getRoleFlags(@NotNull RoleFlag.Category category);

    @NotNull
    List<RoleFlag> getRoleFlags(@NotNull RoleFlag.Category category, @NotNull RoleFlag.Module module);

    @NotNull
    Collection<LandFlag> getLandFlags();
}
