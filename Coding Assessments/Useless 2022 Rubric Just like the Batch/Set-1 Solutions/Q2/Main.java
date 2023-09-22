public class Main {
    public static void main(String[] args) {
        Coordinate a = new Coordinate(0, 0);
        Coordinate b = new Coordinate(0, 1);
        Coordinate c = new Coordinate(1, 1);
        Coordinate d = new Coordinate(1, 0);

        Quadrilateral q = new Quadrilateral(a, b, c, d);
        System.out.println(q.getArea());
        System.out.println(q.getPerimeter());
        System.out.println(q.getType());

        Coordinate center1 = new Coordinate(0, 0);
        Coordinate center2 = new Coordinate(1, 1);

        Circle c1 = new Circle(center1, 1);
        Circle c2 = new Circle(center2, 1);

        System.out.println(c1.checkIntersection(c2));
    }
}
