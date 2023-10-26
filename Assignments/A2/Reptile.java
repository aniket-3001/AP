package org.example;

public class Reptile extends Animal {
    public Reptile(String name, String description, String category) {
        super(name, description, category);
    }

    public void makeNoise() {
        System.out.println("HISS");
    }
}