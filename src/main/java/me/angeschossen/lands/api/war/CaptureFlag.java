package me.angeschossen.lands.api.war;

import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import org.jetbrains.annotations.NotNull;

public interface CaptureFlag extends ExpressionEntity {
    @NotNull War getWar();
}
