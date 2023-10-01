public class Main {
    public static void main(String[] args) {
    Fraction obj1 = new Fraction(-2, 3); // needed
    Fraction obj2 = new Fraction(1, 4); // needed
    ComplexInteger obj3 = new ComplexInteger(2, 3); // needed
    ComplexInteger obj4 = new ComplexInteger(1, 2); // needed
    Fraction obj5 = new Fraction(1, 3);
    Fraction obj6 = new Fraction(4, 5);
    ComplexFraction obj7 = new ComplexFraction(obj5, obj6); //needed
    Fraction obj8 = new Fraction(1, 2);
    ComplexFraction obj9 = new ComplexFraction(obj8, obj8); //needed

    System.out.println(obj1.add(obj2));
    System.out.println(obj1.multiply(obj2));
    System.out.println(obj3.add(obj4));
    System.out.println(obj3.multiply(obj4));
    System.out.println(obj3.argument());
    System.out.println(obj3.magnitude());
    System.out.println(obj7.add(obj9));
    System.out.println(obj7.multiply(obj9));
    System.out.println(obj7.argument());
    System.out.println(obj7.magnitude());
}
