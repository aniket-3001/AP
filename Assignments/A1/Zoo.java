package org.example;
import java.util.ArrayList;

public class Zoo {
    private final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    private final ArrayList<Animal> animals = new ArrayList<Animal>();
    private final ArrayList<AgeBasedDiscount> discounts = new ArrayList<AgeBasedDiscount>();
    private final ArrayList<TotalTicketsSpecialDeal> specialDeals = new ArrayList<TotalTicketsSpecialDeal>();
    private final ArrayList<Visitor> visitors = new ArrayList<Visitor>();
    private int visitorCount;
    private float revenue;

    public Zoo() {
        visitorCount = 0;
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

    public float getRevenue() {
        return revenue;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }
}
