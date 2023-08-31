package me.angeschossen.lands.api.land.enums;

/**
 * Use {@link me.angeschossen.lands.api.sorting.Sorting} instead.
 */
@Deprecated
public enum SortMode {

    CHUNKS("chunks"), BALANCE("balance"), MEMBERS("members"), LEVEL("level");

    public final String name;
    public boolean enabled = true;

    SortMode(String name) {
        this.name = name;
    }
}