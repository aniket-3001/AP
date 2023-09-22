public class Main2 {
    public static void main(String[] args) {
        double a1 = 5.5;
        double b1 = 4.5;
        int a2 = 5;
        int b2 = 4;

        (new ComplexNumber<Double>(a1, b1)).printComplex();
        (new ComplexNumber<Integer>(a2, b2)).printComplex();
    }
}

class ComplexNumber<T extends Number> {
    private T real;
    private T imaginary;

    public ComplexNumber(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void printComplex() {
        System.out.println(real + "+" + imaginary + "i");
    }
}
