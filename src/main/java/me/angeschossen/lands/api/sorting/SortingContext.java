package me.angeschossen.lands.api.sorting;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public interface SortingContext<T> {
    void addSorting(@NotNull Sorting<T> sorting) throws IllegalStateException;

    @NotNull String getId();

    @NotNull Collection<Sorting<T>> getSortings();

    @NotNull List<T> getTargets();
}
