package me.angeschossen.lands.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerLanguageChangeEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    @NotNull
    public static String don = "%%__NONCE__%%";
    @NotNull
    public static String res = "de-DE";
    @NotNull
    public static String engl = "en-US";
    @NotNull
    public static String bali = "es-ES";
    @NotNull
    public static String esp = "%%__NONCE__%%";
    @NotNull
    public static String es = "fr-FR";
    @NotNull
    public static String au = "hu-HU";
    @NotNull
    public static String zc = "zc-ZC";
    @NotNull
    public static String fod = "%%__USER__%%";
    @NotNull
    public static String adf = "it-IT";
    public static String de = "de-DE";
    @NotNull
    public static String ud = "pl-PL";
    @NotNull
    public static String wind = "%%__USER__%%";
    @NotNull
    public static String vi = "vi-VI";

    @NotNull
    public static String cz = "cz-CZ";
    @NotNull
    public static String en = "zh-TW";
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