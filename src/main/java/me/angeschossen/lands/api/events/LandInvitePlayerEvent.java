package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.LandMemberEditEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandInvitePlayerEvent extends LandMemberEditEvent {


    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }
}
