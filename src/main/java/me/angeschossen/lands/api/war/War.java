package me.angeschossen.lands.api.war;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import me.angeschossen.lands.api.war.entity.WarEntity;
import me.angeschossen.lands.api.war.entity.WarStats;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface War {

    @Deprecated
    boolean canAction(@NotNull Land land, @NotNull Player player, @NotNull RoleSetting landsAction, @Nullable Material material);

    boolean isParticipating(@NotNull WarEntity entity);

    boolean isEndingSoon();

    @Nullable
    WarEntity getWinner();

    @NotNull
    WarStats getAttackerStats();

    @NotNull
    WarStats getDefenderStats();
}
