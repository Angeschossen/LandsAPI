package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.MemberHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface War {

    boolean isParticipating(@NotNull MemberHolder entity);

    boolean isEndingSoon();

    @Nullable
    MemberHolder getWinner();

    @NotNull
    WarStats getAttackerStats();

    @NotNull
    WarStats getDefenderStats();
}
