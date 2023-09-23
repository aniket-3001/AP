import java.util.Arrays;
import java.util.List;

public class Main {
    public static double sum(List<? extends Number> nums) {
        double sum = 0.0;

        for (Number num : nums) {
            sum += num.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        System.out.println(sum(nums));

        List<Double> doubles = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println(sum(doubles));
    }
}
