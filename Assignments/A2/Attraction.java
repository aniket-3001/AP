package org.example;

public class Attraction {
    private final int id;
    private final String name;
    private String description;
    private double fixedTicketPrice;  // free of cost for premium members,
                                    // however, normal members need to purchase a ticket
                                    // age discounts can be applied, and the final price
                                    // would reflect in the ticket price in the ticket class
    private int ticketedVisitorsCount;  // number of visitors who have purchased a ticket for this attraction
    private boolean isOpen; // to check whether the attraction is in function, as in the attraction has been given
                        // a valid opening, closing time, and a fixed ticket price

    public Attraction(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isOpen = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getFixedTicketPrice() {
        return fixedTicketPrice;
    }

    public int getNumberOfTicketedVisitorsCount() {
        return ticketedVisitorsCount;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFixedTicketPrice(double fixedTicketPrice) {
        this.fixedTicketPrice = fixedTicketPrice;
    }

    public void setNumberOfTicketedVisitorsCount(int ticketedVisitorsCount) {
        this.ticketedVisitorsCount = ticketedVisitorsCount;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String toString() {
        String status = isOpen ? "open" : "closed";
        return "Attraction Information:" +
                "\nID: " + getId() +
                "\nName: " + name +
                "\nDescription: " + getDescription() +
                "\nStatus: " + status +
                "\nFixed Ticket Price: " + fixedTicketPrice;
    }
}
