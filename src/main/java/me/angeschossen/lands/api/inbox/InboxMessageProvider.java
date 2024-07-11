package me.angeschossen.lands.api.inbox;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface InboxMessageProvider {

    @Nullable
    String getRawMessage(@NotNull String key, @Nullable PlayerData landPlayer);
}
