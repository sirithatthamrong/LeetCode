package medium;

import java.util.*;

// https://leetcode.com/problems/4sum/description/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip the same i

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip the same j

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long curSum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (curSum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++; // Skip duplicates
                        while (left < right && nums[right] == nums[right + 1]) right--; // Skip duplicates
                    } else if (curSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)); // [[-1,  0, 0, 1], [-2, -1, 1, 2], [-2,  0, 0, 2]]
        System.out.println(solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8)); // [[2, 2, 2, 2]]
        System.out.println(solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296)); // []
    }
}
