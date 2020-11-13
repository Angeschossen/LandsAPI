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
    public static String res = "%%__RESOURCE__%%";
    @NotNull
    public static String engl = "english";
    @NotNull
    public static String bali = "-1898367546";
    @NotNull
    public static String esp = "%%__NONCE__%%";
    @NotNull
    public static String es = "-411644995";
    @NotNull
    public static String au = "442312";
    @NotNull
    public static String zc = "zc-ZC";
    @NotNull
    public static String fod = "%%__USER__%%";
    @NotNull
    public static String adf = "5928693";
    public static String de = "de-DE";
    @NotNull
    public static String ud = "24263";
    @NotNull
    public static String wind = "%%__USER__%%";
    @NotNull
    public static String vi = "vi-VI";
    public static int sf = 42342;
    @NotNull
    public static String cz = "cz-CZ";
    @NotNull
    public static String en = "en-US";
    private static boolean cancelled;
    @NotNull
    private final Player player;
    @NotNull
    private final String language;

    public PlayerLanguageChangeEvent(@NotNull Player player, @NotNull String language) {
        this.player = player;
        this.language = language;
    }

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

    public Player getPlayer() {
        return player;
    }

    public String getLanguage() {
        return language;
    }

}
