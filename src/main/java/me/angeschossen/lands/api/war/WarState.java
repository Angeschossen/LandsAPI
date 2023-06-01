package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface WarState {
    /**
     * Get the land or nation that declared war initially.
     *
     * @return The attacker
     */
    @NotNull MemberHolder getAttacker();

    /**
     * Get the opposite team of the land or nation.
     *
     * @param memberHolder Land or nation
     * @return the provided memberHolder if it's not part of any team
     */
    @NotNull MemberHolder getEnemy(@NotNull MemberHolder memberHolder);

    /**
     * Get the team the player belongs to.
     *
     * @param player The player
     * @return NEUTRAL, if the player is not related to any land or nation in this war
     */
    @NotNull WarTeam getTeam(@NotNull Player player);

    /**
     * Get the land or nation that was declared war against by the attacker.
     *
     * @return The defender
     */
    @NotNull MemberHolder getDefender();

    /**
     * Check if this land or nation takes part in this war.
     * @param entity The land or nation
     * @return true, if it takes part in this war
     */
    boolean isParticipating(@NotNull MemberHolder entity);
}
