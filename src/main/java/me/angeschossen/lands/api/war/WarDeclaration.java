package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.war.enums.WarTeam;


public interface WarDeclaration {

    void stop();

    void setTribute(double tribute);

    double getTribute();

    double getMaxTribute(WarTeam warTeam);

    boolean isValid();

    boolean startsSoon();
}
