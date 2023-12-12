package me.angeschossen.lands.api.land.block;

import com.github.angeschossen.pluginframework.api.blockutil.impl.BlockPosition;
import org.jetbrains.annotations.NotNull;

/**
 * Special blocks that can be placed inside a land.
 */
public interface LandBlock {
    /**
     * Get the unique Id of this block.
     *
     * @return unique id
     */
    @NotNull String getId();

    /**
     * Get the center of the structure.
     *
     * @return center of the structure
     */
    @NotNull
    BlockPosition getCenter();

    /**
     * Check if the structure contains a block coordinate.
     *
     * @param x Block x
     * @param y Block y
     * @param z Block z
     * @return true, if the block belongs to the structure
     */
    boolean containsBlock(int x, int y, int z);

    /**
     * Get the type of this block.
     *
     * @return type of the block
     */
    @NotNull LandBlockType getType();
}
