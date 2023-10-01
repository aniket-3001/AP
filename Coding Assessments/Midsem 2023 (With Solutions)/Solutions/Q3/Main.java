import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pincodePattern = Pattern.compile("^[1-9]\\d{5}$");

        while (true) {
            try {
                System.out.println("Enter pin code: ");
                String pincode = sc.nextLine();
                System.out.println();

                if (!pincodePattern.matcher(pincode).matches()) {
                    throw new IncorrectPincodeException("Invalid pin code");
                } else {
                    System.out.println("Valid pin code received. Exiting...");
                    break;
                }
            } catch (IncorrectPincodeException e) {
                System.out.println(e);
                System.out.println();
            }
        }

        sc.close();
    }
}
