package me.angeschossen.lands.api.events.land;

/**
 * Delete reasons are used at the {@link me.angeschossen.lands.api.events.ChunkDeleteEvent} and {@link me.angeschossen.lands.api.events.LandDeleteEvent}.
 */
public enum DeleteReason {
    /**
     * Used at command execution through player or when 3rd party plugins didn't specify a delete-reason.
     */
    DEFAULT,
    /**
     * Deletion because of insufficient funds.
     */
    UPKEEP,
    /**
     * Forcefully deletion triggered by a server admin via a cmd.
     */
    ADMIN,
    /**
     * A land is deleted because of inactivity of the owner.
     */
    INACTIVITY,
    /**
     * Use {@link DeleteReason#INACTIVITY} instead.
     */
    @Deprecated EXPIRED,
    /**
     * Land was captured by their enemy during war.
     */
    WAR_CAPTURED,
    /**
     * A temporary camp has expired.
     */
    CAMP_EXPIRED,
    /**
     * A land with no claims was automatically deleted.
     * Servers can disable this in config.
     */
    NO_CLAIMS
}
