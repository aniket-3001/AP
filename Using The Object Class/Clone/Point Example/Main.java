public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = p1.clone();
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
    }
}


