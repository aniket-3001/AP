public abstract class Complex <T> {
    public abstract T add(T other);
    public abstract T multiply(T other);
    public abstract double argument();
    public abstract double magnitude();
    public abstract String toString();
}
