package me.angeschossen.lands.api.land;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface LandCategory {

    @NotNull List<String> getDescription();

    @NotNull String getName();
}
