package me.angeschossen.lands.api.flags.type.parent;

public interface DefaultStateFlag<T> extends Flag<T> {

    boolean getDefaultState();

    DefaultStateFlag<T> setDefaultState(boolean state);
}
