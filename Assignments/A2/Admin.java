package org.example;

import java.util.ArrayList;

public class Admin {
    private final Zoo zoo;

    public Admin(Zoo zoo) {
        this.zoo = zoo;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void addAttraction(String name, String description) {
        ArrayList<Attraction> attractions = zoo.getAttractions();
        Attraction attraction = new Attraction(attractions.size() + 1, name, description);
        attractions.add(attraction);
        System.out.println("Attraction added successfully");
    }

    public void removeAttraction(String attractionName) {
        ArrayList<Attraction> attractions = zoo.getAttractions();

        for (Attraction attraction : attractions) {
            if (attraction.getName().equals(attractionName)) {
                attractions.remove(attraction);
                System.out.println("Attraction removed successfully");
                return;
            }
        }

        System.out.println("Attraction not found");
    }

    public void viewAttractions() {
        ArrayList<Attraction> attractions = zoo.getAttractions();

        for (Attraction attraction : attractions) {
            System.out.println(attraction);
            System.out.println();
        }
    }

    public void modifyAttraction(String name, String descriptionToBeModified) {
        ArrayList<Attraction> attractions = zoo.getAttractions();

        for (Attraction attraction : attractions) {
            if (attraction.getName().equals(name)) {
                attraction.setDescription(descriptionToBeModified);
                System.out.println("Attraction modified successfully");
                return;
            }
        }

        System.out.println("Attraction not found");
    }

    public void addAnimal(String name, String description, String category) {
        ArrayList<Animal> animals = zoo.getAnimals();

        // check if the animal already exists in the array
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                System.out.println("Animal already exists");
                return;
            }
        }

