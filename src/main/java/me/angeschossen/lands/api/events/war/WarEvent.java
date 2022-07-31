package me.angeschossen.lands.api.events.war;

import me.angeschossen.lands.api.war.War;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

public abstract class WarEvent extends Event {

    protected final War war;

    public WarEvent(@NotNull War war) {
        this.war = war;
    }

    @NotNull
    public War getWar() {
        return war;
    }
}
