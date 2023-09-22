public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2, 32);
        Rectangle r2 = new Rectangle(4, 16);
        RectangleAreaComparator rac = new RectangleAreaComparator();
        RectangleSidesComparator rsc = new RectangleSidesComparator();
        int area_result = rac.compare(r1, r2);
        int sides_result = rsc.compare(r1, r2);

        System.out.println("Area result: " + area_result);
        System.out.println("Sides result: " + sides_result);
    }
}