package medium;

// https://leetcode.com/problems/separate-black-and-white-balls/
public class SeparateBlackandWhiteBalls {
    public long minimumSteps(String s) {
        long swaps = 0;
        long black = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                swaps += black;
            }
            else {
                black++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        SeparateBlackandWhiteBalls solution = new SeparateBlackandWhiteBalls();
        System.out.println(solution.minimumSteps("101")); // 1
        System.out.println(solution.minimumSteps("100")); // 2
        System.out.println(solution.minimumSteps("0111")); // 0
        System.out.println(solution.minimumSteps("10101")); // 3
        System.out.println(solution.minimumSteps("11000111")); // 6
    }
}
