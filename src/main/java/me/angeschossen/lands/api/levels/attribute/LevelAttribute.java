package me.angeschossen.lands.api.levels.attribute;

import me.angeschossen.lands.api.MemberHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class LevelAttribute {
    protected final String description;
    protected final String name;

    public LevelAttribute(@NotNull String name, @NotNull String description) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);

        this.name =name;
        this.description = description;
    }

    public abstract boolean shouldApply(@NotNull MemberHolder memberHolder);

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getAttributeDisplay() {
        return description;
    }
}
