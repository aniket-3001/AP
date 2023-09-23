public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5, 10);
        Rectangle rectangle2 = new Rectangle(8, 6);

        // Comparing rectangles based on area
        int comparisonResult = rectangle1.compareTo(rectangle2);
        if (comparisonResult == 0) {
            System.out.println("rectangle1 and rectangle2 have the same area.");
        } else if (comparisonResult < 0) {
            System.out.println("rectangle1 has a smaller area than rectangle2.");
        } else {
            System.out.println("rectangle1 has a larger area than rectangle2.");
        }

        // Checking if two rectangles are equal
        if (rectangle1.equals(rectangle2)) {
            System.out.println("rectangle1 and rectangle2 are equal.");
        } else {
            System.out.println("rectangle1 and rectangle2 are not equal.");
        }
    }
}
