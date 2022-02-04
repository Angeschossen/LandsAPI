package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import me.angeschossen.lands.api.player.Invite;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.role.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Area {

    double addTax(double tax);

    boolean banPlayer(UUID uuid);

    boolean canEnter(@NotNull LandPlayer landPlayer, boolean sendMessage);

    @NotNull
    String getColorName();

    @NotNull
    Role getEntryRole();

    @Nullable
    Invite getInvite(@NotNull UUID receiverUUID);

    Land getLand();

    @NotNull
    String getName();

    @NotNull
    UUID getOwnerUID();

    @NotNull
    Role getRole(@NotNull UUID playerUID);

    @NotNull
    Role getRole(@NotNull String name);

    double getTax();

    void setTax(double rent);

    @NotNull
    Role getVisitorRole();

    boolean hasFlag(@NotNull LandFlag flag);

    boolean hasFlag(@NotNull UUID playerUUID, @NotNull RoleFlag flag);

    boolean hasFlag(@NotNull Player player, @NotNull RoleFlag flag, @Nullable Material material, boolean sendMessage);

    boolean hasFlag(@NotNull Player player, @NotNull RoleFlag roleFlag, boolean sendMessage);

    boolean isBanned(@NotNull UUID playerUID);

    boolean isDefault();

    boolean isTrusted(UUID playerUID);

    boolean toggleFlag(@NotNull LandFlag flag);

    void unbanPlayer(UUID playerUID);
}
