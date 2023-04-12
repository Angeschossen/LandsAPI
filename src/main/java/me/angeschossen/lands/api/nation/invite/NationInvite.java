package me.angeschossen.lands.api.nation.invite;

import me.angeschossen.lands.api.exceptions.LandAlreadyInNationException;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;

public interface NationInvite {

    /**
     * Get sender nation.
     *
     * @return Sender
     */
    Nation getSender();

    /**
     * Get receiver land.
     *
     * @return Receiver
     */
    Land getReceiver();

    /**
     * Accept invite
     *
     * @return Will return false if land or nation does not exist anymore.
     * @throws LandAlreadyInNationException
     */
    boolean accept() throws LandAlreadyInNationException;

    /**
     * Deny invite - land.
     */
    void deny();

    /**
     * Revoke invite - nation.
     */
    void revoke();
}
