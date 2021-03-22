package me.angeschossen.lands.api.player;

import me.angeschossen.lands.api.land.Land;

import java.util.Collection;

public interface OfflinePlayer {
    Collection<? extends Land> getLands();

    int getSize();
}
