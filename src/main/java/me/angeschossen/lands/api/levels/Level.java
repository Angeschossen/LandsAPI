package me.angeschossen.lands.api.levels;

import me.angeschossen.lands.api.MemberHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface Level {
    @Nullable Level getPrevious();

    boolean matches(@NotNull MemberHolder memberHolder);

    @NotNull Collection<? extends Requirement> getRequirements();

    @Nullable Level getNext();

    void addRequirement( @NotNull Requirement requirement) throws IllegalArgumentException, IllegalStateException;
}
