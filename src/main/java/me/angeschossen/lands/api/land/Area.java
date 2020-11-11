package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.player.Invite;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.role.Role;
import me.angeschossen.lands.api.role.enums.ManagementSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Area {

    void banPlayer(UUID uuid);

    void unbanPlayer(UUID playerUID);

    boolean isBanned(@NotNull UUID playerUID);

    boolean hasLandSetting(LandSetting naturalFlags);

    boolean toggleLandSetting(LandSetting naturalFlags);

    boolean isTrusted(UUID playerUID);

    boolean canSetting(UUID playerUUID, RoleSetting roleSetting);

    @NotNull
    Role getEntryRole();

    @NotNull
    Role getRole(@NotNull UUID playerUID);

    @NotNull
    Role getRole(@NotNull String name);

    boolean canManagement(UUID playerUUID, ManagementSetting managementSetting);

    boolean canEnter(@NotNull LandPlayer landPlayer, boolean sendMessage);

    boolean canSetting(Player player, RoleSetting action, boolean sendMessage);

    Land getLand();

    boolean canManagement(Player player, ManagementSetting managementSetting, boolean sendMessage);

    @Nullable Invite getInvite(@NotNull UUID receiverUUID);

    double addTax(double tax);

    double getTax();

    void setTax(double rent);

    @NotNull
    String getName();

    @NotNull
    String getColorName();
}
