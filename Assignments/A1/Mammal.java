package org.example;

public class Mammal extends Animal {

    public Mammal(String name, String description, String noise, String category) {
        super(name, description, noise, category);
    }

    @Override
    public void makeNoise() {
        String noise = getNoise();
        System.out.println(noise);
    }
}
