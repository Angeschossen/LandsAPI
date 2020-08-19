package me.angeschossen.lands.api.war.entity;

import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.enums.WarEntityType;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface WarEntity extends BalanceHolder {

    @Nullable
    WarTeam getWarTeam();

    @NotNull
    UUID getOwnerUID();

    @NotNull
    Collection<Player> getOnlinePlayers();

    @NotNull
    Collection<? extends LandPlayer> getOnlineLandPlayers();

    boolean leaveWar();

    void addWarShieldTime(long seconds);

    boolean hasWarShield();

    long getWarShield();

    boolean hasWarEntity(@NotNull WarEntity entity);

    boolean isInWar();

    WarEntityType getType();

    boolean isWarField();

    @NotNull
    WarStats getStats();

    boolean isTrusted(@NotNull UUID uuid);
}
