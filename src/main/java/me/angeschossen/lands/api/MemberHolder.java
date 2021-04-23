package me.angeschossen.lands.api;

import me.angeschossen.lands.api.events.LandChatEvent;
import me.angeschossen.lands.api.holders.BalanceHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.entity.WarStats;
import me.angeschossen.lands.api.war.enums.WarTeam;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Collection;
import java.util.UUID;

public interface MemberHolder extends BalanceHolder {
    @NotNull
    String getName();

    @NotNull
    String getColorName();

    @Nullable
    Color getWebMapColor();

    @NotNull
    Collection<? extends LandPlayer> getOnlineLandPlayers();

    @NotNull
    UUID getOwnerUID();

    @NotNull
    Collection<Player> getOnlinePlayers();

    boolean isTrusted(@NotNull UUID uuid);

    int getId();

    HolderType getType();

    @Nullable
    WarTeam getWarTeam();

    boolean leaveWar();

    void addWarShield(long seconds);

    boolean hasWarShield();

    long getWarShield();

    boolean hasWarEntity(@NotNull MemberHolder entity);

    boolean exists();

    /**
     * Send message to online players of this land.
     *
     * @param playerUUID Sender
     * @param message    Message
     */
    void sendMessage(@NotNull UUID playerUUID, @NotNull String message, LandChatEvent.MessageSource messageSource);

    boolean isInWar();

    boolean isWarField();

    String getWarName();

    @NotNull
    WarStats getStats();
}
