package Contest.twoEightThree;

import java.util.*;

public class AppendKIntegersWithMinimalSum {
    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
//        long minVal = Long.MAX_VALUE;
//        HashSet<Long> numsSet = new HashSet<>();
        HashMap<Integer, Integer> relationMap = new HashMap<>();
        int prevValue = 0;
        for (int n: nums){
            if (!(prevValue == n)){
                relationMap.put(n, prevValue);
                prevValue = n;
            }
        }

        int min = nums[0];

//        System.out.println(relationMap.values());

        long totalKBefore = Math.min(k, min - 1);
//
//
//
//
//
        long count = totalKBefore+1;
        long kCount = totalKBefore;
        long kSum = (totalKBefore * (totalKBefore + 1)) / 2;


//
//        while (kCount < k){
//            if (!numsSet.contains(count)){
//                kSum += count;
//                kCount++;
////                System.out.println(count);
//            }
//
//
//            count++;
//        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimalKSum(new int[]{5,6}, 6));
        System.out.println(minimalKSum(new int[]{1,4,25,10,25}, 2));
    }
}
