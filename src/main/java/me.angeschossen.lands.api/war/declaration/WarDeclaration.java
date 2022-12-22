package me.angeschossen.lands.api.war.declaration;

import me.angeschossen.lands.api.war.War;
import me.angeschossen.lands.api.war.enums.WarTeam;

public interface WarDeclaration {

    void setTribute(double tribute);

    double getTribute();

    double getMaxTribute(WarTeam warTeam);

    boolean startsSoon();

    War start();
}
