package me.angeschossen.lands.api.land;

import org.jetbrains.annotations.NotNull;

public interface LandArea extends Area {

    boolean setName(@NotNull String name);

    boolean isSetup();
}
