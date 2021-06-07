package me.angeschossen.lands.api.holders;

public interface BalanceHolder {

    double getBalance();

    boolean setBalance(double balance);

    boolean addBalance(double add);

    String getName();

    String getWarName();

    String getBalanceDisplay();

}
