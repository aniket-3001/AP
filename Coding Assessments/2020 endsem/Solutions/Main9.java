import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main9 {
    public static void main(String[] args) {
        // Create a list to store complex numbers
        List<cmplx2> complexList = new ArrayList<>();

        // Add 5 complex numbers to the list
        complexList.add(new cmplx2(5.5, 7.5));
        complexList.add(new cmplx2(3.0, 2.0));
        complexList.add(new cmplx2(1.5, 4.0));
        complexList.add(new cmplx2(6.0, 9.0));
        complexList.add(new cmplx2(2.5, 1.5));

        // Use an iterator to print the complex numbers
        Iterator<cmplx2> iterator = complexList.iterator();
        while (iterator.hasNext()) {
            cmplx2 complexNumber = iterator.next();
            System.out.println(complexNumber.re + "+" + complexNumber.im + "i");
        }
    }
}

class cmplx2 {
    double re;
    double im;

    cmplx2(double re, double im) {
        this.re = re;
        this.im = im;
    }
}
