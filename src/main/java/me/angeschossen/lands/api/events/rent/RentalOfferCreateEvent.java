package me.angeschossen.lands.api.events.rent;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.events.player.area.PlayerAreaEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.rental.RentalOffer;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class RentalOfferCreateEvent extends RentalEvent {
    private final RentalOffer rentalOffer;

    public RentalOfferCreateEvent(@NotNull Area area, @NotNull LandPlayer landPlayer, @NotNull RentalOffer rentalOffer) {
        super(area, landPlayer);

        this.rentalOffer = Checks.requireNonNull(rentalOffer, "rentalOffer");
    }

    @Override
    public @NotNull RentalOffer getOffer() {
        return rentalOffer;
    }
}
