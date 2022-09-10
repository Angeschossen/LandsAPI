package me.angeschossen.lands.api.events.nation;

import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerNullableEvent;
import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class NationEditEvent extends LandsPlayerNullableEvent {


    protected final @NotNull Nation nation;

    public NationEditEvent(@NotNull Nation nation, @Nullable LandPlayer landPlayer) {
        super(landPlayer);

        this.nation = nation;
    }

    public NationEditEvent(@NotNull Nation nation, @Nullable UUID landPlayer) {
        super(landPlayer);

        this.nation = nation;
    }

    @NotNull
    public Nation getNation() {
        return nation;
    }
}
