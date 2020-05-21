package me.angeschossen.lands.api.nation;

import me.angeschossen.lands.api.exceptions.LandAlreadyInNationException;
import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.NationInvite;
import me.angeschossen.lands.api.war.War;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface Nation extends BalanceHolder {

    @NotNull String getName();

    @NotNull
    String getColoredName();

    @Nullable
    War getWar();

    @NotNull
    Land getCapital();

    @NotNull UUID getLeaderUID();

    /**
     * Let a land join a nation.
     *
     * @param land Land to join this nation
     * @return Will return false, if the land can join the nation.
     * @throws LandAlreadyInNationException When land is already member of a nation.
     */
    boolean addLand(@NotNull Land land);

    /**
     * Let a land leave this nation.
     *
     * @param land Land to remove
     * @return Will return false if the land could not be removed.
     */
    boolean removeLand(@NotNull Land land);


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

    @NotNull Collection<? extends NationInvite> getSentInvites();

    double getBalance();

    boolean addBalance(double add);

    boolean setBalance(double balance);

    double getTax();

    void setTax(double tax);

    double addTax(double tax);

    int getSize();

    double getUpkeepCosts();

}