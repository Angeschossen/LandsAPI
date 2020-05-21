package me.angeschossen.lands.api.player;

import org.jetbrains.annotations.NotNull;

public interface Visualization {

    /**
     * Show the visualization for the player.
     */
    void show();

    /**
     * Re-calculate the visualization.
     */
    void calculate();

    /**
     * Check if visualization has more time until it stops.
     *
     * @return Will return false if the visualization is about to stop.
     */
    @NotNull
    boolean hasNext();

    /**
     * Stop the visualization.
     */
    void stop();
}
