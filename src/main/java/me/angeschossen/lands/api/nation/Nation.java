package me.angeschossen.lands.api.nation;

import me.angeschossen.lands.api.MemberHolder;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Nation extends MemberHolder {

    @NotNull
    Land getCapital();

    /**
     * Check if a land is member of this nation.
     *
     * @return Will return false if land is not member of this nation.
     */
    boolean isMember(Land land);

    boolean isMember(LandPlayer landPlayer);

    /**
     * Get the members of this land.
     *
     * @return Lands of this nation.
     */
    @NotNull
    Collection<? extends Land> getLands();
}