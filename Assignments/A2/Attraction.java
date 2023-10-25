package org.example;

public class AttractionTicket {
    private final Attraction attraction;
    private final double ticketPrice; // ticket price after applying discounts (if any)

    public AttractionTicket(Attraction attraction, double ticketPrice) {
        this.attraction = attraction;
        this.ticketPrice = ticketPrice;
        attraction.setNumberOfTicketedVisitorsCount(attraction.getNumberOfTicketedVisitorsCount() + 1);
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
