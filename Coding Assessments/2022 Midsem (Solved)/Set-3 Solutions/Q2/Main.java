import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) { // You may want to change this to a different loop condition.
            System.out.println("Test Case #" + i);

            System.out.println("Mention the type of Polynomial: ");
            String type = sc.nextLine();
            System.out.println();

            if (!type.equals("Integer") && !type.equals("Double")) {
                System.out.println("Invalid type");
                continue; // Instead of 'return', use 'continue' to restart the loop.
            }

            System.out.println("Mention the type of operation to perform: ");
            String operation = sc.nextLine();
            System.out.println();

            if (!operation.equals("Add") && !operation.equals("Subtract") && !operation.equals("getPolynomialGradient")) {
                System.out.println("Invalid operation");
                continue; // Instead of 'return', use 'continue' to restart the loop.
            }

            if (!operation.equals("getPolynomialGradient")) {
                // for first polynomial
                System.out.println("Enter the first polynomial (degree in the line below, followed by space separated coefficients in the next line): ");
                int degree1 = sc.nextInt();
                sc.nextLine(); // Consume the newline character after reading the integer.
                String[] coeff1 = sc.nextLine().split(" ");
                System.out.println();

                ArrayList<Integer> coefficients1 = new ArrayList<>();
                ArrayList<Double> coefficients1Double = new ArrayList<>();

                if (type.equals("Integer")) {
                    for (String coefficient : coeff1) {
                        coefficients1.add(Integer.parseInt(coefficient));
                    }
                } else {
                    for (String coefficient : coeff1) {
                        coefficients1Double.add(Double.parseDouble(coefficient));
                    }
                }

                // for second polynomial
                System.out.println("Enter the second polynomial (degree in the line below, followed by space separated coefficients in the next line): ");
                int degree2 = sc.nextInt();
                sc.nextLine(); // Consume the newline character after reading the integer.
                String[] coeff2 = sc.nextLine().split(" ");
                System.out.println();

                ArrayList<Integer> coefficients2 = new ArrayList<>();
                ArrayList<Double> coefficients2Double = new ArrayList<>();

                if (type.equals("Integer")) {
                    for (String coefficient : coeff2) {
                        coefficients2.add(Integer.parseInt(coefficient));
                    }
                } else {
                    for (String coefficient : coeff2) {
                        coefficients2Double.add(Double.parseDouble(coefficient));
                    }
                }

                // Create Polynomial objects based on the type
                if (type.equals("Integer")) {
                    Polynomial p1 = new Polynomial(degree1, coefficients1);
                    Polynomial p2 = new Polynomial(degree2, coefficients2);

                    if (operation.equals("Add")) {
                        Polynomial result = p1.add(p2);
                        result.printPolynomial();
                    } else {
                        Polynomial result = p1.subtract(p2);
                        result.printPolynomial();
                    }
                } else {
                    Polynomial p1 = new Polynomial(degree1, coefficients1Double);
                    Polynomial p2 = new Polynomial(degree2, coefficients2Double);

                    if (operation.equals("Add")) {
                        Polynomial<?> result = p1.add(p2);
                        result.printPolynomial();
                    } else {
                        Polynomial<?> result = p1.subtract(p2);
                        result.printPolynomial();
                    }
                }
            }

            else {
                // for the polynomial
                System.out.println("Enter the polynomial (degree in the line below, followed by space separated coefficients in the next line): ");
                int degree = sc.nextInt();
                sc.nextLine(); // Consume the newline character after reading the integer.
                String[] coeff = sc.nextLine().split(" ");
                System.out.println();

                ArrayList<Integer> coefficients = new ArrayList<>();
                ArrayList<Double> coefficientsDouble = new ArrayList<>();

                if (type.equals("Integer")) {
                    for (String coefficient : coeff) {
                        coefficients.add(Integer.parseInt(coefficient));
                    }
                } else {
                    for (String coefficient : coeff) {
                        coefficientsDouble.add(Double.parseDouble(coefficient));
                    }
                }

                // Create Polynomial objects based on the type
                if (type.equals("Integer")) {
                    Polynomial p = new Polynomial(degree, coefficients);
                    Polynomial result = p.getGradient();
                    result.printPolynomial();
                } else {
                    Polynomial p = new Polynomial(degree, coefficientsDouble);
                    Polynomial<?> result = p.getGradient();
                    result.printPolynomial();
                }
            }

        }

        sc.close();
    }
}
