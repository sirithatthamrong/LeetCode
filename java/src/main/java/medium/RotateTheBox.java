package medium;

public class RotateTheBox {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // i = row, j = column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }

        // i = column, j = row
        for (int i = 0; i < m; i++) {
            int filled = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (result[j][i] == '#') {
                    result[j][i] = '.';
                    result[filled][i] = '#';
                    filled--;
                } else if (result[j][i] == '*') {
                    filled = j - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RotateTheBox solution = new RotateTheBox();
        char[][] box = new char[][]{
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };
        char[][] result = solution.rotateTheBox(box);
        for (char[] row : result) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}