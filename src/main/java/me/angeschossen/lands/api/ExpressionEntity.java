package me.angeschossen.lands.api;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface ExpressionEntity {
    void setAffectedPlayers(@NotNull String prefix, ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder);

    void setExpressionVariables(@NotNull String prefix, @NotNull ImmutableMap.Builder<String, Object> builder, @Nullable UUID playerUID);
}
