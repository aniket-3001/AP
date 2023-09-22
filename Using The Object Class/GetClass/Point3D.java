public class Point3D extends Point {
    private int z;

    public Point3D(int _x, int _y, int _z) {
        super(_x, _y);
        z = _z;
    }

    @Override
    public boolean equals(Object o1) {
        if (o1 != null && getClass() == o1.getClass()) {
            Point3D o = (Point3D) o1;
            return (super.equals(o1) && z == o.z);
        }
        else {
            return false;
        }
    }
}