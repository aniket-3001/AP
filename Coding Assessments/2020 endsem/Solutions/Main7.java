public class Main7 {
    public static void main(String[] args) {
        complex c = new complex(5.5, 7.5);
        System.out.println(c);
    }
}

class complex {
    double re;
    double im;

    complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString() {
        return re + "+" + im + "i";
    }
}
