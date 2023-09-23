public class Main {
    public static void main(String[] args) {
        int i = 20;
        int j = 0;

        try {
            j = 18/i;

            if (j == 0) {
                throw new ArithmeticException("Divide by zero");
                // throw keyword calls the catch block
            }
        }

        catch (ArithmeticException e) {
            j = 18/1;
            System.out.println("that is the default output " + e.getMessage());
            // e instead of e.getMessage() also works since the toString of an exception esentially calls the getMessage() method and concatenates it with the exception name
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
        }

        System.out.println(j);
    }
}
