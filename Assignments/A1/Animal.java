package org.example;

public abstract class Animal {
    private final String name;
    private String description; // history of the animal
    private final String noise;
    private final String category; // Mammal, Reptile, Amphibian

    public Animal(String name, String description, String noise, String category) {
        this.name = name;
        this.description = description;
        this.noise = noise;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNoise() {
        return noise;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void makeNoise();

    public String toString() {
        return "Animal {" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", noise='" + noise + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
