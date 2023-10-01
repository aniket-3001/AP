public class Helicopter implements RotateAndFly {
    public void rotate() {}

    public void fly() {}

    public void drive(Rotatable r) {
        System.out.println("Type: " + r.getClass());
    }
}
