package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.player.Invite;
import me.angeschossen.lands.api.player.LandPlayer;
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

    boolean canManagement(UUID playerUUID, ManagementSetting managementSetting);

    boolean canEnter(@NotNull LandPlayer landPlayer, boolean sendMessage);

    boolean canSetting(Player player, RoleSetting action, boolean sendMessage);

    boolean canManagement(Player player, ManagementSetting managementSetting, boolean sendMessage);

    void setTax(double rent);

    @Nullable Invite getInvite(@NotNull UUID receiverUUID);

    double addTax(double tax);

    double getTax();
}
