package me.angeschossen.lands.api.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface PlayerUtils {

    @NotNull String getName(@NotNull UUID playerUID);
}
