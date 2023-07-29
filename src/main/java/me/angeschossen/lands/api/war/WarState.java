package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.war.declaration.WarDeclaration;
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
     * If state represents:
     * {@link War}: Get the time left until the war ends forcefully (no team reached the needed amount of points)
     * {@link WarDeclaration} Time until the war starts
     * {@link me.angeschossen.lands.api.war.declaration.MutualDeclaration} Time until the declaration is automatically being declined.
     * @return Time in seconds
     */
    long getTimeLeft();

    /**
     * Check if this land or nation takes part in this war.
     * @param entity The land or nation
     * @return true, if it takes part in this war
     */
    boolean isParticipating(@NotNull MemberHolder entity);
}
