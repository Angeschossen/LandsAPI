package me.angeschossen.lands.api.levels.attribute;

import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class LevelAttribute {
    protected final @NotNull String description;
    protected final @NotNull String name;

    /**
     * Level attribute reward lands or nations when reaching a level.
     * @param name Name of the attribute
     * @param description Description of the attribute
     */
    public LevelAttribute(@NotNull String name, @NotNull String description) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);

        this.name = StringUtils.toLowerCase(name.replace(" ", ""));
        this.description = APIHandler.getInstance().getStringUtils().colorize(description);
    }

    /**
     * Check if the attribute should be applied.
     * @param memberHolder Land or nation
     * @return true, if the attribute can be applied to the land or nation.
     */
    public abstract boolean shouldApply(@NotNull MemberHolder memberHolder);

    /**
     * Get the name of the attribute.
     * @return Name of the attribute
     */
    @NotNull
    public final String getName() {
        return name;
    }

    /**
     * Get the description of the attribute.
     * @return Description of the attribute
     */
    @NotNull
    public final String getAttributeDescription() {
        return description;
    }
}
