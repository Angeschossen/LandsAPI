package me.angeschossen.lands.api.levels.attribute.impl;

import me.angeschossen.lands.api.levels.attribute.LevelAttribute;
import org.jetbrains.annotations.NotNull;

public class EffectsAmountAttribute extends LevelAttribute {

    private final int amount;

    public EffectsAmountAttribute(@NotNull String name, @NotNull String description, int amount) {
        super(name, description);

        this.amount = amount;
    }

    public int getValue() {
        return amount;
    }
}
