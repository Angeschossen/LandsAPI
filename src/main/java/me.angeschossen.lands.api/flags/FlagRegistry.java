package me.angeschossen.lands.api.flags;

import me.angeschossen.lands.api.exceptions.FlagConflictException;
import me.angeschossen.lands.api.flags.enums.FlagModule;
import me.angeschossen.lands.api.flags.enums.RoleFlagCategory;
import me.angeschossen.lands.api.flags.types.Flag;
import me.angeschossen.lands.api.flags.types.NaturalFlag;
import me.angeschossen.lands.api.flags.types.PlayerFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public interface FlagRegistry {

    @NotNull
    Flag<?> register(@NotNull Flag<?> flag) throws FlagConflictException, IllegalArgumentException;

    boolean isValidName(String name);

    @Nullable
    RoleFlag getInteract(@NotNull Block block, @Nullable ItemStack item);

    @Nullable RoleFlag getRole(@NotNull String name);

    @Nullable NaturalFlag getNatural(@NotNull String name);

    @Nullable Flag<?> get(@NotNull String name);

    @NotNull
    Collection<RoleFlag> getRoleFlags();

    @NotNull
    List<RoleFlag> getRoleFlags(@NotNull RoleFlagCategory category);

    @NotNull
    List<RoleFlag> getRoleFlags(@NotNull RoleFlagCategory category, @NotNull FlagModule module);

    @NotNull Collection<PlayerFlag> getPlayerFlags();

    @Nullable PlayerFlag getPlayer(@NotNull String name);

    @NotNull
    Collection<NaturalFlag> getNaturalFlags();
}
