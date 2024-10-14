package medium;

import java.util.*;

// https://leetcode.com/problems/maximum-width-ramp/
public class MaxWithRamp {
    public int maxWidthRamp(int[] nums) {
        List<int[]> indexedNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            indexedNums.add(new int[]{nums[i], i});
        }
        indexedNums.sort(Comparator.comparingInt(x -> x[0]));

        int maxRamp = 0;
        int minIndex = Integer.MAX_VALUE;

        for (int[] pair : indexedNums) {
            int index = pair[1];

            maxRamp = Math.max(maxRamp, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }

        return maxRamp;
    }

    public static void main(String[] args) {
        MaxWithRamp solution = new MaxWithRamp();
        System.out.println(solution.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5})); // 4
        System.out.println(solution.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1})); // 7
    }
}
