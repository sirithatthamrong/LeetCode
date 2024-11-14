package medium;

import java.util.*;

// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
public class MinimizedMax {
    public int minimizedMaximum(int n, int[] quantities) {
        if (n == 1) return quantities[0];

        int min_q = 1;
        int max_q = Arrays.stream(quantities).max().orElse(1);

        while (min_q < max_q) {
            int mid = min_q + (max_q - min_q) / 2;
            System.out.println("---------------------------");
            System.out.println("mid: " + mid + ", min: " + min_q + ", max: " + max_q);
            if (check(quantities, mid, n)) max_q = mid; // If the quantities can be distributed to n stores with mid
            else min_q = mid + 1;
        }

        return max_q;
    }

    private boolean check(int[] quantities, int maxPerStore, int n) {
        int stores = 0;
        for (int quantity : quantities) {
            stores += (int) Math.ceil((double) quantity / maxPerStore);
            System.out.println("quantity: " + quantity + ", stores: " + stores);
            if (stores > n) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }



    public static void main(String[] args) {
        MinimizedMax solution = new MinimizedMax();
//        System.out.println(solution.minimizedMaximum(6, new int[]{11, 6})); // 3
        System.out.println(solution.minimizedMaximum(7, new int[]{15, 10, 10})); // 5
    }
}

