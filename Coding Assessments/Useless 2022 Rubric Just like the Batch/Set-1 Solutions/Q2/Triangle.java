public class Triangle extends Shape {
    private Coordinate a;
    private Coordinate b;
    private Coordinate c;

    private double A;
    private double B;
    private double C;

    public Triangle(Coordinate a, Coordinate b, Coordinate c) {
        this.a = a;
        this.b = b;
        this.c = c;

        A = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        B = Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2));
        C = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2));
    }

    @Override
    public double getArea() {
        double s = (A + B + C) / 2;
        return Math.sqrt(s * (s - A) * (s - B) * (s - C));
    }

    @Override
    public double getPerimeter() {
        return A + B + C;
    }

    public String getType() {
        // check for equilateral, isosceles, scalene
        if (A == B && B == C) {
            return "Equilateral";
        } else if (A == B || B == C || C == A) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}
