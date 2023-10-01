public class ComplexFraction extends Complex<ComplexFraction> {
    private Fraction real;
    private Fraction img;

    public ComplexFraction(Fraction real, Fraction img) {
        this.real = real;
        this.img = img;
    }

    @Override
    public ComplexFraction add(ComplexFraction other) {
        return new ComplexFraction(this.real.add(other.real), this.img.add(other.img));
    }

    @Override
    public ComplexFraction multiply(ComplexFraction other) {
        Fraction real = (this.real.multiply(other.real)).subtract(this.img.multiply(other.img).multiply(new Fraction(-1)));
        Fraction img = (this.real.multiply(other.img)).add(this.img.multiply(other.real));
        return new ComplexFraction(real, img);
    }

    @Override
    public double argument() {
        return Math.atan2(this.img.getNumerator()*this.real.getDenominator(), this.real.getNumerator()*this.img.getDenominator());
    }

    @Override
    public double magnitude() {
        return Math.sqrt(Math.pow(this.real.getNumerator(), 2) + Math.pow(this.img.getNumerator(), 2));
    }

    @Override
    public String toString() {
        return this.real + " + " + this.img + "i";
    }
}
