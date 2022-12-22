package me.angeschossen.lands.api.levels.attribute.impl;

import me.angeschossen.lands.api.levels.attribute.LevelAttribute;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class ChunksAttribute extends LevelAttribute {
    private final int value;

    public ChunksAttribute(@NotNull String name, @NotNull String description, int value) {
        super(name, description.replace("{value}", (value >= 0 ? ChatColor.GREEN + "+ " : ChatColor.RED + "- ") + Math.abs(value)));

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean shouldApply(@NotNull MemberHolder memberHolder) {
        return true;
    }
}
