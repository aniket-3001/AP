public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z; 
    }

    public void setX(double x){
        this.x=x;
    }

    public void setY(double y){
        this.y=y;
    }

    public void setZ(double z){
        this.z=z;
    }

    public static double computeDotProduct(Vector v1, Vector v2){
        return (v1.x*v2.x)+(v1.y*v2.y)+(v1.z*v2.z);
    }

    public static Vector computeCrossProduct(Vector v1, Vector v2){
        double x = (v1.y*v2.z)-(v1.z*v2.y);
        double y = (v1.z*v2.x)-(v1.x*v2.z);
        double z = (v1.x*v2.y)-(v1.y*v2.x);
        
        return new Vector(x, y, z);
    }

    public String toString(){
        return x+"i + "+y+"j + "+z+"k";
    }
}
