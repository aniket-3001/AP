package org.example;
import java.util.ArrayList;

public class Zoo {
    private final ArrayList<Attraction> attractions = new ArrayList<>();
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final ArrayList<AgeBasedDiscount> discounts = new ArrayList<>();
    private final ArrayList<TotalTicketsSpecialDeal> specialDeals = new ArrayList<>();
    private final ArrayList<Visitor> visitors = new ArrayList<>();
    private int visitorCount;
    private double revenue;

    public Zoo() {
        visitorCount = 0;
        discounts.add(new AgeBasedDiscount(0, 0, 1, "", ""));
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<AgeBasedDiscount> getDiscounts() {
        return discounts;
    }

    public ArrayList<TotalTicketsSpecialDeal> getSpecialDeals() {
        return specialDeals;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}