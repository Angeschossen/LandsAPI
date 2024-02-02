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
     * This method is being called each time a flag is being check while no other role from Lands belongs to the player.
     * That means that if the player has a role set in the area, this method won't be called. This is only called for
     * players that don't have any role. Results of this method may be cached.
     *
     * @param area         the area
     * @param playerUUID   UUID of the player
     * @param onlinePlayer null, if the player is offline
     * @return should return false, if this role shouldn't be applied to this player
     */
    public abstract boolean applies(@NotNull Area area, @NotNull UUID playerUUID, @Nullable LandPlayer onlinePlayer);

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
