package medium;

import java.util.*;

public class MaxSubArraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long currentSum = 0;
        Set<Integer> set = new HashSet<>();
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i])) { // If the current number is already in the set, remove the start number from the set
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }

            set.add(nums[i]);
            currentSum += nums[i];

            if (i - start + 1 == k) {
                max = Math.max(max, currentSum);
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubArraySum solution = new MaxSubArraySum();
        System.out.println(solution.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3)); // 15
        System.out.println(solution.maximumSubarraySum(new int[]{4, 4, 4}, 3)); // 0
        System.out.println(solution.maximumSubarraySum(new int[]{1, 1, 2}, 2)); // 3
        System.out.println(solution.maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3)); // 24
    }
}