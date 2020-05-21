package me.angeschossen.lands.api.land.enums;

import org.jetbrains.annotations.NotNull;

public enum SortMode {

    SIZE, BALANCE, MEMBERS;

    @NotNull
    public static SortMode getByName(String name) {
        for (SortMode sortMode : values()) {
            if (sortMode.toString().equalsIgnoreCase(name)) {
                return sortMode;
            }
        }

        return SortMode.BALANCE;
    }
}