package me.angeschossen.lands.api.war.captureflag;

import com.github.angeschossen.pluginframework.api.blockutil.BlockPosition;
import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import me.angeschossen.lands.api.war.War;
import org.jetbrains.annotations.NotNull;

public interface CaptureFlag extends ExpressionEntity {
    /**
     * Gets the position of this capture flag.
     * @return Coordinates of the capture flag
     */
    @NotNull BlockPosition getPosition();

    /**
     * Get the war to which this capture flag belongs.
     * @return The war to which this capture flag belongs
     */
    @NotNull War getWar();
}
