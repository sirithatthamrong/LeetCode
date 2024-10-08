package medium;

import java.util.*;

// https://leetcode.com/problems/3sum-closest/description/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - curSum) < Math.abs(target - closestSum)) {
                    closestSum = curSum;
                }

                if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // 2
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1)); // 2
    }
}
