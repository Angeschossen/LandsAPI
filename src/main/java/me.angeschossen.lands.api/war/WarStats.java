package me.angeschossen.lands.api.war;

public interface WarStats {

    /**
     * Get win-lost wars ratio.
     *
     * @return win-lost wars ratio
     */
    double getWLRatio();

    /**
     * Get amount of wars won.
     *
     * @return Amount of wars that they have won
     */
    int getWon();

    /**
     * Get amount of wars lost.
     *
     * @return Amount of wars that they have lost
     */
    int getLost();

    /**
     * Get kill-death wars ratio.
     *
     * @return kill-death ratio
     */
    double getKDRatio();

    /**
     * Get amount of kills.
     *
     * @return Amount of kills
     */
    int getKills();

    /**
     * Get amount of deaths.
     *
     * @return Amount of deaths
     */
    int getDeaths();

    /**
     * Get amount of captures. See {@link CaptureFlag} for more information.
     *
     * @return Amount of captures
     */
    int getCaptures();
}
