package me.angeschossen.lands.api.player.claiming;

public enum ClaimResult {
    /**
     * Claiming was successful.
     */
    SUCCESS(false),
    /**
     * Claiming failed completely.
     */
    FAILED(true),
    /**
     * Claiming failed partly, but the minor failure can be ignored.
     * This happens if for example not all chunks of an selection could be claimed.
     */
    IGNOREABLE(false),
    /**
     * For example, if the selection is invalid or not complete.
     */
    INVALID(true);

    public final boolean shouldStop;

    ClaimResult(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }
}
