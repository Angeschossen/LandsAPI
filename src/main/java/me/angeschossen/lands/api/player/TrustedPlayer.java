package me.angeschossen.lands.api.player;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface TrustedPlayer {

    /**
     * Get max chunk claims
     *
     * @return Max chunk claims
     */
    @NotNull
    int getSupportClaims();

    /**
     * Is the player trusted in the whole land?
     *
     * @return Is trusted in whole land
     */
    @NotNull
    boolean isTrustedWholeLand();

    /**
     * Get player UID
     */
    @NotNull
    UUID getUID();
}
