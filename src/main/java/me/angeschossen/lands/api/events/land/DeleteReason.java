package me.angeschossen.lands.api.events.land;

public enum DeleteReason {
    DEFAULT,
    UPKEEP,
    ADMIN,
    INACTIVITY,
    @Deprecated EXPIRED,
    WAR_CAPTURED,
    CAMP_EXPIRED,
    NO_CLAIMS
}
