package me.angeschossen.lands.api.events.internal.plugin;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface TargetableEvent {

    @NotNull UUID getTargetUID();

    @Deprecated
    @NotNull UUID getTargetUUID();
}
