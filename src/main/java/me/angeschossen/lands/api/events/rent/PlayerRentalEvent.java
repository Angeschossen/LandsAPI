package me.angeschossen.lands.api.events.rent;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.events.player.area.PlayerAreaEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.rental.RentalOffer;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a player rents or buys an area or complete land.
 * Whole lands can only be sold and not rented.
 */
public class PlayerRentalEvent extends RentalEvent {

    /**
     * Create insteace.
     * @param area the area to be rented or sold
     * @param landPlayer the player that rents or purchases the area or land. Whole lands can only be sold.
     */
    public PlayerRentalEvent(@NotNull Area area, @NotNull LandPlayer landPlayer) {
        super(area, landPlayer);
    }
}
