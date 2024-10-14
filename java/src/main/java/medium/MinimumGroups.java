package medium;

import java.util.*;

// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/
public class MinimumGroups {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        PriorityQueue<Integer> groups = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!groups.isEmpty() && interval[0] > groups.peek()) {
                groups.poll();
            }
            groups.offer(interval[1]);
        }

        return groups.size();
    }

    public static void main(String[] args) {
        MinimumGroups solution = new MinimumGroups();
        System.out.println(solution.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}})); // 3
        System.out.println(solution.minGroups(new int[][]{{1, 3}, {5, 6}, {8, 10}, {11, 13}})); // 1
    }
}
