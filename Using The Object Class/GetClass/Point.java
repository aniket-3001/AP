public class Point {
    private int x, y;

    public Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    @Override
    public boolean equals(Object o1) {
        if (o1 != null && getClass() == o1.getClass()) {
            Point o = (Point) o1;
            return (x == o.x && y == o.y);
        }
        else {
            return false;
        }
    }
}