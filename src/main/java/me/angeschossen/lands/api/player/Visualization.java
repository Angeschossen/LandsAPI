package me.angeschossen.lands.api.player;

public interface Visualization {

    /**
     * Is permanent?
     * @return If true, the visualization never expires as long as the player is online
     */
    boolean isPermanent();

    /**
     * Check if visualization has more time until it stops.
     *
     * @return Will return false if the visualization is about to stop.
     */
    boolean hasNext();
}
