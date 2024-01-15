package me.angeschossen.lands.api.war;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.declaration.WarDeclaration;
import me.angeschossen.lands.api.war.enums.WarSetting;
import me.angeschossen.lands.api.war.enums.WarStatus;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.function.Function;

public interface WarState {
    void broadcast(String key, String[] p, Function<Player, String[]> v, boolean filter);

    /**
     * Get the land or nation that declared war initially.
     *
     * @return The attacker
     */
    @NotNull MemberHolder getAttacker();

    @Nullable MemberHolder getEnemy(UUID playerUID);

    /**
     * Get the opposite team of the land or nation.
     *
     * @param memberHolder Land or nation
     * @return the provided memberHolder if it's not part of any team
     */
    @NotNull MemberHolder getEnemy(@NotNull MemberHolder memberHolder);

    MemberHolder getMemberHolder(@NotNull WarTeam warTeam);

    int getId();

    WarStatus getState();

    @NotNull WarTeam getTeam(MemberHolder entity);


    double getMaxTribute(WarTeam warTeam);

    float getPointsToWin();

    /**
     * Get the team the player belongs to.
     *
     * @param player The player
     * @return NEUTRAL, if the player is not related to any land or nation in this war
     */
    @NotNull WarTeam getTeam(@NotNull LandPlayer player);

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

    String getTime(@Nullable PlayerData sender);

    boolean hasFlag(WarSetting warSetting);

    double getTribute(MemberHolder entity);

    double getTribute();

    void setTribute(double tribute);

    /**
     * Check if this land or nation takes part in this war.
     * @param entity The land or nation
     * @return true, if it takes part in this war
     */
    boolean isParticipating(@NotNull MemberHolder entity);

    void sendCurrentInfo(@Nullable LandPlayer landPlayer, @Nullable MemberHolder warEntity);

    void delete();

    boolean surrender(MemberHolder surrenderer, @Nullable Player filter);

    MemberHolder[] getEntities();
}
