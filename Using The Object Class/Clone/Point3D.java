public class Point3D extends Point {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public Point3D clone() throws CloneNotSupportedException {
        Point3D copy = (Point3D) super.clone();
        copy.z = z;
        return copy;
    }
}
