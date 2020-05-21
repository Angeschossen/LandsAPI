package me.angeschossen.lands.api.player;

public interface Visualization {

    /**
     * Show the visualization for the player.
     */
    void show(int timeOver);

    /**
     * Is permanent?
     */
    boolean isPermanent();

    /**
     * Re-calculate the visualization.
     */
    void calculate(boolean force);

    /**
     * Check if visualization has more time until it stops.
     *
     * @return Will return false if the visualization is about to stop.
     */
    boolean hasNext();

    /**
     * Stop the visualization.
     */
    void stop();
}
