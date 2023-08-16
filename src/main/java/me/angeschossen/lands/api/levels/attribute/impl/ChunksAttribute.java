package me.angeschossen.lands.api.levels.attribute.impl;

import me.angeschossen.lands.api.levels.attribute.LevelAttribute;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

/**
 * Rewards additional claims for /lands claim.
 */
public class ChunksAttribute extends LevelAttribute {
    private final int value;

    /**
     * Create instance.
     * @param name Name of the level attribute
     * @param description Description of the attribute
     * @param value Amount of chunks to reward
     */
    public ChunksAttribute(@NotNull String name, @NotNull String description, int value) {
        super(name, description.replace("{value}", (value >= 0 ? ChatColor.GREEN + "+ " : ChatColor.RED + "- ") + Math.abs(value)));

        this.value = value;
    }

    /**
     * Get the amount of additional claims.
     * @return Additional claims
     */
    public int getValue() {
        return value;
    }

    /**
     * Check if this attribute can be applied.
     * @param memberHolder Land or nation
     * @return Always true, since it can be applied to a land or nation
     */
    @Override
    public boolean shouldApply(@NotNull MemberHolder memberHolder) {
        return true;
    }
}
