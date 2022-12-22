package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.DefaultStateFlag;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class LandFlag extends DefaultStateFlag {

    /**
     * @param plugin                  Your plugin.
     * @param name                    The name of the flag.
     * @param applyInSubAreas         Should this flag also be available in sub areas, not just the land in general?
     * @param alwaysAllowInWilderness Should this flag always be true in wilderness?
     * @param target Only admin lands or all lands.
     */
    public LandFlag(@NotNull Plugin plugin, @NotNull Target target, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
        super(plugin, target, name, applyInSubAreas, alwaysAllowInWilderness);
    }

    @Deprecated
    public LandFlag(@NotNull Plugin plugin, @NotNull String name, boolean applyInSubAreas) {
        this(plugin, Target.PLAYER, name, applyInSubAreas, false);
    }

    public LandFlag(@NotNull Plugin plugin, @NotNull String name) {
        this(plugin, Target.PLAYER, name, true, false);
    }


    @NotNull
    @Override
    public final Module getModule() {
        return Module.LAND;
    }

    @Override
    public final @NotNull String getTogglePerm() {
        return "lands.setting." + name;
    }
}
