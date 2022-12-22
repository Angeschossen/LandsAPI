package me.angeschossen.lands.api.levels.requirement;

import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public abstract class Requirement implements me.angeschossen.lands.api.levels.Requirement {

    protected final String name, title;
    protected final List<String> description;
    protected final float required;
    protected final Plugin plugin;

    public Requirement(@NotNull Plugin plugin, @NotNull String name, @NotNull String title, @NotNull List<String> description, float required, @NotNull String requiredDisplay) {
        Objects.requireNonNull(plugin);
        Objects.requireNonNull(name);
        Objects.requireNonNull(title);
        Objects.requireNonNull(description);
        Objects.requireNonNull(requiredDisplay);

        StringUtils stringUtils = APIHandler.getInstance().getStringUtils();
        description.replaceAll(s -> stringUtils.colorize(s.replace("{req}", requiredDisplay)));

        this.plugin = plugin;
        this.name = StringUtils.toLowerCase(name);
        this.required = required;
        this.title = title.replace("{req}", requiredDisplay);
        this.description = description;
    }


    @Override
    public @NotNull Plugin getPlugin() {
        return plugin;
    }

    @Override
    public final float getRequired() {
        return required;
    }

    @Override
    @NotNull
    public String getProgressDisplay(@NotNull MemberHolder memberHolder) {
        return getValue(memberHolder) + "/" + required;
    }

    @Override
    public final float getProgress(@NotNull MemberHolder memberHolder) {
        return (getValue(memberHolder) / required) * 100;
    }

    @Override
    public boolean matches(@NotNull MemberHolder memberHolder) {
        return getValue(memberHolder) >= required;
    }

    @Override
    public @NotNull List<String> getDescription() {
        return description;
    }

    @Override
    @NotNull
    public final String getName() {
        return name;
    }

    @Override
    public @NotNull String getTitle() {
        return title;
    }
}
