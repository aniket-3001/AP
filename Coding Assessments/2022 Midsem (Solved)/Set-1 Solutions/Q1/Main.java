import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter earthquake name: ");
        String name = sc.nextLine();
        System.out.println("Enter earthquake intensity: ");
        double intensity = sc.nextDouble();

        try {
            Earthquake e = new Earthquake(name, intensity);
            System.out.println(e);
        }
        catch (IntensityException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
