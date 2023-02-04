package me.angeschossen.lands.api.nation;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public interface Nation extends MemberHolder {

    /**
     * Delete the nation.
     * @param deleter The player that initiates the deletion.
     *                This is mainly used to prevent the player from receiving a message from your plugin and additionally a inbox message in lands of the nation.
     *                Just to prevent spam.
     * @return false, if a 3rd party plugin cancelled the deletion.
     */
    CompletableFuture<Boolean> delete(@Nullable LandPlayer deleter);

    @NotNull
    Land getCapital();

    /**
     * Check if a land is member of this nation.
     *
     * @return Will return false if land is not member of this nation.
     */
    boolean isMember(Land land);

    /**
     * Get the members of this land.
     *
     * @return Lands of this nation.
     */
    @NotNull
    Collection<? extends Land> getLands();
}