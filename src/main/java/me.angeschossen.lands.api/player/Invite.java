package me.angeschossen.lands.api.player;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.utils.TrustResult;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Invite {

    boolean isWholeLand();

    /**
     * Get UUID of sender
     *
     * @return UUID of sender
     */
    @NotNull
    UUID getSender();

    /**
     * Get UUID of receiver
     *
     * @return UUID of receiver
     */
    @NotNull
    UUID getReceiver();

    /**
     * Get sent date
     *
     * @return Date
     */
    long getTime();

    /**
     * Accept invite
     *
     * @return Will return false if invite fails because of max members permission (lands.members.<number>).
     */
    TrustResult accept(Player player);

    /**
     * Deny invite
     */
    void deny();

    /**
     * Get land
     *
     * @return Land
     */
    @NotNull
    Land getLand();
}
