package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.PlayerEditEvent;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerLeaveLandEvent extends PlayerEditEvent {

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }
}
