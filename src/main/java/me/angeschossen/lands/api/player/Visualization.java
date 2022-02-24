package me.angeschossen.lands.api.player;

public interface Visualization {

    /**
     * @return Whether the visualization is permanent or not.
     */
    boolean isPermanent();

    /**
     * Check if visualization has more time until it stops.
     *
     * @return Will return false if the visualization is about to stop.
     */
    boolean hasNext();
}
