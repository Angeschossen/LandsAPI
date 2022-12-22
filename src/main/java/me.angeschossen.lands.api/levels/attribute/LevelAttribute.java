package me.angeschossen.lands.api.levels.attribute;

import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class LevelAttribute {
    protected final String description;
    protected final String name;

    public LevelAttribute(@NotNull String name, @NotNull String description) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);

        this.name = StringUtils.toLowerCase(name.replace(" ", ""));
        this.description = APIHandler.getInstance().getStringUtils().colorize(description);
    }

    public abstract boolean shouldApply(@NotNull MemberHolder memberHolder);

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getAttributeDisplay() {
        return description;
    }
}
