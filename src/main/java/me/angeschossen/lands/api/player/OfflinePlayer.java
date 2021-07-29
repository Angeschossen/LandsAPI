package me.angeschossen.lands.api.player;

import me.angeschossen.lands.api.land.Land;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface OfflinePlayer {
    @Nullable Land getEditLand();

    Collection<? extends Land> getLands();

    /**
     * Get UID of player
     *
     * @return UUID
     */
    @NotNull
    UUID getUID();

    int getSize();
}
