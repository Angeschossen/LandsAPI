package me.angeschossen.lands.api.role;

import me.angeschossen.lands.api.role.enums.ManagementSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public interface Role {

    boolean isDeleteable();

    boolean isDefault();

    boolean isEntryRole();

    boolean isVisitorRole();

    @NotNull ItemStack getIcon();

    void setIcon(@NotNull ItemStack icon);

    @NotNull String getPlainName();

    @NotNull String getName();

    void setName(@NotNull String name);

    boolean toggleSetting(@NotNull RoleSetting roleSetting);

    boolean toggleManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean hasSetting(@NotNull RoleSetting roleSetting);

    boolean hasManagementSetting(@NotNull ManagementSetting managementSetting);
}
