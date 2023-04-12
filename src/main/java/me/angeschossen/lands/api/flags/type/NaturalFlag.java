package me.angeschossen.lands.api.flags.type;

import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.flags.enums.FlagTarget;
import me.angeschossen.lands.api.flags.type.parent.DefaultStateFlag;
import me.angeschossen.lands.api.flags.type.parent.Flag;
import me.angeschossen.lands.api.handler.APIHandler;
import org.jetbrains.annotations.NotNull;

public interface NaturalFlag extends Flag<NaturalFlag>, DefaultStateFlag<NaturalFlag> {

    @NotNull
    static NaturalFlag of(@NotNull LandsIntegration landsIntegration, @NotNull FlagTarget flagTarget, @NotNull String name) {
       return APIHandler.getFlagFactory().naturalFlagOf(landsIntegration, flagTarget, name);
    }
}
