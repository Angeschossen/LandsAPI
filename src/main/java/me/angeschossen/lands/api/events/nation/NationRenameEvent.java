package me.angeschossen.lands.api.events.nation;

import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NationRenameEvent extends Event implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private boolean cancelled = false;

    private final Nation nation;
    private final String oldName;
    private final String newName;

    public NationRenameEvent(Nation nation, String oldName, String newName) {
        this.nation = nation;
        this.oldName = oldName;
        this.newName = newName;
    }

    public Nation getNation() {
        return nation;
    }

    public String getCurrentName() {
        return oldName;
    }

    public String getNewName() {
        return newName;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
