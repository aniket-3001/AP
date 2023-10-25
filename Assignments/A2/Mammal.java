package org.example;

public class Mammal extends Animal {

    public Mammal(String name, String description, String noise, String category) {
        super(name, description, noise, category);
    }

    public void makeNoise() {
        switch (getName()) {
            case "Lion", "lion", "Tiger", "tiger" -> System.out.println("ROAR");
            case "Dog", "dog" -> System.out.println("BARK");
            case "Rat", "rat" -> System.out.println("SQUEAK");
            default -> System.out.println("GROWL");
        }
    }
}
