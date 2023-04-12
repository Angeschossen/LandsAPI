package me.angeschossen.lands.api.levels.requirement;

import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class CachedRequirement extends Requirement {

    public CachedRequirement(@NotNull Plugin plugin, @NotNull String name, @NotNull String title, @NotNull List<String> description, float required, @NotNull String requiredDisplay) {
        super(plugin, name, title, description, required, requiredDisplay);
    }

    public abstract float retrieveValue(@NotNull MemberHolder memberHolder);

    @Override
    public final float getValue(@NotNull MemberHolder memberHolder) {
        if (!memberHolder.isRequirementCached(name)) {
            float val = retrieveValue(memberHolder);
            memberHolder.updateRequirementCache(name, val, false);
            return val;
        } else {
            return memberHolder.getCachedRequirement(name);
        }
    }
}
