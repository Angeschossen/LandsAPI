package me.angeschossen.lands.api.levels.attribute.impl;

import me.angeschossen.lands.api.levels.attribute.LevelAttribute;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Rewards potion effect within a nation.
 * A nation can set the effect in their nation menu.
 */
public class EffectsAttribute extends LevelAttribute {

    private final List<PotionEffect> effects;

    public EffectsAttribute(@NotNull String name, @NotNull String description, List<PotionEffect> effects) {
        super(name, description);

        this.effects = effects;
    }


    public List<PotionEffect> getEffects() {
        return effects;
    }

    @Override
    public boolean shouldApply(@NotNull MemberHolder memberHolder) {
        return memberHolder instanceof Nation;
    }
}
