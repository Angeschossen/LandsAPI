package me.angeschossen.lands.api.war.storage;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.war.War;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * Can be used in combination with {@link LandsIntegration#setWarHandler(WarHandler)} to provided custom war functionality.
 */
public interface WarHandler {

    /**
     * Get all wars from the database. This is called sync at plugin startup to ensure all data is ready before players join,
     * but is never called after the server started.
     *
     * @return all active wars
     */
    @NotNull
    Collection<? extends War> getAllWarsFromDatabase();

    /**
     * Delete a war from your database.
     * @param war the war to delete
     * @return async completeable future
     */
    @NotNull
    CompletableFuture<Void> deleteWarFromDatabase(@NotNull War war);

    /**
     * Create a new war object from the provided native war object.
     *
     * @param war native war object
     * @return your new war instance with custom functionality
     */
    @NotNull
    War createInstance(@NotNull War war);

    /**
     * The instance of your integration.
     *
     * @return instance of your integration
     */
    @NotNull
    LandsIntegration getIntegration();
}
