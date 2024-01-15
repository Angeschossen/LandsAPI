package me.angeschossen.lands.api.war;

import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.captureflag.CaptureFlag;
import me.angeschossen.lands.api.war.enums.WarTeam;
import me.angeschossen.lands.api.war.player.WarPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface War extends ExpressionEntity, WarState {

    void addOnlinePlayer(LandPlayer landPlayer);

    void end();

    /**
     * End this war.
     *
     * @param winner      Who should be the winner? {@link #getDefender()} or {@link #getAttacker()}.
     * @param surrendered If true, the other team surrendered
     * @param reward      If true and surrendered is false, rewards from wars.yml are given to the winner
     */
    void end(@NotNull MemberHolder winner, boolean surrendered, double reward);

    /**
     * Get stats of this war for the attacker {@link #getAttacker()}.
     *
     * @return Stats of the attacker
     */
    @NotNull
    ActiveWarStats getAttackerStats();

    /**
     * Get online players of the attacker.
     *
     * @return Online players of the attacker
     */
    @NotNull Collection<? extends WarPlayer> getOnlineAttackers();

    Collection<? extends CaptureFlag> getCaptureFlags();

    /**
     * Get stats of this war for the defender {@link #getDefender()}.
     *
     * @return Stats of the defender
     */
    @NotNull
    ActiveWarStats getDefenderStats();

    /**
     * Get online players of the defender.
     *
     * @return Online players of the defender
     */
    @NotNull Collection<? extends WarPlayer> getOnlineDefenders();

    @Nullable Collection<? extends CaptureFlag> getPlacedByTeam(WarTeam warTeam);

    /**
     * @param winner The assumed winner
     * @return Configured robbery reward from wars.yml. The reward depends on the other teams balance
     */
    double getReward(@Nullable MemberHolder winner);

    WarStats getStats(WarTeam warTeam);

    long getStarted();
void setStarted(long started);
    WarPlayer getWarPlayer(LandPlayer landPlayer);

    /**
     * Get the current winner.
     *
     * @return The current winner
     */
    @Nullable
    MemberHolder getWinner();

    boolean hasFlag(@NotNull Land land, @NotNull LandPlayer landPlayer, @NotNull RoleFlag roleFlag, @Nullable Material material, boolean sendMessage);

    /**
     * Check if points to win from wars.yml is reached or war timeout from wars.yml is reached.
     *
     * @return true, if points to win is reached by the current {@link #getWinner()} or war timeout is reached.
     * The war will end in a matter of seconds of this method returns true
     */
    boolean isEndingSoon();

    boolean isParticipating(LandPlayer player);

    void removeOnlinePlayer(Player player, boolean logging);
}
