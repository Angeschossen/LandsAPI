package me.angeschossen.lands.api.war.captureflag;

import com.github.angeschossen.pluginframework.api.blockutil.BlockPosition;
import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import me.angeschossen.lands.api.events.war.captureflag.CaptureFlagBreakEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.War;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CaptureFlag extends ExpressionEntity {
    /**
     * Get the position of this capture flag.
     * @return Coordinates of the capture flag
     */
    @NotNull BlockPosition getPosition();

    WarTeam getTeam();

    boolean breakCaptureFlag(@Nullable LandPlayer player, boolean reward, boolean captured,
                             boolean exlosion, CaptureFlagBreakEvent.BreakReason reason);

    boolean breakCaptureFlag(@Nullable LandPlayer player, boolean reward, boolean captured, boolean end,
                             boolean explosion, CaptureFlagBreakEvent.BreakReason reason);

    void atUnload();

    /**
     * Get the war to which this capture flag belongs.
     * @return The war to which this capture flag belongs
     */
    @NotNull War getWar();
}
