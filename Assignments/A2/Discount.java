package org.example;

public interface Discount {
    double applyDiscount(double price, int parameter);
}

// note that this interface is not to be confused with the discount given on age.
// This interface is used by both, the AgeBasedDiscount class and the TotalTicketsSpecialDeal class