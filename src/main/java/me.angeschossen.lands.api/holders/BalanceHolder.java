package me.angeschossen.lands.api.holders;

import org.jetbrains.annotations.NotNull;

public interface BalanceHolder {

    double getBalance();

    @NotNull
    String getColorName();

    boolean setBalance(double balance);

    boolean addBalance(double add);

    String getName();

    String getWarName();

    String getBalanceDisplay();

}
