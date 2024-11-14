package medium;

import java.util.*;

// https://leetcode.com/problems/count-fair-pairs/
public class CountFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long count = 0;
        int n = nums.length;

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < n - 1; i++) {
            System.out.println("---------------------------");
            System.out.println("i: " + i);
            System.out.println("target left: " + (lower - nums[i]));
            System.out.println("target right: " + (upper - nums[i]));

            // first index where nums[j] + num[i] >= lower
            int  left = bound(nums, i + 1, n, lower - nums[i], 1);
            // first index where nums[j] + num[i] > upper
            int right = bound(nums, i + 1, n, upper - nums[i], 0);
            count += right - left;
            System.out.println("left: " + left + ", right: " + right + ", count: " + count);
        }
        return count;
    }

    private int bound(int[] nums, int start, int end, int target, int flag) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target && flag == 1) end = mid;
            else if (nums[mid] > target && flag == 0) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        CountFairPairs solution = new CountFairPairs();
        System.out.println(solution.countFairPairs(new int[]{0,1,7,4,4,5}, 3, 6)); // 6
        System.out.println(solution.countFairPairs(new int[]{1,7,9,2,5}, 11, 11)); // 1
        System.out.println(solution.countFairPairs(new int[]{3,0,9,2,5}, 11, 11)); // 1
    }
}