        switch (category) {
            case "mammal", "Mammal" -> {
                Mammal mammals = new Mammal(name, description, "mammal");
                animals.add(mammals);
                System.out.println("Animal added successfully");
            }
            case "reptile", "Reptile" -> {
                Reptile reptiles = new Reptile(name, description, "reptile");
                animals.add(reptiles);
                System.out.println("Animal added successfully");
            }
            case "amphibian", "Amphibian" -> {
                Amphibian amphibians = new Amphibian(name, description, "amphibian");
                animals.add(amphibians);
                System.out.println("Animal added successfully");
            }
            default -> System.out.println("Invalid category");
        }
    }

    public void removeAnimal(String name) {
        ArrayList<Animal> animals = zoo.getAnimals();

        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animals.remove(animal);
                System.out.println("Animal removed successfully");
                return;
            }
        }

        System.out.println("Animal not found");
    }

    public void viewAnimals() {
        ArrayList<Animal> animals = zoo.getAnimals();

        for (Animal animal : animals) { // polymorphism
            System.out.println(animal);
            System.out.println();
        }
    }

    public void modifyAnimal(String name, String descriptionToBeModified) {
        ArrayList<Animal> animals = zoo.getAnimals();

        for (Animal animal1 : animals) {
            if (animal1.getName().equals(name)) {
                animal1.setDescription(descriptionToBeModified);
            }
        }
    }

    public void scheduleEvent(String eventName, boolean isOpen, double fixedTicketPrice) {
        ArrayList<Attraction> attractions = zoo.getAttractions();

        for (Attraction attraction : attractions) {
            if (attraction.getName().equals(eventName)) {
                attraction.setIsOpen(isOpen);
                attraction.setFixedTicketPrice(fixedTicketPrice);
                System.out.println("Event scheduled successfully");
            }
        }

        System.out.println("Event not found");
    }

    public void addAgeBasedDiscount(int lowerAgeLimit, int upperAgeLimit, int discountPercentage, String category, String discountCode) {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();

        for (AgeBasedDiscount discount : discounts) {
            if (discount.getDiscountCode().equals(discountCode)) {
                System.out.println("Discount already exists");
                return;
            }
        }

        AgeBasedDiscount discount = new AgeBasedDiscount(lowerAgeLimit, upperAgeLimit, discountPercentage, category, discountCode);
        discounts.add(discount);
        System.out.println("Discount added successfully");
    }

    public void removeAgeBasedDiscount(String discountCode) {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();

        for (AgeBasedDiscount discount : discounts) {
            if (discount.getDiscountCode().equals(discountCode)) {
                discounts.remove(discount);
                System.out.println("Discount removed successfully");
                return;
            }
        }

        System.out.println("Discount not found");
    }

    public void modifyAgeBasedDiscount(String discountCode, String newDiscountCode, int newLowerAgeLimit, int newUpperAgeLimit, int newDiscountPercentage) {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();

        for (AgeBasedDiscount discount : discounts) {
            if (discount.getDiscountCode().equals(discountCode)) {
                discount.setDiscountCode(newDiscountCode);
                discount.setLowerAgeLimit(newLowerAgeLimit);
                discount.setUpperAgeLimit(newUpperAgeLimit);
                discount.setDiscountPercentage(newDiscountPercentage);
                System.out.println("Discount modified successfully");
                return;
            }
        }

        System.out.println("Discount not found");
    }

    public void addTotalTicketsSpecialDeal(int totalTickets, int discountPercentage) {
        ArrayList<TotalTicketsSpecialDeal> specialDeals = zoo.getSpecialDeals();

        for (TotalTicketsSpecialDeal specialDeal : specialDeals) {
            if (specialDeal.getMinTotalTickets() == totalTickets && specialDeal.getDiscountPercentage() == discountPercentage) {
                System.out.println("Special deal already exists");
                return;
            }
        }

        TotalTicketsSpecialDeal specialDeal = new TotalTicketsSpecialDeal(totalTickets, discountPercentage);
        specialDeals.add(specialDeal);
        System.out.println("Special deal added successfully");
    }

    public void removeTotalTicketsSpecialDeal(int totalTickets, int discountPercentage) {
        ArrayList<TotalTicketsSpecialDeal> specialDeals = zoo.getSpecialDeals();

        for (TotalTicketsSpecialDeal specialDeal : specialDeals) {
            if (specialDeal.getMinTotalTickets() == totalTickets && specialDeal.getDiscountPercentage() == discountPercentage) {
                specialDeals.remove(specialDeal);
                System.out.println("Special deal removed successfully");
                return;
            }
        }

        System.out.println("Special deal not found");
    }

    public void modifyTotalTicketsSpecialDeal(int totalTickets, int discountPercentage, int newTotalTickets, int newDiscountPercentage) {
        ArrayList<TotalTicketsSpecialDeal> specialDeals = zoo.getSpecialDeals();

        for (TotalTicketsSpecialDeal specialDeal : specialDeals) {
            if (specialDeal.getMinTotalTickets() == totalTickets && specialDeal.getDiscountPercentage() == discountPercentage) {
                specialDeal.setMinTotalTickets(newTotalTickets);
                specialDeal.setDiscountPercentage(newDiscountPercentage);
                System.out.println("Special deal modified successfully");
            }
        }

        System.out.println("Special deal not found");
    }

    public void addVisitor(String name, int age, String phoneNumber, double balance, String email, String password) {
        ArrayList<Visitor> visitors = zoo.getVisitors();

        for (Visitor visitor : visitors) {
            if (visitor.getEmail().equals(email)) {
                System.out.println("Visitor already exists");
                return;
            }
        }

        Visitor visitor = new Visitor(name, age, phoneNumber, balance, email, password, getZoo());
        visitors.add(visitor);
        System.out.println("Visitor added successfully");
    }

    public Visitor findVisitor(String email, String password) {
        Visitor visitor = null;

        for (Visitor visitor1 : zoo.getVisitors()) {
            if (visitor1.getEmail().equals(email) && visitor1.getPassword().equals(password)) {
                visitor = visitor1;
                break;
            }
        }

        return visitor;
    }

    public int getVisitorCount() {
        return zoo.getVisitorCount();
    }

    public void setVisitorCount(int visitorCount) {
        zoo.setVisitorCount(visitorCount);
    }

    public void viewVisitorStats() {
        System.out.println("Total number of visitors: " + zoo.getVisitorCount());
        System.out.println("Total revenue: " + zoo.getRevenue());

        // sort the attractions on the basis of tickets sold
        ArrayList<Attraction> attractions = zoo.getAttractions();
        attractions.sort((attraction1, attraction2) -> attraction2.getNumberOfTicketedVisitorsCount() - attraction1.getNumberOfTicketedVisitorsCount());

        System.out.println();

        System.out.println("Attractions sorted on the basis of tickets sold: ");
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getName() + ": " + attraction.getNumberOfTicketedVisitorsCount());
        }

        System.out.println();
    }

    public void viewFeedback() {
        for (Visitor visitor : zoo.getVisitors()) {
            System.out.println(visitor.getFeedback());
        }

        System.out.println();
    }
}