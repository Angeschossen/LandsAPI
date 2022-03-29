package me.angeschossen.lands.api.player;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.enums.LandGetMode;
import me.angeschossen.lands.api.war.War;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Set;

public interface LandPlayer extends OfflinePlayer {

    /**
     * Is the player participating in a war?
     *
     * @return true, if player is in war.
     */
    boolean isInWar();

    /**
     * Check if the player is participating in the war.
     *
     * @param war War
     * @return true, if they're participating in the war.
     */
    boolean isInWar(@NotNull War war);

    @NotNull Set<? extends War> getWars();

    /**
     * Get current selection.
     *
     * @return Selection
     */
    @Nullable
    Selection getSelection();

    /**
     * Get support claims per land.
     *
     * @return Max support claims
     */
    int getSupportClaimsPerLand();

    /**
     * Get player
     *
     * @return Will return null if player is offline.
     */
    @NotNull
    Player getPlayer();

    /**
     * Get a players /lands edit land.
     * @param sendMessage true: the player will receive a message, if they're not part of a land.
     * @return The current /lands edit land
     */
    @Nullable Land getEditLand(boolean sendMessage);

    /**
     * Get invite of land
     *
     * @param landName Name of land
     * @return Invite
     */
    Invite getInvite(@NotNull String landName);

    /**
     * Get land where the player is member in
     *
     * @param landName Name or displayname of land
     * @return Land or null, if not member
     */
    @Nullable
    Land getLand(@NotNull String landName);

    /**
     * Set edit land
     * /lands edit
     *
     * @param land Land to select
     */
    void setEditLand(@Nullable Land land);

    /**
     * Get all lands the player owns or is member of.
     *
     * @return Lands
     */
    @NotNull
    Set<? extends Land> getLands();

    /**
     * Get number of lands (own lands and where the player is trusted)
     *
     * @return Will return 0, if player has no lands.
     */
    int getSize();

    /**
     * Get an owning land
     *
     * @return Land or null, if player doesn't own a land
     */
    @Nullable
    Land getOwningLand();

    @NotNull Collection<? extends Invite> getInvites();

    /**
     * Check if player invited from land
     *
     * @param landName Name of land
     * @return Will return false if no invite from land found.
     */
    boolean hasInvite(@NotNull String landName);

    /**
     * Check if player has owning land
     *
     * @return Will return false if players doesn't own land.
     */
    boolean ownsLand();

    /**
     * Get names of lands.
     *
     * @return Array
     */
    String[] getLandNames();
}
