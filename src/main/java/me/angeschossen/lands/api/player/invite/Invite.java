package me.angeschossen.lands.api.player.invite;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.utils.TrustResult;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface Invite {

    /**
     * Get the result of the acceptance of this invite.
     * @return Intent of this invite
     */
    @NotNull
    InviteIntent getIntent();

    /**
     * Get the UUID of the sender.
     *
     * @return UUID of the sender
     */
    @NotNull
    UUID getSender();

    /**
     * Get UUID of the receiver.
     *
     * @return UUID of the receiver
     */
    @NotNull
    UUID getReceiver();

    /**
     * Get sent date
     *
     * @return Date when the invite was sent
     */
    long getTime();

    /**
     * Accept this invite.
     * @param player The player that should get a response in chat about this acceptance
     * @return false, if the invite fails because of max members permission (lands.members.number).
     */
    TrustResult accept(@Nullable Player player);

    /**
     * Deny this invite.
     */
    void deny();

    /**
     * Get the land that sent the invite.
     *
     * @return Land that sent the invite
     */
    @NotNull
    Land getLand();
}
