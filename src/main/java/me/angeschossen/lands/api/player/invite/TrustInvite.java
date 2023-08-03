package me.angeschossen.lands.api.player.invite;

public interface TrustInvite extends Invite {
    /**
     * Check if the player is going to be trusted in the whole land.
     * @return true, if the player is going to be trusted in the whole land
     */
    boolean isWholeLand();
}
