package org.example;

public class Reptile extends Animal {
    public Reptile(String name, String description, String noise, String category) {
        super(name, description, noise, category);
    }

    public void makeNoise() {
        System.out.println("HISS");
    }
}
