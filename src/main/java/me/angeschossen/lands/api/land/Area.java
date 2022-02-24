package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.player.Invite;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.role.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Area {

    boolean banPlayer(UUID uuid);

    void unbanPlayer(UUID playerUID);

    boolean isBanned(@NotNull UUID playerUID);

    @NotNull
    UUID getOwnerUID();

    boolean isDefault();

    @Deprecated
    boolean hasLandSetting(LandSetting naturalFlags);

    boolean hasFlag(@NotNull LandFlag flag);

    @NotNull
    Role getRole(@NotNull UUID playerUID);

    @NotNull
    Role getRole(@NotNull String name);

    Land getLand();

    @NotNull
    Role getEntryRole();

    @NotNull
    Role getVisitorRole();

    boolean toggleFlag(@NotNull LandFlag flag);

    @Deprecated
    boolean toggleLandSetting(LandSetting naturalFlags);

    boolean isTrusted(UUID playerUID);

    boolean hasFlag(@NotNull UUID playerUUID, @NotNull RoleFlag flag);

    boolean canEnter(@NotNull LandPlayer landPlayer, boolean sendMessage);

    boolean hasFlag(@NotNull Player player, @NotNull RoleFlag flag, @Nullable Material material, boolean sendMessage);

    boolean hasFlag(@NotNull Player player, @NotNull RoleFlag roleFlag, boolean sendMessage);

    @Nullable
    Invite getInvite(@NotNull UUID receiverUUID);

    double addTax(double tax);

    double getTax();

    void setTax(double rent);

    @NotNull
    String getName();

    @NotNull
    String getColorName();
}
