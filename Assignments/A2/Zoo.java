package org.example;
import java.util.ArrayList;

public class Zoo {
    private final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    private final ArrayList<Animal> animals = new ArrayList<Animal>();
    private final ArrayList<AgeBasedDiscount> discounts = new ArrayList<AgeBasedDiscount>();
    private final ArrayList<TotalTicketsSpecialDeal> specialDeals = new ArrayList<TotalTicketsSpecialDeal>();
    private final ArrayList<Visitor> visitors = new ArrayList<Visitor>();
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

    public void addVisitor(String name, int age, int phoneNumber, double balance, String email, String password) {
        Visitor visitor = new Visitor(name, age, phoneNumber, balance, email, password, this);
        visitors.add(visitor);
    }

    public Visitor findVisitor(String email, String password) {
        Visitor visitor = null;

        for (Visitor visitor1 : visitors) {
            if (visitor1.getEmail().equals(email) && visitor1.getPassword().equals(password)) {
                visitor = visitor1;
            }
        }

        return visitor;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}
