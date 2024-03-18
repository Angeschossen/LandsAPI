package me.angeschossen.lands.api.events.rent;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.events.player.area.PlayerAreaEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.rental.RentalOffer;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerRentalEvent extends RentalEvent {

    public PlayerRentalEvent(@NotNull Area area, @NotNull LandPlayer landPlayer) {
        super(area, landPlayer);
    }
}
