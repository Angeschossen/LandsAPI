package me.angeschossen.lands.api.role.system;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public final class SystemFlagStates {
    private final @NotNull LandsIntegration integration;
    private final @NotNull Set<RoleFlag> flags;

    public SystemFlagStates(@NotNull LandsIntegration landsIntegration, @NotNull Set<RoleFlag> flags) {
        this.integration = Checks.requireNonNull(landsIntegration, "integration");
        this.flags = Checks.requireNonNull(flags, "flags");
    }

    @NotNull
    public LandsIntegration getIntegration() {
        return integration;
    }

    /**
     * Check if these flag states also contain a specific role flag.
     *
     * @param flag the flag to check
     * @return true, if this flag is included
     */
    public boolean hasFlag(@NotNull RoleFlag flag) {
        return flags.contains(Checks.requireNonNull(flag, "flag"));
    }
}
