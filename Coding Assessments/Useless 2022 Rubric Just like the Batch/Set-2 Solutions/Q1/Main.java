import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter x-coordinate of first vector: ");
        double x1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter y-coordinate of first vector: ");
        double y1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter z-coordinate of first vector: ");
        double z1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter x-coordinate of second vector: ");
        double x2 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter y-coordinate of second vector: ");
        double y2 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter z-coordinate of second vector: ");
        double z2 = sc.nextDouble();
        sc.nextLine();

        Vector v1 = new Vector(x1, y1, z1);
        Vector v2 = new Vector(x2, y2, z2);

        System.out.println("First vector is: " + v1);
        System.out.println("Second vector is: " + v2);

        System.out.println("Dot product of the two vectors is: " + Vector.computeDotProduct(v1, v2));
        System.out.println("Cross product of the two vectors is: " + Vector.computeCrossProduct(v1, v2));

        sc.close();
    }
}
