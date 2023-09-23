public class Rectangle implements Comparable<Rectangle> {
    private int sideA, sideB, area;

    public Rectangle(int _a, int _b) {
        // Constructor logic here
    }

    @Override
    public int compareTo(Rectangle o) {
        if (area == o.area) return 0;
        else if (area < o.area) return -1;
        else return 1;
    }

    @Override
    public boolean equals(Object o1) {
        if (o1 != null && getClass() == o1.getClass()) {
            Rectangle o = (Rectangle) o1; // Type casting
            return (sideA == o.sideA && sideB == o.sideB);
        } else {
            return false;
        }
    }
}
