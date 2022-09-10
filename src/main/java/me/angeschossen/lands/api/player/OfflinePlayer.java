package me.angeschossen.lands.api.player;

import me.angeschossen.lands.api.land.Land;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public interface OfflinePlayer {

    @NotNull Land getEditLand();

    Collection<? extends Land> getLands();

    int getSize();

    /**
     * Get UID of player
     *
     * @return UUID
     */
    @NotNull
    UUID getUID();
}
