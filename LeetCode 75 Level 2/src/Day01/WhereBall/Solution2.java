package Day01.WhereBall;

public class Solution2 {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];

        for (int col = 0; col < grid[0].length; col++) {
            result[col] = fall(0, col, grid);
        }

        return result;
    }

    public int fall(int currRow, int currCol, int[][] grid) {
        if (currRow == grid.length - 1) {
            if (grid[currRow][currCol] == 1) {
                if ((currCol == grid[0].length - 1) || grid[currRow][currCol + 1] == -1) {
                    return -1;
                } else {
                    return currCol + 1;
                }
            } else {
                if ((currCol == 0) || grid[currRow][currCol - 1] == 1) {
                    return -1;
                } else {
                    return currCol - 1;
                }
            }
        } else {
            if (grid[currRow][currCol] == 1) {
                if ((currCol == grid[0].length - 1) || grid[currRow][currCol + 1] == -1) {
                    return -1;
                } else {
                    return fall(currRow + 1, currCol + 1, grid);
                }
            } else {
                if ((currCol == 0) || grid[currRow][currCol - 1] == 1) {
                    return -1;
                } else {
                    return fall(currRow + 1, currCol - 1, grid);
                }
            }
        }
    }
}
