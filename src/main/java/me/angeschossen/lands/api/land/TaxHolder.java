package me.angeschossen.lands.api.land;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface TaxHolder {

    void setTax(double tax);

    double addTax(double value);

    double getTax();

    double getEstimatedTaxRevenue(@Nullable UUID playerUID);

    String getName();
}
