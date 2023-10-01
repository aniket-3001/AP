public class Main {
    public static void main(String[] args) {
        Helicopter h1 = new Helicopter();
        Rotator r = new Rotator();
        Flyer f = new Flyer();
        Helicopter h2 = new Helicopter();

        h1.drive(r);
        h1.drive(f);
        h1.drive(h2);
    }
}