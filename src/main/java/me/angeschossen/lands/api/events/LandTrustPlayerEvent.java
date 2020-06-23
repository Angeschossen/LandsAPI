package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.LandMemberEditEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class LandTrustPlayerEvent extends LandMemberEditEvent {



    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }
}
