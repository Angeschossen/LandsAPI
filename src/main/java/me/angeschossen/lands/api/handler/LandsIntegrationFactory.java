package me.angeschossen.lands.api.handler;

import com.github.angeschossen.pluginframework.api.blockutil.BlockPosition;
import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.land.Container;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.block.LandMainBlock;
import me.angeschossen.lands.api.land.enums.LandType;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.Selection;
import me.angeschossen.lands.api.player.combat.CombatTag;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * This interface is not intended for direct usage and might change at any time.
 */
public interface LandsIntegrationFactory {

    @NotNull LandsIntegration of(@NotNull Plugin plugin);

    @NotNull CombatTag combatTagOf(@NotNull LandsIntegration landsIntegration, @NotNull LandPlayer attacker, LandPlayer target, long duration, boolean showMessage);

    @NotNull
    CompletableFuture<? extends Land> landOf(@NotNull String name, @NotNull LandType landType, @NotNull Location location, @NotNull LandPlayer owner, boolean claim, boolean msg);

    LandMainBlock landMainBlockOf(@Nullable LandPlayer landPlayer, @NotNull BlockPosition blockPosition);

    @NotNull
    Selection selectionOf(@NotNull LandPlayer landPlayer, boolean giveTool, boolean msg, boolean visualization);
}
