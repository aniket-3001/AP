public class Logarithm implements Compute, Function{
    private final float base;

    Logarithm(float base){
        this.base = base;
    }

    @Override
    public String toString() {
        return String.format("log(%f)x", this.base);
    }

    @Override
    public Compute derivative() {
        // 1/x * 1/ln(a)
        return new Multiply(new Power(-1F),
                new Constant((float) (1/Math.log(this.base))));
    }

    @Override
    public Compute integrate() {
        //x * log x - x / log(a
        Compute p1 = new Multiply(new Power(1F), new Logarithm(this.base));
        Compute p2 = new Divide(new Power(1F), new Constant((float) Math.log(this.base)));

        Compute result = new Subtract(p1, p2);

        return result;
    }

    @Override
    public float compute(float val) {
        return (float) (Math.log(val)/Math.log(this.base));
    }
}
