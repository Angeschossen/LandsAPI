package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface War {

    @NotNull WarTeam getTeam(@NotNull Player player);

    void end(@NotNull MemberHolder winner, boolean surrendered, double reward);

    boolean isParticipating(@NotNull MemberHolder entity);

    boolean isEndingSoon();

    @Nullable
    MemberHolder getWinner();

    @NotNull
    WarStats getAttackerStats();

    @NotNull
    WarStats getDefenderStats();
}
