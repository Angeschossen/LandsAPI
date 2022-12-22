package me.angeschossen.lands.api.war.enums;

public enum WarTeam {

    ATTACKER, DEFENDER, NEUTRAL;

    public WarTeam getOpposite() {
        return this == ATTACKER ? DEFENDER : this == DEFENDER ? ATTACKER : NEUTRAL;
    }
}
