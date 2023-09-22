public class Main {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Point q = new Point(1, 2);
        Point3D r = new Point3D(1, 2, 3);
        Point3D s = new Point3D(1, 2, 3);
        System.out.println(p.equals(q)); // Should print true
        System.out.println(r.equals(s)); // Should print true
        System.out.println(p.equals(r)); // Should print false
        System.out.println(r.equals(p)); // Should print false
    }
}
