package me.angeschossen.lands.api.levels.attribute.impl;

import me.angeschossen.lands.api.levels.attribute.LevelAttribute;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EffectsAttribute extends LevelAttribute {

    private final List<PotionEffect> effects;

    public EffectsAttribute(@NotNull String name, @NotNull String description, List<PotionEffect> effects) {
        super(name, description);

        this.effects = effects;
    }


    public List<PotionEffect> getEffects() {
        return effects;
    }
}
