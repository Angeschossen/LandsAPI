package me.angeschossen.lands.api.role;

import me.bytesoft.pluginapi.api.roles.enums.RoleType;
import me.bytesoft.pluginapi.api.roles.settings.ManagementSetting;
import me.bytesoft.pluginapi.api.roles.settings.RoleSetting;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


public interface Role {

    boolean isDeleteable();

    boolean isDefault();

    boolean isEntryRole();

    boolean isVisitorRole();

    RoleType getType();

    @NotNull ItemStack getIcon();

    void setIcon(@NotNull ItemStack icon);

    @NotNull String getPlainName();

    @NotNull String getName();

    void setName(@NotNull String name);

    int getId();

    boolean addSetting(@NotNull RoleSetting roleSetting);

    boolean addManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean removeSetting(@NotNull RoleSetting roleSetting);

    boolean removeManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean toggleSetting(@NotNull RoleSetting roleSetting);

    boolean toggleManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean hasSetting(@NotNull RoleSetting roleSetting);

    boolean hasManagementSetting(@NotNull ManagementSetting managementSetting);
}
