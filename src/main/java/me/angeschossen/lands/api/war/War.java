package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.role.enums.RoleSetting;
import me.angeschossen.lands.api.war.entity.WarEntity;
import me.angeschossen.lands.api.war.entity.WarStats;
import me.angeschossen.lands.api.war.enums.WarSetting;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public interface War {

    boolean canAction(@NotNull Player player, @NotNull RoleSetting landsAction, @Nullable Material material, boolean sendMessage);

    boolean toggleRoleAction(@NotNull RoleSetting landsAction);

    boolean toggleSetting(@NotNull WarSetting warSetting);

    @NotNull
    Set<RoleSetting> getRoleSettings();

    boolean isParticipating(@NotNull WarEntity entity);

    boolean isEndingSoon();

    @Nullable
    WarEntity getWinner();

    @NotNull
    WarStats getAttackerStats();

    @NotNull
    WarStats getDefenderStats();
}
