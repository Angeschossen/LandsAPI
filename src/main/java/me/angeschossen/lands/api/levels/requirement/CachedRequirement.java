package me.angeschossen.lands.api.levels.requirement;

import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Used for requirements, for which an update needs to be triggered.
 * The results of these requirements are cached, to prevent running expensive tasks over and over again.
 * It is the responsibility of the plugin, that provides the requirement, to update it when needed.
 */
public abstract class CachedRequirement extends Requirement {

    public CachedRequirement(@NotNull Plugin plugin, @NotNull String name, @NotNull String title, @NotNull List<String> description, float required, @NotNull String requiredDisplay) {
        super(plugin, name, title, description, required, requiredDisplay);
    }

    /**
     * Calculate the current progress. Called whenever the requirement progress is fetched, but not cached yet.
     * @param memberHolder the land or nation
     * @return the calculated progress
     */
    public abstract float retrieveValue(@NotNull MemberHolder memberHolder);

    /**
     * Get the progress value. If the progress isn't cached, this will call {@link #retrieveValue(MemberHolder)}.
     * @param memberHolder the land or nation
     * @return The cached or newly calculated progress. Example: 2 placed hoppers
     */
    @Override
    public final float getValue(@NotNull MemberHolder memberHolder) {
        if (!memberHolder.isRequirementCached(name)) {
            float val = retrieveValue(memberHolder);
            memberHolder.updateRequirementCache(name, val);
            return val;
        } else {
            return memberHolder.getCachedRequirement(name);
        }
    }
}
