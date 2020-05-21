package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.role.enums.RoleSetting;
import me.angeschossen.lands.api.war.enums.WarSetting;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public interface War {

    boolean canAction(Player player, RoleSetting landsAction, @Nullable Material material, boolean sendMessage);

    boolean toggleRoleAction(RoleSetting landsAction);

    boolean toggleSetting(WarSetting warSetting);

    int getId();

    Set<RoleSetting> getRoleActions();

    boolean isParticipating(WarEntity entity);

    boolean isEndingSoon();

    boolean attackersWin();

    WarEntity getWinner();

    WarStats getAttackerStats();

    WarStats getDefenderStats();
}
