package medium;

import java.util.*;

// https://leetcode.com/problems/most-beautiful-item-for-each-query/
public class MaxBeauty {
    public int[] maximumBeauty(int[][] items, int[] n) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
//        System.out.println(Arrays.deepToString(items));

        int[][] queryWithIndex = new int[n.length][2];
        for (int i = 0; i < n.length; i++) {
            queryWithIndex[i] = new int[]{n[i], i};
        }
        Arrays.sort(queryWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
//        System.out.println(Arrays.deepToString(queryWithIndex));

        int[] result = new int[n.length];

        int curMax = 0;
        int itemIndex = 0;
        for (int[] q : queryWithIndex) {
            int num = q[0];
            int qIndex = q[1];
//            System.out.println("num: " + num + ", qIndex: " + qIndex);


            while (itemIndex < items.length && items[itemIndex][0] <= num) {
                curMax = Math.max(curMax, items[itemIndex][1]);
                itemIndex++;
            }

            result[qIndex] = curMax;
        }

        return result;
    }

    public static void main(String[] args) {
        MaxBeauty solution = new MaxBeauty();
        System.out.println(
                Arrays.toString(solution.maximumBeauty(new int[][]{
                        {1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}
                }, new int[]{1, 2, 3, 4, 5, 6}))); // Expected: [2, 4, 5, 5, 6, 6]
    }
}
