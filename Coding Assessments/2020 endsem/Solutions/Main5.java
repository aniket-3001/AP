//Q5: There is a null pointer error exception in this code.
// By adding appropriate initialization blocks, ensure that the null pointer exception is removed.

public class Main5 {
    static B5 b = new B5();
    int i=5;
    public static void main(String[] args) {
        System.out.println(b.a.m.i);
    }
}

class A5{
    Main5 m = new Main5();
}

class B5 {
    A5 a = new A5();
}

