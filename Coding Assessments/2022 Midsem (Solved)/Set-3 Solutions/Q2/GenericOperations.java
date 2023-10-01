public class GenericOperations {

    // Generic method to add two values of type T
    public static <T extends Number> T add(T a, T b) throws IllegalArgumentException {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        }
        throw new IllegalArgumentException("Unsupported number type");
    }

    // Generic method to subtract two values of type T
    public static <T extends Number> T subtract(T a, T b) throws IllegalArgumentException {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        }
        throw new IllegalArgumentException("Unsupported number type");
    }

    // Generic method to multiply two values of type T
    public static <T extends Number> T multiply(T a, T b) throws IllegalArgumentException {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        }
        throw new IllegalArgumentException("Unsupported number type");
    }
}
