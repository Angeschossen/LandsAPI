package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.PlayerAreaEvent;
import me.angeschossen.lands.api.land.LandArea;
import org.bukkit.event.Cancellable;

import java.util.UUID;

public class AreaUntrustPlayerEvent extends PlayerAreaEvent implements Cancellable {
    private boolean cancelled;

    public AreaUntrustPlayerEvent(LandArea area, UUID target) {
        super(area, target);
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
