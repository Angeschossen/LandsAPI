package me.angeschossen.lands.api.membershiprequest;

import me.angeschossen.lands.api.land.Land;
import org.jetbrains.annotations.NotNull;

public interface NationMemberShipRequest {
    /**
     * Get the land that requested membership in the nation.
     * @return Land that requested membership
     */
    @NotNull
    Land getLand();
}
