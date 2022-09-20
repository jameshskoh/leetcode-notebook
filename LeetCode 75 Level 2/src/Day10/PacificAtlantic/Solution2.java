package Day10.PacificAtlantic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) return result;
        int col = matrix[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // top bottom
        for (int i = 0; i < col; i++) {
            dfs(matrix, 0, i, matrix[0][i], pacific);
            dfs(matrix, row - 1, i, matrix[row - 1][i], atlantic);
        }

        // left right
        for (int i = 0; i < row; i++) {
            dfs(matrix, i, 0, matrix[i][0], pacific);
            dfs(matrix, i, col - 1, matrix[i][col - 1], atlantic);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(i);
                    currentResult.add(j);
                    result.add(currentResult);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] matrix, int i, int j, int preHeight, boolean [][] ocean) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || preHeight > matrix[i][j] || ocean[i][j]) {
            return;
        }

        ocean[i][j] = true;

        dfs(matrix, i+1, j, matrix[i][j], ocean);
        dfs(matrix, i-1, j, matrix[i][j], ocean);
        dfs(matrix, i, j+1, matrix[i][j], ocean);
        dfs(matrix, i, j-1, matrix[i][j], ocean);

    }

    static void printList(List<List<Integer>> result) {
        for (List<Integer> coord : result) {
            System.out.print("Coordinates: ");

            for (int v : coord) {
                System.out.print(v + ", ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] test = {
                { 88,  1, 99, 99, 99, 99, 99, 99, 99,100, 99},
                { 88,  2, 88, 16, 15, 14, 13, 12, 11, 10, 88},
                { 88,  3, 88, 17, 88, 88, 88, 88, 88,  9, 88},
                { 88,  4, 88, 18, 88, 26, 25, 24, 88,  8, 88},
                { 88,  5, 88, 19, 88, 27, 88, 23, 88,  7, 88},
                { 88,  6, 88, 20, 88, 28, 88, 22, 88,  6, 88},
                { 88,  7, 88, 21, 88, 27, 88, 21, 88,  5, 88},
                { 88,  8, 88, 22, 88, 26, 88, 20, 88,  4, 88},
                { 88,  9, 88, 23, 24, 25, 88, 19, 88,  3, 88},
                { 88, 10, 88, 88, 88, 88, 88, 18, 88,  2, 88},
                { 88, 11, 12, 13, 14, 15, 16, 17, 88,  1, 88},
                { 99,100, 99, 99, 99, 99, 99, 99, 99,  0, 88}
        };

        Solution2 s = new Solution2();

        printList(s.pacificAtlantic(test));
    }
}
