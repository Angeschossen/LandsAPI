package me.angeschossen.lands.api.player;

import me.angeschossen.lands.api.land.ChunkCoordinate;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface Selection {

    /**
     * Is selection complete (pos 1 and pos 2)?
     *
     * @return Will return false if one position is missing.
     */
    @NotNull
    boolean isComplete();

    /**
     * Get pos 1
     *
     * @return Location of pos 1
     */
    @Nullable
    Location getPos1();

    /**
     * Get pos 2
     *
     * @return Location of pos 2
     */
    @Nullable
    Location getPos2();

    /**
     * Set pos 1
     *
     * @param location Location
     */
    void setPos1(@Nullable Location location);

    /**
     * Set pos 2
     *
     * @param location Location
     */
    void setPos2(@Nullable Location location);

    /**
     * Is valid?
     *
     * @param sendMessage Send not valid messages to player?
     * @return Will return false if selection is not complete, positions are not in the same world
     * or the selection is too big (lands.selection.NUMBER).
     */
    @NotNull
    boolean isValid(@NotNull boolean sendMessage);

    /**
     * Get chunks in this selection.
     *
     * @return Chunks in this selection
     */
    Collection<ChunkCoordinate> getChunks();

    /**
     * Get size.
     *
     * @return Size
     */
    @NotNull
    int getSize();

    /**
     * Disable selection
     */
    void disable();
}
