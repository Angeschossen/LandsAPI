package me.angeschossen.lands.api.handler;

import com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration;
import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This interface is not intended for direct usage and might change at any time.
 */
public interface MessageHandler {
    @NotNull
    Messages getMessagesLocale(@Nullable LandPlayer sender);

    @NotNull
    GUIConfiguration getGUILocale(@Nullable LandPlayer sender);
}
