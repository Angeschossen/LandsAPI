package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.DefaultStateFlag;
import me.angeschossen.lands.api.flags.Flag;
import me.angeschossen.lands.api.flags.enums.FlagModule;
import me.angeschossen.lands.api.flags.type.Flags;
import me.angeschossen.lands.api.flags.type.NaturalFlag;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Deprecated
public class LandFlag extends DefaultStateFlag<NaturalFlag> implements NaturalFlag {

    @Override
    protected LandFlag self() {
        return this;
    }

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

    public static LandFlag of(String name) {
        me.angeschossen.lands.api.flags.type.NaturalFlag flag = Objects.requireNonNull((me.angeschossen.lands.api.flags.type.NaturalFlag) Flags.get(name), "legacy flag");
        return new LandFlag(flag.getPlugin(), Flag.Target.valueOf(flag.getTarget().toString()), flag.getName(), flag.isApplyInSubareas(), flag.isAlwaysAllowInWilderness());
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
    public final FlagModule getModule() {
        return FlagModule.LAND;
    }

    @Override
    public final @NotNull String getTogglePerm() {
        return "lands.setting." + name;
    }

    @Override
    public @NotNull String getTogglePermission() {
        return getTogglePerm();
    }
}
