package me.angeschossen.lands.api.role.system;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

public abstract class SystemFlagStates {
    protected final @NotNull LandsIntegration integration;
    protected final @NotNull Set<RoleFlag> flags;

    public SystemFlagStates(@NotNull LandsIntegration landsIntegration, @NotNull Set<RoleFlag> flags) {
        this.integration = Checks.requireNonNull(landsIntegration, "integration");
        this.flags = Checks.requireNonNull(flags, "flags");
    }

    @NotNull
    public final LandsIntegration getIntegration() {
        return integration;
    }

    /**
     * Check if these flag states also contain a specific role flag.
     *
     * @param flag the flag to check
     * @return true, if this flag is included
     */
    public final boolean hasFlag(@NotNull RoleFlag flag) {
        return flags.contains(Checks.requireNonNull(flag, "flag"));
    }
}
