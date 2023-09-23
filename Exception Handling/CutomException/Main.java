public class Main {
    public static void main(String[] args) {
        // Create Wendy and Andy instances
        Wendy wendy = new Wendy();
        Andy andy = new Andy(wendy);

        System.out.println("Creating Wendy and Andy instances...");

        // Attempt to drink water
        System.out.println("Calling andy.drinkWater()...");
        andy.drinkWater();

        System.out.println("Water drinking attempt completed.");
    }
}
