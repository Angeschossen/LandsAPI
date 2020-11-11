package me.angeschossen.lands.api.role;

import me.angeschossen.lands.api.role.enums.ManagementSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public interface Role {

    @NotNull
    ItemStack getIcon();

    @NotNull
    String getName();

    @NotNull
    String getColorName();

    boolean isVisitorRole();

    boolean toggleSetting(@NotNull RoleSetting roleSetting);

    boolean toggleManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean hasSetting(@NotNull RoleSetting roleSetting);

    boolean hasManagementSetting(@NotNull ManagementSetting managementSetting);
}
