package me.angeschossen.lands.api.land;

import org.jetbrains.annotations.Nullable;

public interface TaxHolder {

    void setTax(double taxes);

    double addTax(double value);


    double getTax();

    String getName();

    String getColorName();

    double getEstimatedTaxRevenue(@Nullable Object self,boolean assumeTrusted, boolean before);
}
