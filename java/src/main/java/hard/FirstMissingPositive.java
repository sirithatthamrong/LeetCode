package hard;

import java.util.*;

// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 1;

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        while (map.containsKey(n)) { n++; }

        return n;
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0})); // 3
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // 1
        System.out.println(solution.firstMissingPositive(new int[]{0, 2, 2, 1, 1, 1})); // 3

    }
}
