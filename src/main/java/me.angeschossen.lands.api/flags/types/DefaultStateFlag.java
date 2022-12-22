package me.angeschossen.lands.api.flags.types;

public interface DefaultStateFlag<T> extends Flag<T> {

    boolean getDefaultState();

    DefaultStateFlag<T> setDefaultState(boolean state);
}
