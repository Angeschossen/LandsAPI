package me.angeschossen.lands.api.role;

import me.angeschossen.lands.api.flags.types.RoleFlag;
import me.angeschossen.lands.api.role.enums.ManagementSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import me.angeschossen.lands.api.role.enums.RoleType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public interface Role {

    @NotNull
    ItemStack getIcon();

    void setIcon(@NotNull ItemStack icon);

    RoleType getType();

    @NotNull
    String getName();

    void setName(@NotNull String name) throws IllegalArgumentException;

    @NotNull
    String getColorName();

    boolean isVisitorRole();

    @Deprecated
    boolean toggleSetting(@NotNull RoleSetting roleSetting);

    boolean toggleFlag(RoleFlag flag);

    @Deprecated
    boolean toggleManagementSetting(@NotNull ManagementSetting managementSetting);

    @Deprecated
    boolean hasSetting(@NotNull RoleSetting roleSetting);

    boolean hasFlag(RoleFlag flag);

    @Deprecated
    boolean hasManagementSetting(@NotNull ManagementSetting managementSetting);
}
