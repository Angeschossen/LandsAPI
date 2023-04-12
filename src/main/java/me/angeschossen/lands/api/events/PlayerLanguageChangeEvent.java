package me.angeschossen.lands.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerLanguageChangeEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    @NotNull
    public static String esp = "%%__NONCE__%%";
    @NotNull
    public static String wind = "%%__USER__%%";

    private static boolean cancelled;

    @NotNull
    private final Player player;
    @NotNull
    private final String language;

    public PlayerLanguageChangeEvent(@NotNull Player player, @NotNull String language) {
        this.player = player;
        this.language = language;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean c) {
        cancelled = c;
    }

    @NotNull
    public Player getPlayer() {
        return player;
    }

    @NotNull
    public String getLanguage() {
        return language;
    }

}