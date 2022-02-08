package TwoSum;

import Solution.TwoSum;
import junit.framework.TestCase;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import testingPackage.JMHTesting;

public class TwoSumTest extends TestCase {

    @Param({"2", "7", "11", "15"})
    public int[] listOne;

    @Param({"3", "2", "4"})
    public int[] listTwo;

    @Param({"3", "3"})
    public int[] listThree;

    @Param({"9", "6", "6"})
    public int targets;

//    @Benchmark
    public void testTwoSum() {
        JMHTesting.myMethod();
//        TwoSum ts = new TwoSum();
//        int[] nums = new int[]{3,2,4};
//        ts.twoSum(nums, 6);
    }
}