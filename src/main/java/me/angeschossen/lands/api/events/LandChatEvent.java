package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;


public class LandChatEvent extends Event implements Cancellable {



    public Collection<UUID> getRecipients() {
        return null;
    }

    public Land getLand() {
        return null;
    }

    public MessageSource getSource() {
        return null;
    }

    public enum MessageSource {
        MINECRAFT, DISCORD
    }

    @NotNull
    public UUID getSenderUID() {
        return null;
    }

    @Nullable
    public Player getSender() {
        return null;
    }

    @NotNull
    public String getMessage() {
        return null;
    }


    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {

    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
