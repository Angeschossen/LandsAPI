package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import me.angeschossen.lands.api.war.enums.WarSetting;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;

import java.util.Set;

public interface War {

    boolean canAction(Player player, RoleSetting landsAction, boolean sendMessage);

    boolean toggleRoleAction(RoleSetting landsAction);

    boolean toggleSetting(WarSetting warSetting);

    int getID();

    void start();

    Land getInitialAttacker();

    Set<RoleSetting> getRoleActions();

    boolean isParticipating(Land land);

    boolean isEndingSoon();

    boolean attackersWin();

    WarTeam getWinner();

    WarStats getAttackerStats();

    WarStats getDefenderStats();
}
