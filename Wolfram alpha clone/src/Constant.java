public class Constant implements Compute, Function{
    private final float value;

    Constant(float value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%f)", this.value);
    }

    @Override
    public float compute(float val) {
        return this.value;
    }

    @Override
    public Compute derivative() {
        return new Constant(0.0F);
    }

    @Override
    public Compute integrate() {
        return new Multiply(new Constant(this.value),
                new Power(1.0F));
    }
}
