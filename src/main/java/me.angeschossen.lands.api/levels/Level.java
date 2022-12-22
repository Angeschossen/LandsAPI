package me.angeschossen.lands.api.levels;

import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface Level extends ExpressionEntity {
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
