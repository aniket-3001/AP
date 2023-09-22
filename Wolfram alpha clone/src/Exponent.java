public class Exponent implements Compute, Function{
    private final float base;

    Exponent(float base){
        this.base = base;
    }

    @Override
    public String toString() {
        return String.format("(%f}^x", this.base);
    }

    @Override
    public Compute derivative() {
        // a^x => ln a * a^x
        Compute p1 = new Constant((float) Math.log(this.base));
        Compute p2 = new Exponent(this.base);

        return new Multiply(p1, p2);
    }

    @Override
    public Compute integrate() {
        //a^x / ln(a)
        Compute p1 = new Exponent(this.base);
        Compute p2 = new Constant((float) Math.log(this.base));

        return new Divide(p1, p2);
    }

    @Override
    public float compute(float val) {
        return (float) Math.pow(this.base, val);
    }
}
