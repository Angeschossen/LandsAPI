package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.war.enums.WarEntityType;
import me.angeschossen.lands.api.war.enums.WarTeam;


import java.util.UUID;

public interface WarEntity extends BalanceHolder {

    int getMembersAmount();

    WarTeam getWarTeam();

    UUID getOwnerUID();

    void addWarShieldTime(long seconds);

    boolean hasWarShield();

    String getWarShieldTime();

    boolean hasWarEntity(WarEntity entity);

    boolean isInWar();

    WarEntityType getType();

    boolean isInFight();

    boolean isWarField();

}
