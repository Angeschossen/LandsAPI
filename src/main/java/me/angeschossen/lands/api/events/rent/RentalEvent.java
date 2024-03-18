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
import java.util.UUID;

public abstract class RentalEvent extends PlayerAreaEvent implements Cancellable {
    private boolean cancelled;

    public RentalEvent(@NotNull Area area, @NotNull UUID playerUUID) {
        super(Checks.requireNonNull(area, "area"), Checks.requireNonNull(playerUUID, "playerUUID"));
    }

    public RentalEvent(@NotNull Area area, @NotNull LandPlayer landPlayer) {
        super(Checks.requireNonNull(area, "area"), Checks.requireNonNull(landPlayer, "landPlayer"));
    }

    @Nullable
    public RentalOffer getOffer(){
        return area.getRentalOffer();
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}