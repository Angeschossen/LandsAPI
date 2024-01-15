package me.angeschossen.lands.api.war;

public interface ActiveWarStats extends WarStats{
    int getPoints();

    float getProgress(WarState warState);
}
