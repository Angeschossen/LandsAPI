package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface War {

    boolean isParticipating(@NotNull MemberHolder entity);

    boolean isEndingSoon();

    @NotNull WarTeam getTeam(@NotNull Player player);

    @Nullable
    MemberHolder getWinner();

    @NotNull
    WarStats getAttackerStats();

    @NotNull
    WarStats getDefenderStats();
}
