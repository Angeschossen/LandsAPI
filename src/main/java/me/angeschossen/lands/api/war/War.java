package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface War {

    void end(@NotNull MemberHolder winner, boolean surrendered, double reward);

    @NotNull
    MemberHolder getAttacker();

    @NotNull
    WarStats getAttackerStats();

    @NotNull Collection<Player> getOnlineAttackers();

    @NotNull
    MemberHolder getDefender();

    @NotNull
    WarStats getDefenderStats();

    @NotNull Collection<Player> getOnlineDefenders();

    @NotNull MemberHolder getEnemy(@NotNull MemberHolder memberHolder);

    double getReward(@Nullable MemberHolder winner);

    @NotNull WarTeam getTeam(@NotNull Player player);

    @Nullable
    MemberHolder getWinner();

    boolean isEndingSoon();

    boolean isParticipating(@NotNull MemberHolder entity);
}
