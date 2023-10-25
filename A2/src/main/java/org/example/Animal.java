package org.example;

public abstract class Animal {
    private final String name;
    private String description; // history of the animal
    private final String category; // Mammal, Reptile, Amphibian

    public Animal(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void makeNoise();

    public String toString() {
        return "Animal Information:" +
                "\nName: " + name +
                "\nCategory: " + getCategory() +
                "\nDescription: " + description;
    }
}
