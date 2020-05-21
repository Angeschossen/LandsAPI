package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.land.Land;

public interface Nation {
    Land getLeader();

    boolean isInWar();

    boolean isInWarWith(Land land);

    boolean hasLand(Land land);
}
