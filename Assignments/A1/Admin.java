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
    }

    public void removeAttraction(Attraction attraction) {
        zoo.getAttractions().remove(attraction);
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
            }
        }
    }

    public void addAnimal(String name, String description, String noise, String category) {
        ArrayList<Animal> animals = zoo.getAnimals();

        // check if the animal already exists in the array
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                System.out.println("Animal already exists");
                return;
            }
        }

        if (category.equals("mammal")) {
            Mammal mammals = new Mammal(name, description, noise, category);
            animals.add(mammals);
        }
        else if (category.equals("reptile")) {
            Reptile reptiles = new Reptile(name, description, noise, category);
            animals.add(reptiles);
        }
        else if (category.equals("amphibian")) {
            Amphibian amphibians = new Amphibian(name, description, noise, category);
            animals.add(amphibians);
        }
        else {
            System.out.println("Invalid category");
        }
    }

    public void removeAnimal(String name) {
        ArrayList<Animal> animals = zoo.getAnimals();

        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animals.remove(animal);
                return;
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

    public void modifyAnimal(String name, String descriptionToBeModified) {
        ArrayList<Animal> animals = zoo.getAnimals();

        for (Animal animal1 : animals) {
            if (animal1.getName().equals(name)) {
                animal1.setDescription(descriptionToBeModified);
            }
        }
    }

    public void scheduleEvent(String eventName, boolean isOpen, float fixedTicketPrice) {
        ArrayList<Attraction> attractions = zoo.getAttractions();

        for (Attraction attraction : attractions) {
            if (attraction.getName().equals(eventName)) {
                attraction.setIsOpen(isOpen);
                attraction.setFixedTicketPrice(fixedTicketPrice);
            }
        }
    }

    public void addAgeBasedDiscount(int lowerAgeLimit, int upperAgeLimit, int discountPercentage, String category, String discountCode) {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();
        AgeBasedDiscount discount = new AgeBasedDiscount(lowerAgeLimit, upperAgeLimit, discountPercentage, category, discountCode);
        discounts.add(discount);
    }

    public void removeAgeBasedDiscount(int lowerAgeLimit, int upperAgeLimit, int discountPercentage) {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();
        discounts.removeIf(discount -> discount.getLowerAgeLimit() == lowerAgeLimit && discount.getUpperAgeLimit() == upperAgeLimit && discount.getDiscountPercentage() == discountPercentage);
    }

    public void modifyAgeBasedDiscount(int lowerAgeLimit, int upperAgeLimit, int discountPercentage, int newLowerAgeLimit, int newUpperAgeLimit, int newDiscountPercentage) {
        ArrayList<AgeBasedDiscount> discounts = zoo.getDiscounts();

        for (AgeBasedDiscount discount : discounts) {
            if (discount.getLowerAgeLimit() == lowerAgeLimit && discount.getUpperAgeLimit() == upperAgeLimit && discount.getDiscountPercentage() == discountPercentage) {
                discount.setLowerAgeLimit(newLowerAgeLimit);
                discount.setUpperAgeLimit(newUpperAgeLimit);
                discount.setDiscountPercentage(newDiscountPercentage);
            }
        }
    }

    public void addTotalTicketsSpecialDeal(int totalTickets, int discountPercentage) {
        ArrayList<TotalTicketsSpecialDeal> specialDeals = zoo.getSpecialDeals();
        TotalTicketsSpecialDeal specialDeal = new TotalTicketsSpecialDeal(totalTickets, discountPercentage);
        specialDeals.add(specialDeal);
    }

    public void removeTotalTicketsSpecialDeal(int totalTickets, int discountPercentage) {
        ArrayList<TotalTicketsSpecialDeal> specialDeals = zoo.getSpecialDeals();
        specialDeals.removeIf(specialDeal -> specialDeal.getMinTotalTickets() == totalTickets && specialDeal.getDiscountPercentage() == discountPercentage);
    }

    public void modifyTotalTicketsSpecialDeal(int totalTickets, int discountPercentage, int newTotalTickets, int newDiscountPercentage) {
        ArrayList<TotalTicketsSpecialDeal> specialDeals = zoo.getSpecialDeals();

        for (TotalTicketsSpecialDeal specialDeal : specialDeals) {
            if (specialDeal.getMinTotalTickets() == totalTickets && specialDeal.getDiscountPercentage() == discountPercentage) {
                specialDeal.setMinTotalTickets(newTotalTickets);
                specialDeal.setDiscountPercentage(newDiscountPercentage);
            }
        }
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
    }

    public void viewFeedback() {
        for (Visitor visitor : zoo.getVisitors()) {
            System.out.println(visitor.getFeedback());
            System.out.println();
        }
    }
}
