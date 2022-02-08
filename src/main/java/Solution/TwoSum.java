package Solution;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
//            Integer integer = map.get(target - nums[i]);
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            };
            map.put(nums[i], i);
        }
        return null;
    }
}