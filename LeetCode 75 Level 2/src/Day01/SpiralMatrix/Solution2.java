package Day01.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
        int maxRow = matrix.length - 1;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;

        ArrayList<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

        while (minRow <= maxRow && minCol <= maxCol) {
            for (int col = minCol; col <= maxCol; col++) {
                result.add(matrix[minRow][col]);
            }

            minRow++;

            for (int row = minRow; row <= maxRow; row++) {
                result.add(matrix[row][maxCol]);
            }

            maxCol--;

            for (int col = maxCol; col >= minCol; col--) {
                result.add(matrix[maxRow][col]);
            }

            if (!(minRow <= maxRow && minCol <= maxCol)) {
                break;
            }

            maxRow--;

            for (int row = maxRow; row >= minRow; row--) {
                result.add(matrix[row][minCol]);
            }

            minCol++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}
        };

        Solution2 s = new Solution2();
        System.out.println(s.spiralOrder(test1));
    }
}