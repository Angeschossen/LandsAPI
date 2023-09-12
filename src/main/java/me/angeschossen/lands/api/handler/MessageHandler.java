package me.angeschossen.lands.api.handler;

import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

/**
 * This interface is not intended for direct usage and might change at any time.
 */
public interface MessageHandler {
    Messages getMessages(@Nullable CommandSender sender);
}
