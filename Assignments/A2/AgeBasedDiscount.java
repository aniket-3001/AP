package org.example;

public class AgeBasedDiscount implements Discount {
    private int lowerAgeLimit;
    private int upperAgeLimit;
    private int discountPercentage;
    private final String category;
    private String discountCode;

    public AgeBasedDiscount(int lowerAgeLimit, int upperAgeLimit, int discountPercentage, String category, String discountCode) {
        this.lowerAgeLimit = lowerAgeLimit;
        this.upperAgeLimit = upperAgeLimit;
        this.discountPercentage = discountPercentage;
        this.category = category;
        this.discountCode = discountCode;
    }

    public int getLowerAgeLimit() {
        return lowerAgeLimit;
    }

    public int getUpperAgeLimit() {
        return upperAgeLimit;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public String getCategory() {
        return category;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setLowerAgeLimit(int lowerAgeLimit) {
        this.lowerAgeLimit = lowerAgeLimit;
    }

    public void setUpperAgeLimit(int upperAgeLimit) {
        this.upperAgeLimit = upperAgeLimit;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @Override
    public double applyDiscount(double ticketPrice, int visitorAge) {
        if (discountCode.isEmpty()) {
            return ticketPrice;
        }

        if (visitorAge >= lowerAgeLimit && visitorAge <= upperAgeLimit) {
            return ticketPrice - (ticketPrice * discountPercentage / 100);
        }

        return ticketPrice;
    }

    public String toString() {
        return getCategory() + " ("+ getDiscountPercentage()+"% discount) - " + getDiscountCode();
    }
}
