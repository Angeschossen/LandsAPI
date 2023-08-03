package me.angeschossen.lands.api.membershiprequest;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface LandMemberShipRequest {

    /**
     * Get the player's UUID that requested membership in the land.
     * @return UUID of the requester
     */
    @NotNull
    UUID getUID();
}
