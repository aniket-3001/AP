public class Main {
    public static void main(String[] args) {
        Compute p1 = new Constant(2F);
        Compute p2 = new Logarithm(3.0F);

        Compute func = new Add(p1, p2);
        System.out.println(func);


        System.out.println(func.compute(2));

    }
}
