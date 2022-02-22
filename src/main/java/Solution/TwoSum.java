package Solution;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.HashMap;

public class TwoSum {
    public static Integer[] twoSum(Integer[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new Integer[]{map.get(target - nums[i]), i};
            };
            map.put(nums[i], i);
        }
        return null;
    }

    public static Integer[] twoSumDoubleForLoop(Integer[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new Integer[] { i, j };
                }
            }
        }
        return new Integer[] {};
    }
}
