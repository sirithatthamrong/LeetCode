package medium;

import java.util.*;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> r_check = new HashSet<>();
        Set<Character> c_check = new HashSet<>();
        Set<Character> box_check = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.' && !r_check.add(board[i][j])) {
                    return false;
                }
                // Check column
                if (board[j][i] != '.' && !c_check.add(board[j][i])) {
                    return false;
                }
                // Check 3x3 box
                int boxRow = 3 * (i / 3) + j / 3; // 0, 0, 0, 1, 1, 1, 2, 2, 2
                int boxCol = 3 * (i % 3) + j % 3; // 0, 1, 2, 0, 1, 2, 0, 1, 2
                if (board[boxRow][boxCol] != '.' && !box_check.add(board[boxRow][boxCol])) {
                    return false;
                }
            }
            r_check.clear();
            c_check.clear();
            box_check.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board)); // true

        char[][] board2 = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board2)); // false

        char[][] board3 = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(solution.isValidSudoku(board3)); // false
    }
}