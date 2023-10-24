package org.example;

public class AttractionTicket {
    private final Attraction attraction;
    private final float ticketPrice; // ticket price after applying discounts (if any)

    public AttractionTicket(Attraction attraction, float ticketPrice) {
        this.attraction = attraction;
        this.ticketPrice = ticketPrice;
        attraction.setNumberOfTicketedVisitorsCount(attraction.getNumberOfTicketedVisitorsCount() + 1);
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }
}
