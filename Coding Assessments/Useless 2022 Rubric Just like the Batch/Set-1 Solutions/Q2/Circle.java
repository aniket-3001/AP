public class Circle extends Shape {
    static double pi = 3.14;

    private Coordinate center;
    private double radius;

    public Circle(Coordinate center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return pi * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * pi * radius;
    }

    public boolean checkIntersection(Circle other) {
        double distance = Math.sqrt(Math.pow(center.getX() - other.center.getX(), 2) + Math.pow(center.getY() - other.center.getY(), 2));
        return distance <= radius + other.radius;
    }
}