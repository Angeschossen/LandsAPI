package me.angeschossen.lands.api.land.rental;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.block.LandBlock;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Provides information about an rental or sell offer.
 */
public interface RentalOffer {
    /**
     * Get the offer sign or hologram.
     *
     * @return null, if the sign or hologram no longer exists.
     */
    @Nullable LandBlock getBlock();

    /**
     * Get the area that is being sold or being set for rental.
     *
     * @return If this is the default area ({@link Land#getDefaultArea()}, the whole land is being sold.
     */
    @NotNull Area getArea();

    /**
     * Get the cost of this offer.
     *
     * @return the cost to purchase or rent it
     */
    double getCost();

    /**
     * Get the size in blocks of the area or land.
     *
     * @return size in blocks
     */
    long getSize();

    /**
     * Get the type of this offer.
     *
     * @return never null
     */
    @NotNull
    RentalType getType();

    void sendInfo(@NotNull LandPlayer player);

    @NotNull
    List<String> getHologramLines();
}
