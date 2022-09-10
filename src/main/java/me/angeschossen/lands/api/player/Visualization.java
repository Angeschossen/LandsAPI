package me.angeschossen.lands.api.player;

public interface Visualization {

    /**
     * Is permanent?
     * @return true, if permanent.
     */
    boolean isPermanent();

    /**
     * Check if visualization has more time until it stops.
     *
     * @return Will return false if the visualization is about to stop.
     */
    boolean hasNext();
}
