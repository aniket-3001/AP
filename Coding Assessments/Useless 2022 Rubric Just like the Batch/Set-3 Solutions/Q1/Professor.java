public class Professor {
    private String name;
    private int experience;

    public Professor(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return String.format("Professor Name: %s\nExperience: %d", name, experience);
    }
}
