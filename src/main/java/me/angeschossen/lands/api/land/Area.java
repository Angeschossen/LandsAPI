package me.angeschossen.lands.api.land;

import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import me.angeschossen.lands.api.flags.type.NaturalFlag;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.invite.Invite;
import me.angeschossen.lands.api.role.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public interface Area extends ExpressionEntity {

    /**
     * Add taxes for this area.
     *
     * @param tax If negative, it will remove taxes.
     * @return New tax value
     */
    double addTax(double tax);

    /**
     * Ban a player.
     *
     * @param uuid The player to be banned.
     * @return false, if was already banned
     */
    boolean banPlayer(UUID uuid);

    /**
     * Check if a player can enter this area. This depends on {@link #isBanned(UUID)} and on the land enter flag state for the player's role.
     *
     * @param landPlayer  The player which wants to enter
     * @param sendMessage If true, it will send a enter faiure message to the player, if they're not allowed to enter
     * @return false, if the player isn't allowed to enter
     */
    boolean canEnter(@NotNull LandPlayer landPlayer, boolean sendMessage);

    /**
     * Same as {@link #getName()}, but with colors codes included.
     * @return Name with color codes
     */
    @NotNull
    String getColorName();

    /**
     * Get the entry role.
     * @return New players receive this role
     */
    @NotNull
    Role getEntryRole();

    /**
     * Get invite that was sent to a specific player.
     * @param receiverUUID The receiver
     * @return null, if the player was never invited, already accepted the invite or the invite expired.
     */
    @Nullable
    Invite getInvite(@NotNull UUID receiverUUID);

    /**
     * Get the land of this area.
     * @return The land to which this area belongs
     */
    @NotNull
    Land getLand();

    /**
     * Get the name of this area. To include color codes, use {@link #getColorName()} instead.
     * @return Name of the land without color codes
     */
    @NotNull
    String getName();

    /**
     * Get the owner of this area. Might differ to {@link Land#getOwnerUID()}, if the area is sold or rented.
     * @return The current owner of this area
     */
    @NotNull
    UUID getOwnerUID();

    /**
     * Get the rolre of a player.
     * @param playerUID The player
     * @return Visitor role, if the player is untrusted
     */
    @NotNull
    Role getRole(@NotNull UUID playerUID);

    /**
     * Get a role by its name.
     * @param name Color codes are stripped for the lookup
     * @return null, if no role with this name found
     */
    @Nullable
    Role getRole(@NotNull String name);

    /**
     * Get the roles.
     *
     * @return Collection of all roles
     */
    Collection<? extends Role> getRoles();

    /**
     * Get current tax value.
     * @return Current tax
     */
    double getTax();

    /**
     * Set tax value.
     * @param tax New tax value. Can't be negative
     */
    void setTax(double tax);

    /**
     * Get all trusted players.
     * @return Collection of trusted players, including owner
     */
    @NotNull Collection<UUID> getTrustedPlayers();

    /**
     * Get the visitor role.
     * @return Players which aren't trusted have this role automatically
     */
    @NotNull
    Role getVisitorRole();

    /**
     * Check if area has a natural flag enabled.
     * @param flag The flag to check
     * @return false, if not set
     */
    boolean hasNaturalFlag(@NotNull NaturalFlag flag);

    /**
     * Check if a player has a role flag enabled through their role.
     * @param playerUUID The player
     * @param flag The flag
     * @return false, their role doesn't have this flag
     */
    boolean hasRoleFlag(@NotNull UUID playerUUID, @NotNull RoleFlag flag);

    /**
     * Use {@link #hasRoleFlag(LandPlayer, RoleFlag, Material, boolean)} instead.
     * Check if a player has a role flag set through their role.
     * @param player The player
     * @param flag The flag to check
     * @param material The blocks material. Useful for flags like {@link me.angeschossen.lands.api.flags.type.Flags#BLOCK_BREAK} etc.
     *                 This parameter is used if the land is engaged in a war and the server configured that in wars specific blocks are allowed to break etc.
     *                 For flags that don't include any blocks you can provide null here.
     * @param sendMessage If the player should get a message, if their role doesn't have this flag
     * @return false, if their role doesn't have this flag
     */
    @Deprecated
    boolean hasRoleFlag(@NotNull Player player, @NotNull RoleFlag flag, @Nullable Material material, boolean sendMessage);

    /**
     * Check if a player has a role flag set through their role.
     * @param player The player
     * @param flag The flag to check
     * @param material The blocks material. Useful for flags like {@link me.angeschossen.lands.api.flags.type.Flags#BLOCK_BREAK} etc.
     *                 This parameter is used if the land is engaged in a war and the server configured that in wars specific blocks are allowed to break etc.
     *                 For flags that don't include any blocks you can provide null here.
     * @param sendMessage If the player should get a message, if their role doesn't have this flag
     * @return false, if their role doesn't have this flag
     */
    boolean hasRoleFlag(@NotNull LandPlayer player, @NotNull RoleFlag flag, @Nullable Material material, boolean sendMessage);

    /**
     * Use {@link #hasRoleFlag(UUID, RoleFlag)} instead.
     * @param playerUUID The player
     * @param flag The flag
     * @return false, if their role doesn't have this flag
     */
    @Deprecated
    boolean hasFlag(@NotNull UUID playerUUID, @NotNull me.angeschossen.lands.api.flags.types.RoleFlag flag);

    /**
     * Use {@link #hasRoleFlag(LandPlayer, RoleFlag, Material, boolean)} instead.
     * @param player The player
     * @param flag The flag
     * @param material The blocks material. Useful for flags like {@link me.angeschossen.lands.api.flags.type.Flags#BLOCK_BREAK} etc.
     *                 This parameter is used if the land is engaged in a war and the server configured that in wars specific blocks are allowed to break etc.
     *                 For flags that don't include any blocks you can provide null here.
     * @param sendMessage If the player should get a message, if their role doesn't have this flag
     * @return false, if their role doesn't have this flag
     */
    @Deprecated
    boolean hasFlag(@NotNull Player player, @NotNull me.angeschossen.lands.api.flags.types.RoleFlag flag, @Nullable Material material, boolean sendMessage);

    /**
     * Use {@link #hasRoleFlag(LandPlayer, RoleFlag, Material, boolean)} instead.
     * @param player The player
     * @param roleFlag The flag
     * @param sendMessage If the player should get a message, if their role doesn't have this flag
     * @return false, if their role doesn't have this flag
     */
    @Deprecated
    boolean hasFlag(@NotNull Player player, @NotNull me.angeschossen.lands.api.flags.types.RoleFlag roleFlag, boolean sendMessage);

    /**
     * Check if a player is banned.
     * @param playerUID The player
     * @return false, if the player isn't banned
     */
    boolean isBanned(@NotNull UUID playerUID);

    /**
     * Check if this area is the defeault area ({@link Land#getDefaultArea()}.
     * @return true, if this area is the default area
     */
    boolean isDefault();

    /**
     * Check if a player is trusted.
     * @param playerUID The player
     * @return true, if the player is trusted
     */
    boolean isTrusted(UUID playerUID);

    /**
     * Toggle a natural flag.
     * @param flag The flag
     * @return The new flag state
     */
    boolean toggleNaturalFlag(@NotNull NaturalFlag flag);

    /**
     * Unban a player.
     * @param playerUID The player to be unbanned
     */
    void unbanPlayer(UUID playerUID);
}
