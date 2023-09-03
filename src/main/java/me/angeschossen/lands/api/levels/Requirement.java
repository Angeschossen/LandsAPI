package me.angeschossen.lands.api.levels;

import me.angeschossen.lands.api.levels.requirement.CachedRequirement;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Requirements define which requirements a land or nation needs to fullfil in order to progress to the next level.
 * Used for requirements that are calculated each time, a plugin requests its progress.
 * There is an implementation ({@link CachedRequirement}) of this class that prevents to recalculation at each request.
 */
public interface Requirement {
    /**
     * Get the unique name of this requirement. For display name, use {@link #getTitle()} instead.
     * @return unique name
     */
    @NotNull
    String getName();

    /**
     * Get the title of this requirement.
     * @return might include parsed color
     */
    @NotNull
    String getTitle();

    /**
     * Get the progress value.
     * @param memberHolder land or nation
     * @return example: 2 placed hoppers
     */
    float getValue(@NotNull MemberHolder memberHolder);

    /**
     * Get the progress percentage.
     * @param memberHolder land or nation
     * @return example: 50 because 2/4 required hoppers placed
     */
    float getProgress(@NotNull MemberHolder memberHolder);

    /**
     * Get the description of this requirement.
     * @return used for menus
     */
    @NotNull
    List<String> getDescription();

    /**
     * Get the required value.
     * @return example: 4 hoppers placed
     */
    float getRequired();

    /**
     * Used for menus to display the requirement progress.
     * @param memberHolder land or nation
     * @return displays the progress
     */
    @NotNull String getProgressDisplay(@NotNull MemberHolder memberHolder);

    /**
     * Get the plugin that provides this requirement.
     * @return plugin that provides this requirement
     */
    @NotNull Plugin getPlugin();

    /**
     * Check if this land or nation already fullfills this requirement.
     * @param memberHolder land or nation
     * @return true, if the land or nation already fullfills this requirement
     */
    boolean matches(@NotNull MemberHolder memberHolder);
}
