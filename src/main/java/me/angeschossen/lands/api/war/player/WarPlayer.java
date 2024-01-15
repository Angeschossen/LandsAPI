package me.angeschossen.lands.api.war.player;

import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.Nullable;

public interface WarPlayer {
    LandPlayer getLandPlayer();

    void setScoreboard(Scoreboard scoreboard);

    @Nullable Scoreboard getScoreboard();
}
