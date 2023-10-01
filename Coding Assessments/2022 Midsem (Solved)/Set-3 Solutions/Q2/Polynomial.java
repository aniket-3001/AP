import java.util.ArrayList;

public class Polynomial<T extends Number> {
    private int degree;
    private ArrayList<T> coefficients;

    public Polynomial(int degree) {
        this.degree = degree;
        this.coefficients = new ArrayList<>();
        // Initialize coefficients with zeros
        for (int i = 0; i <= degree; i++) {
            this.coefficients.add(null);
        }
    }

    public Polynomial(int degree, ArrayList<T> coefficients) {
        this.degree = degree;
        this.coefficients = coefficients;
    }

    public int getDegree() {
        return this.degree;
    }

    public T getCoefficient(int index) {
        return this.coefficients.get(index);
    }

    public ArrayList<T> getCoefficients() {
        return this.coefficients;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setCoefficients(ArrayList<T> coefficients) {
        this.coefficients = coefficients;
    }

    public void setCoefficient(int index, T coefficient) {
        this.coefficients.set(index, coefficient);
    }

    public Polynomial<T> add(Polynomial<T> other) {
        Polynomial result;
        ArrayList<T> newCoefficients = new ArrayList<>();
        int degree = Math.max(this.degree, other.degree);

        if (this.degree > other.degree) {
            for (int i = 0; i <= this.degree; i++) {
                if (i <= other.degree) {
                    try {
                        newCoefficients.add((T) GenericOperations.add(this.coefficients.get(i), other.coefficients.get(i)));
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    newCoefficients.add(this.coefficients.get(i));
                }
            }
        }
        else {
            for (int i = 0; i <= other.degree; i++) {
                if (i <= this.degree) {
                    try {
                        newCoefficients.add((T) GenericOperations.add(this.coefficients.get(i), other.coefficients.get(i)));
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    newCoefficients.add(other.coefficients.get(i));
                }
            }
        }

        result = new Polynomial(degree, newCoefficients);
        return result;
    }

    public Polynomial<T> subtract(Polynomial<T> other) {
        Polynomial result;
        ArrayList<T> newCoefficients = new ArrayList<>();
        int degree = Math.max(this.degree, other.degree);

        if (this.degree > other.degree) {
            for (int i = 0; i <= this.degree; i++) {
                if (i <= other.degree) {
                    try {
                        newCoefficients.add((T) GenericOperations.subtract(this.coefficients.get(i), other.coefficients.get(i)));
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    newCoefficients.add(this.coefficients.get(i));
                }
            }
        }
        else {
            for (int i = 0; i <= other.degree; i++) {
                if (i <= this.degree) {
                    try {
                        newCoefficients.add((T) GenericOperations.subtract(this.coefficients.get(i), other.coefficients.get(i)));
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    newCoefficients.add(other.coefficients.get(i));
                }
            }
        }

        result = new Polynomial(degree, newCoefficients);
        return result;
    }

    public Polynomial getGradient() {
        ArrayList<T> newCoefficients = new ArrayList<>();

        for (int i = 1; i <= this.degree; i++) {
            try {
                newCoefficients.add((T) GenericOperations.multiply(this.coefficients.get(i), i));
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Polynomial(this.degree - 1, newCoefficients);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= this.degree; i++) {
            result.append(this.coefficients.get(i)).append(", ");
        }

        return result.toString();
    }
    public void printPolynomial() {
        System.out.println(this);
    }
}
