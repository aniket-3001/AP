// note that wildcards are not allowed in the declaration of a field, while generic parameters are.
// Wildcards are usually used in methods when we either require an unknown parameter, or, we are not sure about the return type.

import java.util.ArrayList;

public class Main {
    public static void print(ArrayList<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> I = new ArrayList<>();
        I.add(1);
        I.add(2);

        ArrayList<String> S = new ArrayList<>();
        S.add("Bob");
        S.add("Paul");

        print(I);
        print(S);
    }
}