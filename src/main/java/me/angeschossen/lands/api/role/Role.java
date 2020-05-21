package me.angeschossen.lands.api.role;

import me.angeschossen.lands.api.role.enums.ManagementSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface Role {

    List<UUID> getPlayers();

    void setIcon(ItemStack itemStack);

    ItemStack getIcon();

    Set<RoleSetting> getSettings();

    void setName(String name);

    String getName();

    int getId();

    int getPriority();

    boolean addSetting(RoleSetting roleSetting);

    boolean addManagementSetting(ManagementSetting managementSetting);

    boolean removeSetting(RoleSetting roleSetting);

    boolean removeManagementSetting(ManagementSetting managementSetting);

    boolean toggleSetting(RoleSetting roleSetting);

    boolean toggleManagementSetting(ManagementSetting managementSetting);

    boolean hasSetting(RoleSetting roleSetting);

    boolean hasManagementSetting(ManagementSetting managementSetting);

    Role getPromote();

    Role getDemote();
}
