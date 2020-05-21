package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.PlayerAreaEvent;
import me.angeschossen.lands.api.land.LandArea;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class AreaTrustPlayerEvent extends PlayerAreaEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;


    public AreaTrustPlayerEvent(LandArea area,UUID target) {
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
