public class Add implements Compute{
    private final Compute f1, f2;

    Add(Compute f1, Compute f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public String toString() {
        return String.format("(%s + %s)", f1, f2);
    }

    @Override
    public float compute(float val) {
        return f1.compute(val) + f2.compute(val);
    }
}
