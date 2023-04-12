package me.angeschossen.lands.api.levels.attribute.impl;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.levels.attribute.LevelAttribute;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class UpkeepAttribute extends LevelAttribute {
    private final double value;

    public UpkeepAttribute(@NotNull String name, @NotNull String description, double value) {
        super(name, description.replace("{value}", (value >= 0 ? ChatColor.RED + "+ " : ChatColor.GREEN + "- ") + Math.abs(value)));

        this.value = value;
    }

    public double getValue() {
        return value;
    }


    public double modifyUpkeep(double value) {
        if (this.value == 0) {
            return value;
        }

        double result = value + ((value / 100) * this.value);
        return Math.max(0, result); // prevent minus upkeep
    }

    @Override
    public boolean shouldApply(@NotNull MemberHolder memberHolder) {
        if (memberHolder instanceof Land) {
            return ((Land) memberHolder).getNation() == null;
        } else {
            return true;
        }
    }
}
