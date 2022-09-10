package me.angeschossen.lands.api.levels;

import me.angeschossen.lands.api.MemberHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface Level  {
    void addRequirement(@NotNull Requirement requirement) throws IllegalArgumentException, IllegalStateException;

    @NotNull
    String getName();

    @Nullable Level getNext();

    @Nullable Level getPrevious();

    int getPosition();

    float getProgress(@NotNull MemberHolder memberHolder);

    @NotNull Collection<? extends Requirement> getRequirements();

    boolean matches(@NotNull MemberHolder memberHolder);
}
