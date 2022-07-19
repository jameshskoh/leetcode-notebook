package Day08.Search2D;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lb = 0;
        int ub = matrix.length * matrix[0].length - 1;

        while (lb <= ub) {
            int mid = (lb + ub) / 2;

            int iMid = getCol(mid, matrix);
            int jMid = getRow(mid, matrix);

            if (matrix[iMid][jMid] == target) {
                return true;
            } else if (matrix[iMid][jMid] < target) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }

        return false;
    }

    private int getCol(int index, int[][] matrix) {
        return index / matrix[0].length;
    }

    private int getRow(int index, int[][] matrix) {
        return index % matrix[0].length;
    }
}
