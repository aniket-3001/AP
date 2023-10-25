package org.example;

public class Amphibian extends Animal {
    public Amphibian(String name, String description, String category) {
        super(name, description, category);
    }

    public void makeNoise() {
        System.out.println("RIBBIT");
    }
}
