public class Quadrilateral extends Shape {
    private Coordinate a;
    private Coordinate b;
    private Coordinate c;
    private Coordinate d;

    private double A;
    private double B;
    private double C;
    private double D;

    public Quadrilateral(Coordinate a, Coordinate b, Coordinate c, Coordinate d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        A = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        B = Math.sqrt(Math.pow(b.getX() - c.getX(), 2) + Math.pow(b.getY() - c.getY(), 2));
        C = Math.sqrt(Math.pow(c.getX() - d.getX(), 2) + Math.pow(c.getY() - d.getY(), 2));
        D = Math.sqrt(Math.pow(d.getX() - a.getX(), 2) + Math.pow(d.getY() - a.getY(), 2));
    }

    @Override
    public double getArea() {
        // divide the quadrilateral into 2 triangles and compute area of both and add it

        double s1 = (A + B + D) / 2;
        double s2 = (B + C + D) / 2;

        double area1 = Math.sqrt(s1 * (s1 - A) * (s1 - B) * (s1 - D));
        double area2 = Math.sqrt(s2 * (s2 - B) * (s2 - C) * (s2 - D));

        return area1 + area2;
    }

    @Override
    public double getPerimeter() {
        return A + B + C + D;
    }

    public String getType() {
        // check for square, rectangle, parallelogram, rhombus

        if (A == B && B == C && C == D) {
            return "Square";
        } else if (A == C && B == D) {
            return "Rectangle";
        } else if (A == C && B == D && A != B) {
            return "Parallelogram";
        } else if (A == B && B == C && C == D && A != B) {
            return "Rhombus";
        } else {
            return "Quadrilateral";
        }
    }
}
