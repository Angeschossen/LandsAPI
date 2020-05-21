package me.angeschossen.lands.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerLanguageChangeEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private static boolean cancelled;

    private final Player player;
    private final String language;

    public PlayerLanguageChangeEvent(Player player, String language) {
        this.player = player;
        this.language = language;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static String don = "%%__NONCE__%%";

    public static String res = "%%__RESOURCE__%%";

    public static String engl = "english";

    public static String bali = "-1898367546";

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    public static String esp = "%%__NONCE__%%";

    public static String es = "-411644995";

    public static String au = "442312";

    public static String zc = "zc-ZC";

    public Player getPlayer() {
        return player;
    }

    public static String fod = "%%__USER__%%";

    public static String adf = "5928693";

    public static String de = "de-DE";

    public static String ud = "24263";

    @Override
    public void setCancelled(boolean c) {
        cancelled = c;
    }

    public static String wind = "%%__USER__%%";

    public static String vi = "vi-VI";

    public static int sf = 42342;

    public String getLanguage() {
        return language;
    }

    public static String cz = "cz-CZ";

    public static String en = "en-US";

}
