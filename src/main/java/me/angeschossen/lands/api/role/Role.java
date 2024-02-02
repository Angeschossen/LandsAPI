package me.angeschossen.lands.api.role;

import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;
import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.flags.type.RoleFlag;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.role.enums.RoleType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public interface Role extends ExpressionEntity {

    /**
     * Get the icon of this role.
     *
     * @return Icon
     */
    @NotNull
    ItemStack getIcon();

    /**
     * Set a new icon for this role.
     * This supports NBT data and custom heads.
     *
     * @param icon The icon to set
     */
    void setIcon(@NotNull ItemStack icon);

    /**
     * Get the role type.
     *
     * @return Role type
     */
    @NotNull
    RoleType getType();

    /**
     * Get the name of this role.
     *
     * @return Name without color. To get the name with color, use {@link #getColorName()} instead.
     */
    @NotNull
    String getName();

    /**
     * Set a new name for this role.
     *
     * @param name The new name. Names can include colors codes
     * @throws IllegalArgumentException If a role with this name already exists
     */
    void setName(@NotNull String name) throws IllegalArgumentException;

    /**
     * Returns the name of the role, including its color codes.
     *
     * @return Name with color
     */
    @NotNull
    String getColorName();

    /**
     * Toggle a flag for this role.
     *
     * @param flag The flag
     * @return The new state of this flag
     */
    boolean toggleFlag(@NotNull RoleFlag flag);

    /**
     * Check if a flag is set for this role.
     *
     * @param flag The flag
     * @return true, if the flag is set
     */
    boolean hasFlag(@NotNull RoleFlag flag);

    /**
     * Get the hierarchy / priority of a role.
     *
     * @return A higher priority means that one role is above another in the hierarchy. Minimum value is 0
     */
    int getPriority();
}
