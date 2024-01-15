package me.angeschossen.lands.api.war.player;

import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Holds war specific data during war for players.
 */
public interface WarPlayer {
    /**
     * Get the player.
     *
     * @return player interface
     */
    @NotNull
    LandPlayer getLandPlayer();

    /**
     * Set the scoreboard for this player
     *
     * @param scoreboard if null, removes scoreboard
     */
    void setScoreboard(@Nullable Scoreboard scoreboard);

    /**
     * Get the current set scoreboard
     *
     * @return current set scoreboard
     */
    @Nullable Scoreboard getScoreboard();
}
