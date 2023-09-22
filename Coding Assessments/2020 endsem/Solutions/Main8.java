public class Main8 {
    public static void main(String[] args) {
        
    }
}

class cmplx {
    private double re;
    private double im;
    private static cmplx instance;

    private cmplx() {
    }

    private cmplx(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static cmplx getInstance() {
        if (instance == null) {
            instance = new cmplx();
        }

        return instance;
    }

    public void setReal(double re) {
        this.re = re;
    }

    public void setImaginary(double im) {
        this.im = im;
    }

    public double getReal() {
        return re;
    }

    public double getImaginary() {
        return im;
    }
}
