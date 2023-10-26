package org.example;

public class TotalTicketsSpecialDeal implements Discount {
    private int minTotalTickets;
    private int discountPercentage;

    public TotalTicketsSpecialDeal(int minTotalTickets, int discountPercentage) {
        this.minTotalTickets = minTotalTickets;
        this.discountPercentage = discountPercentage;
    }

    public int getMinTotalTickets() {
        return minTotalTickets;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setMinTotalTickets(int minTotalTickets) {
        this.minTotalTickets = minTotalTickets;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double price, int totalTickets) {
        if (totalTickets >= minTotalTickets) {
            return price * (100 - discountPercentage) / 100;
        }
        return price;
    }

    public String toString() {
        return "Buy " + minTotalTickets + " tickets and get " + discountPercentage + "% off";
    }
}