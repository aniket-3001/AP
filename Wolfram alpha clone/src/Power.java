public class Power implements Compute, Function{
    private final float exp;

    Power(float exp){
        this.exp = exp;
    }

    @Override
    public String toString() {
        return String.format("(x^{%f}", this.exp);
    }

    @Override
    public float compute(float val) {
        return (float) Math.pow(val, this.exp);
    }

    @Override
    public Compute derivative() {
        return new Multiply(new Constant(this.exp),
                new Power(this.exp-1));
    }

    @Override
    public Compute integrate() {
        return new Divide(new Power(this.exp+1),
                new Constant(this.exp + 1));
    }
}
