package me.angeschossen.lands.api.handler;

import me.angeschossen.lands.api.LandsIntegration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface LandsIntegrationFactory {

    @NotNull LandsIntegration of(@NotNull Plugin plugin);
}
