package me.angeschossen.lands.api.war;

public interface WarStats {

    double getWLRatio();

    int getWon();

    int getLost();

    double getKDRatio();

    int getKills();

    int getDeaths();

    int getCaptures();
}
