package me.angeschossen.lands.api.flags.type;

import me.angeschossen.lands.api.flags.enums.FlagTarget;
import me.angeschossen.lands.api.handler.APIHandler;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface NaturalFlag extends Flag<NaturalFlag>, DefaultStateFlag<NaturalFlag> {

    @NotNull
    static NaturalFlag of(@NotNull Plugin plugin, @NotNull FlagTarget flagTarget, @NotNull String name) {
       return APIHandler.getFlagFactory().naturalFlagOf(plugin, flagTarget, name);
    }
}
