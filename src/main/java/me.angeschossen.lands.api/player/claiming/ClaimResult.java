package me.angeschossen.lands.api.player.claiming;

public enum ClaimResult {
    SUCCESS(false),
    FAILED(true),
    IGNOREABLE(false),
    INVALID(true);

    public final boolean shouldStop;

    ClaimResult(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }
}
