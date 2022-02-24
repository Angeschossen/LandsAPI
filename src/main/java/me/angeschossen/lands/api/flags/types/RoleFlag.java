package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.Flag;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.role.Role;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class RoleFlag extends Flag {

    /**
     * This flag needs to be used for actions that involve players.
     *
     * @param plugin                  Your plugin.
     * @param category                There are two categories of RoleFlags:
     *                                ACTION: This should be used for physical actions, like block breaking etc.
     *                                MANAGEMENT: This should be used for administration actions, like trusting players etc.
     * @param name                    Name of the flag.
     * @param applyInSubAreas         Should this flag also be available in sub areas, not just the land in general?
     * @param alwaysAllowInWilderness Should this flag always be true in wilderness?
     * @param predicate               You can specify to which roles this flag should be applied for already existing lands. The role will be null if the target is wilderness.
     * @param target                  Specify if this flag should only be accessible to admin lands.
     */
    public RoleFlag(@NotNull Plugin plugin, @NotNull Flag.Target target, @NotNull Category category, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness, @NotNull Predicate<Role> predicate) {
        super(plugin, target, name, applyInSubAreas, alwaysAllowInWilderness);
    }

    public RoleFlag(@NotNull Plugin plugin, @NotNull Category category, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
        this(plugin, Target.PLAYER, category, name, applyInSubAreas, alwaysAllowInWilderness, role -> true);
    }

    public RoleFlag(@NotNull Plugin plugin, @NotNull Category category, @NotNull String name) {
        this(plugin, Target.PLAYER, category, name, true, false, role -> true);
    }

    public boolean isToggleableByNation() {
        return false;
    }

    public RoleFlag setToggleableByNation(boolean toggleable) {
        return this;
    }

    @NotNull
    public Predicate<Role> getPredicate() {
        return null;
    }

    @Override
    public @NotNull String getTogglePerm() {
        return null;
    }

    public void sendDenied(@NotNull LandPlayer landPlayer, @Nullable Area area) {

    }

    public void sendDeniedInWar(@NotNull LandPlayer landPlayer, @Nullable Land land) {

    }

    @NotNull
    public String getBypassPerm() {
        return null;
    }

    @NotNull
    @Override
    public Module getModule() {
        return Module.LAND;
    }

    @NotNull
    public String getBypassPermWild() {
        return null;
    }

    @NotNull
    public Category getCategory() {
        return null;
    }

    public enum Category {
        ACTION, MANAGEMENT
    }
}
