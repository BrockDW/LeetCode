import Solution.TwoSum;
import org.openjdk.jmh.annotations.Benchmark;

public class Main {
//    @Benchmark
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        Integer[] nums = new Integer[]{3,2,4};
        ts.twoSum(nums, 6);


    }
}
