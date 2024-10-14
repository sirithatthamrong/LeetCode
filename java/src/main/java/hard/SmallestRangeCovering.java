package hard;

import java.util.*;

// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
public class SmallestRangeCovering {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int max = Integer.MIN_VALUE; // Track the current max element
        // Add the first element of each list to the heap
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).getFirst();
            minHeap.offer(new int[]{value, i, 0}); // {value, listIndex, elementIndex}
            max = Math.max(max, value);  // Track the initial max element
        }

        int start = minHeap.peek()[0];
        int end = max;
        int minRange = end - start;

        // Process the heap
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];

            // Update the range if the current range is smaller
            if (max - value < minRange) {
                start = value;
                end = max;
                minRange = end - start;
            }

            // If there are more elements in the same list, add the next one
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextValue, listIndex, elementIndex + 1});
                max = Math.max(max, nextValue); // Update the max element
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        SmallestRangeCovering solution = new SmallestRangeCovering();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(solution.smallestRange(nums))); // [20, 24]
    }
}
