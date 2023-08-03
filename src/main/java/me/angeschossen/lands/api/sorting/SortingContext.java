package me.angeschossen.lands.api.sorting;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public interface SortingContext<T> {
    /**
     * Add a sorting to this sorting context.
     * @param sorting The sorting
     * @throws IllegalStateException If the a sorting with the same ID already exists in this context
     */
    void addSorting(@NotNull Sorting<T> sorting) throws IllegalStateException;

    /**
     * Get the identification of this context.
     * @return Identifier
     */
    @NotNull String getId();

    /**
     * Go through sorting modes. Useful for GUI etc.
     * @param mode Current mode
     * @return Next mode in list
     */
    @NotNull Sorting<T> getNext(@Nullable Sorting<T> mode);

    /**
     * Get all sortings of this context.
     * @return Sortings of this context
     */
    @NotNull Collection<Sorting<T>> getSortings();

    /**
     * Get sorting targets.
     * @return All sorting targets
     */
    @NotNull List<T> getTargets();
}
