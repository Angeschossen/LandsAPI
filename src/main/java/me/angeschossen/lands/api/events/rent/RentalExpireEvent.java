package me.angeschossen.lands.api.events.rent;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.events.player.area.PlayerAreaEvent;
import me.angeschossen.lands.api.land.Area;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RentalExpireEvent extends RentalEvent {
    public RentalExpireEvent(@NotNull Area area) {
        super(Checks.requireNonNull(area, "area"), Objects.requireNonNull(area.getTenant(), "can only call this event for rented areas"));
    }
}
