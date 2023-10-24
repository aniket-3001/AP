package org.example;
import java.util.ArrayList;

public class Visitor implements Membership {
    private final String name;
    private final int age;
    private final int phoneNumber;
    private float balance;
    private final String email;
    private String password;
    private String membership;
    private final Zoo zoo;
    private final ArrayList<AttractionTicket> attractionTicketList = new ArrayList<>();
    private String feedback;

    public Visitor(String name, int age, int phoneNumber, float balance, String email, String password, Zoo zoo) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.zoo = zoo;
        this.membership = ""; // by default, all visitors are not members
        this.balance = 100; // by default, all visitors have a balance of 100
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public float getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<AttractionTicket> getAttractionTicketList() {
        return attractionTicketList;
    }

    public Zoo getZoo() {
        return zoo;
    }

    @Override
    public boolean isBasic() {
        return membership.equals("Basic");
    }

    @Override
    public boolean isPremium() {
        return membership.equals("Premium");
    }

    public String getFeedback() {
        return feedback;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void viewAttractions() {
        ArrayList<Attraction> attractions = zoo.getAttractions();

        // the user only needs to know about the attractions that have been scheduled by the admin, hence valid
        for (Attraction attraction : attractions) {
            if (attraction.getIsOpen()) {
                System.out.println(attraction);
                System.out.println();
            }
        }
    }

    public void viewAnimals() {
        ArrayList<Animal> animals = zoo.getAnimals();

        for (Animal animal : animals) {
            System.out.println(animal);
            System.out.println();
        }
    }

    public void buyMembership(String membership, String discountCode) {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();
        boolean discountExists = false;
        Discount discountObj = null; // polymorphism

        for (AgeBasedDiscount discount : discounts) {
            if (discount.getDiscountCode().equals(discountCode)) {
                discountExists = true;
                discountObj = discount; // polymorphism

                // check if the user is eligible for the discount
                if (discount.getLowerAgeLimit() > getAge() || getAge() > discount.getUpperAgeLimit()) {
                    System.out.println("You are not eligible for this discount.");
                }

                break;
            }
        }

        if (!discountExists) {
            System.out.println("No such discount exists.");
            return;
        }

        if (membership.equals("Basic")) {
            setMembership("Basic");
            setBalance(getBalance() - discountObj.applyDiscount(25, age));
            zoo.setRevenue(zoo.getRevenue() + discountObj.applyDiscount(25, age));
        } else if (membership.equals("Premium")) {
            setMembership("Premium");
            setBalance(getBalance() - discountObj.applyDiscount(50, age));
            zoo.setRevenue(zoo.getRevenue() + discountObj.applyDiscount(50, age));
        }
    }

    public void buyTickets(String attractionName, int quantity, String discountCode) {
        if (isPremium()) {
            // premium members do not need to buy tickets
            System.out.println("You are a premium member. You do not need to buy tickets.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        ArrayList<Attraction> attractions = zoo.getAttractions();
        Attraction attraction = null;

        for (Attraction a : attractions) {
            if (a.getName().equals(attractionName)) {
                attraction = a;
                break;
            }
        }

        if (attraction == null) {
            System.out.println("No such attraction exists.");
            return;
        }

        if (attraction.getIsOpen()) {
            if (isBasic()) {
                // basic members need to pay full price of a ticket, unless they have
                // an age discount, or a deal is applicable

                // iterate over the discounts array and search whether the discount code given by the user exists
                ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();

                boolean discountExists = false;
                Discount discountObj = null; // polymorphism

                for (AgeBasedDiscount discount : discounts) {
                    if (discount.getDiscountCode().equals(discountCode)) {
                        discountExists = true;
                        discountObj = discount; // polymorphism

                        // check if the user is eligible for the discount
                        if (discount.getLowerAgeLimit() > getAge() || getAge() > discount.getUpperAgeLimit()) {
                            System.out.println("You are not eligible for this discount.");
                        }

                        break;
                    }
                }

                if (!discountExists) {
                    System.out.println("No such discount exists.");
                    return;
                }

                float sumToBeDeducted = 0;
                ArrayList<AttractionTicket> tickets = getAttractionTicketList();

                for (AttractionTicket ticket : tickets) {
                    sumToBeDeducted += ticket.getTicketPrice();
                }

                setBalance(getBalance() + sumToBeDeducted);
                sumToBeDeducted = 0;

                if (tickets.size() + quantity == 2) {
                    for (AttractionTicket ticket : tickets) {
                        sumToBeDeducted += ticket.getTicketPrice() * 0.9;
                    }

                    sumToBeDeducted += discountObj.applyDiscount(attraction.getFixedTicketPrice(), age) * 0.9 * quantity;
                }
                else if (tickets.size() + quantity >= 3) {
                    for (AttractionTicket ticket : tickets) {
                        sumToBeDeducted += ticket.getTicketPrice() * 0.85;
                    }

                    sumToBeDeducted += discountObj.applyDiscount(attraction.getFixedTicketPrice(), age) * 0.85 * quantity;
                }
                else {
                    sumToBeDeducted += discountObj.applyDiscount(attraction.getFixedTicketPrice(), age);
                }

                setBalance(getBalance() - sumToBeDeducted);

                for (int i = 0; i < quantity; i++) {
                    AttractionTicket ticket = new AttractionTicket(attraction, discountObj.applyDiscount(attraction.getFixedTicketPrice(), age));
                    tickets.add(ticket);
                }
            }
            else {
                System.out.println("You must be a member to buy tickets. Kindly buy a membership before trying to purchase any tickets");
            }
        } else {
            System.out.println("Invalid attraction.");
        }
    }

    public void viewDiscounts() {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();

        for (AgeBasedDiscount discount : discounts) {
            System.out.println(discount);
            System.out.println();
        }
    }

    public void viewDeals() {
        ArrayList<TotalTicketsSpecialDeal> deals = zoo.getSpecialDeals();

        for (TotalTicketsSpecialDeal deal : deals) {
            System.out.println(deal);
            System.out.println();
        }
    }

    public void visitAnimal(String name, String action) {
        ArrayList<Animal> animals = zoo.getAnimals();

        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                if (action.equals("feed")) {
                    animal.makeNoise();
                }
                else if (action.equals("read")) {
                    System.out.println(animal.getDescription());
                }
                else {
                    System.out.println("Invalid action.");
                }

                return;
            }
        }

        System.out.println("No such animal exists.");
    }

    public void visitAttraction(String name) {
        ArrayList<AttractionTicket> attractionTickets = getAttractionTicketList();

        for (AttractionTicket ticket : attractionTickets) {
            if (ticket.getAttraction().getName().equals(name) && ticket.getAttraction().getIsOpen()) {
                System.out.println("Welcome to the attraction " + name + " !");

                // remove the ticket from the list of tickets
                attractionTickets.remove(ticket);

                return;
            }
        }
    }
}
