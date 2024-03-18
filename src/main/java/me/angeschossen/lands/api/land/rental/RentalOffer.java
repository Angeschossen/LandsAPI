package me.angeschossen.lands.api.land.rental;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.block.LandBlock;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface RentalOffer {
    @Nullable LandBlock getBlock();

    @NotNull Area getArea();

    double getCost();

    long getSize();

    @NotNull
    RentalType getType();

    void sendInfo(@NotNull LandPlayer player);

    @NotNull
    List<String> getHologramLines();
}
