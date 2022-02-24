package me.angeschossen.lands.api.levels.attribute;

import org.jetbrains.annotations.NotNull;

public abstract class LevelAttribute {


    public LevelAttribute(@NotNull String name, @NotNull String description) {

    }

    @NotNull
    public String getAttributeDisplay() {
        return null;
    }

    @NotNull
    public String getName() {
        return null;
    }
}
