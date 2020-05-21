package me.angeschossen.lands.internal.api.roles;

import me.angeschossen.lands.api.role.Role;
import me.angeschossen.lands.internal.api.roles.enums.RoleType;
import me.angeschossen.lands.internal.api.roles.settings.ManagementSetting;
import me.angeschossen.lands.internal.api.roles.settings.RoleSetting;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.management.openmbean.KeyAlreadyExistsException;

public interface RoleInternal {

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

    boolean addSetting(@NotNull RoleSetting roleSetting);

    boolean addManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean removeSetting(@NotNull RoleSetting roleSetting);

    boolean removeManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean toggleSetting(@NotNull RoleSetting roleSetting);

    boolean toggleManagementSetting(@NotNull ManagementSetting managementSetting);

    boolean hasSetting(@NotNull RoleSetting roleSetting);

    @Nullable Role getPromote();

    boolean isOwnerRole();

    @Nullable Role getDemote(boolean allowVisitor);

    boolean hasManagementSetting(@NotNull ManagementSetting managementSetting);
}
