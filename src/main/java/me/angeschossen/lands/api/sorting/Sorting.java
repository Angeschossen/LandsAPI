package me.angeschossen.lands.api.sorting;

import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A sorting evaluates the place of an land or nation on the leaderboard.
 * @param <T>
 */
public abstract class Sorting<T> implements Comparator<T> {

    protected final String id;
    protected final SortingContext<T> sortingContext;
    protected List<T> entries = Collections.emptyList();

    public Sorting(@NotNull SortingContext<T> sortingContext, @NotNull String id) throws IllegalStateException {
        this.id = StringUtils.toLowerCase(id);
        this.sortingContext = sortingContext;
    }

    @Nullable
    public final T get(int place) {
        if (place <= 0) {
            throw new IllegalArgumentException("Place can't be smaller than 1.");
        }

        place -= 1;
        return entries.size() <= place ? null : entries.get(place);
    }

    @NotNull
    public final List<T> get() {
        return entries;
    }

    @NotNull
    @Deprecated
    public abstract String getDisplayName();

    public final String getId() {
        return id;
    }

    @NotNull
    public abstract String getEmoji();

    public final int getPlace(T t) {
        return entries.indexOf(t) + 1;
    }

    @Nullable
    public final String handleParseHologramLine(int place) {
        T t = get(place);
        return t == null ? null : parseHologramLine(place, t);
    }

    @NotNull
    public final String[][] handleParseMenuItem(int place) {
        T t = get(place);
        if (t == null) {
            return new String[0][0];
        }

        String[][] s = getGUIPlaceholders(place, t);
        if (s.length < 2 || s[0].length != s[1].length) {
            throw new IllegalStateException("Placeholder and value array must be of the same length.");
        }

        return s;
    }

    public abstract String[] getPlaceholders();

    @NotNull
    public final String[] handleParseSignLines(int place) {
        T t = get(place);
        return t == null ? new String[0] : parseSignLines(++place, t);
    }

    public final void sort() {
        final List<T> list = sortingContext.getTargets();
        this.entries = list.stream().sorted(this).collect(Collectors.toList());
    }

    @NotNull
    protected abstract String[][] getGUIPlaceholders(int place, T t);

    public abstract @NotNull String getDisplayName(@Nullable LandPlayer landPlayer);

    @NotNull
    protected abstract String parseHologramLine(int place, T t);

    @NotNull
    protected abstract String[] parseSignLines(int place, T t);
}
