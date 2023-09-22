public class ComplexInteger extends Complex<ComplexInteger> {
    private int real;
    private int img;

    public ComplexInteger(int real, int img) {
        this.real = real;
        this.img = img;
    }

    @Override
    public ComplexInteger add(ComplexInteger other) {
        return new ComplexInteger(this.real + other.real, this.img + other.img);
    }

    @Override
    public ComplexInteger multiply(ComplexInteger other) {
        return new ComplexInteger(this.real * other.real - this.img * other.img, this.real * other.img + this.img * other.real);
    }

    @Override
    public double argument() {
        return Math.atan2(this.img, this.real);
    }

    @Override
    public double magnitude() {
        return Math.sqrt(real*real+img*img);
    }

    @Override
    public String toString() {
        return this.real + " + " + this.img + "i";
    }
}
