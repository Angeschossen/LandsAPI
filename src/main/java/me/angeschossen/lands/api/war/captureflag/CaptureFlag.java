package me.angeschossen.lands.api.war.captureflag;

import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import me.angeschossen.lands.api.war.War;
import org.jetbrains.annotations.NotNull;

public interface CaptureFlag extends ExpressionEntity {
    @NotNull War getWar();
}
