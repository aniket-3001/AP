package org.example;
import java.util.ArrayList;

public class Visitor {
    private final String name;
    private final int age;
    private final String phoneNumber;
    private double balance;
    private final String email;
    private final String password;
    private String membership;
    private final Zoo zoo;
    private final ArrayList<AttractionTicket> attractionTicketList = new ArrayList<>();
    private String feedback;

    public Visitor(String name, int age, String phoneNumber, double balance, String email, String password, Zoo zoo) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.zoo = zoo;
        this.membership = ""; // by default, all visitors are not members
        this.balance = balance; // by default, all visitors have a balance of 100
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
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

    public boolean isBasic() {
        return membership.equals("Basic") || membership.equals("basic");
    }

    public boolean isPremium() {
        return membership.equals("Premium") || membership.equals("premium");
    }

    public String getFeedback() {
        return feedback;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        Discount discountObj = null;

        for (AgeBasedDiscount discount : discounts) {
            if (discount.getDiscountCode().equals(discountCode)) {
                discountExists = true;
                discountObj = discount; // polymorphism

                break;
            }
        }

        if (!discountExists) {
            System.out.println("No such discount exists.");
            return;
        }

        if (membership.equals("Basic") || membership.equals("basic")) {
            if ((getBalance() - discountObj.applyDiscount(25, age)) < 0) {
                System.out.println("Insufficient balance.");
                return;
            }

            setBalance(getBalance() - discountObj.applyDiscount(25, age));
            setMembership("Basic");
            zoo.setRevenue(zoo.getRevenue() + discountObj.applyDiscount(25, age));
            System.out.println("Congratulations! You are now a basic member.");
        } else if (membership.equals("Premium") || membership.equals("premium")) {
            if ((getBalance() - discountObj.applyDiscount(50, age)) < 0) {
                System.out.println("Insufficient balance.");
                return;
            }

            setBalance(getBalance() - discountObj.applyDiscount(50, age));
            setMembership("Premium");
            zoo.setRevenue(zoo.getRevenue() + discountObj.applyDiscount(50, age));
            System.out.println("Congratulations! You are now a premium member.");
        }
        else {
            System.out.println("Invalid membership type.");
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

                        break;
                    }
                }

                if (!discountExists) {
                    System.out.println("No such discount exists.");
                    return;
                }

                double sumToBeDeducted = 0;
                ArrayList<AttractionTicket> tickets = getAttractionTicketList();

                for (AttractionTicket ticket : tickets) {
                    sumToBeDeducted += ticket.getTicketPrice();
                }

                setBalance(getBalance() + sumToBeDeducted);
                zoo.setRevenue(zoo.getRevenue() - sumToBeDeducted);

                double temp = sumToBeDeducted;
                sumToBeDeducted = 0;

                int totalTickets = tickets.size() + quantity;
                ArrayList<TotalTicketsSpecialDeal> deals = zoo.getSpecialDeals();

                Discount deal = null;
                int max = 0;

                for (TotalTicketsSpecialDeal specialDeal : deals) {
                    if (totalTickets <= specialDeal.getMinTotalTickets() && specialDeal.getMinTotalTickets() > max) {
                        max = specialDeal.getMinTotalTickets();
                        deal = specialDeal; // polymorphism
                    }
                }

                for (AttractionTicket ticket : tickets) {
                    sumToBeDeducted += ticket.getTicketPrice();
                }

                sumToBeDeducted += discountObj.applyDiscount(attraction.getFixedTicketPrice(), age) * quantity;

                if (deal != null) {
                    sumToBeDeducted = deal.applyDiscount(sumToBeDeducted, totalTickets);
                }

                if ((getBalance() - sumToBeDeducted) < 0) {
                    System.out.println("Insufficient balance.");
                    setBalance(getBalance() - temp);
                    zoo.setRevenue(zoo.getRevenue() + temp);
                    return;
                }

                setBalance(getBalance() - sumToBeDeducted);
                zoo.setRevenue(zoo.getRevenue() + sumToBeDeducted);

                for (int i = 0; i < quantity; i++) {
                    AttractionTicket ticket = new AttractionTicket(attraction, discountObj.applyDiscount(attraction.getFixedTicketPrice(), age));
                    tickets.add(ticket);
                }

                System.out.println("Congratulations! You have successfully bought " + quantity + " tickets for the attraction " + attractionName + ".");
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
            if (discount.getDiscountCode().isEmpty()) {
                continue;
            }

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

        if (isPremium()) {
            // premium members do not need to buy tickets
            System.out.println("Welcome to the attraction " + name + " !");
            return;
        }

        for (AttractionTicket ticket : attractionTickets) {
            if (ticket.getAttraction().getName().equals(name) && ticket.getAttraction().getIsOpen()) {
                System.out.println("Welcome to the attraction " + name + " !");

                // remove the ticket from the list of tickets
                attractionTickets.remove(ticket);

                return;
            }
        }

        System.out.println("You do not have a ticket for this attraction. Kindly buy one before trying to visit this attraction.");
        System.out.println();
    }
}