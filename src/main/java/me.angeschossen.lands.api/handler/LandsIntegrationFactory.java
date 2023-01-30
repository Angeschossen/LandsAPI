package me.angeschossen.lands.api.handler;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.combat.CombatTag;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface LandsIntegrationFactory {

    @NotNull LandsIntegration of(@NotNull Plugin plugin);

    @NotNull CombatTag combatTagOf(@NotNull LandPlayer attacker, LandPlayer target, long duration, boolean showMessage);
}
