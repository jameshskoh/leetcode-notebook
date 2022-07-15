package Day01.WhereBall;

public class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];

        for (int col = 0; col < grid[0].length; col++) {
            int myCol = col;

            for (int row = 0; row < grid.length; row++) {
                if (row == grid.length - 1) {
                    int dir = fall(row, myCol, grid);

                    if (dir == 0) {
                        result[col] = -1;
                        break;
                    }

                    myCol += dir;
                    result[col] = myCol;
                    break;
                } else {
                    int dir = fall(row, myCol, grid);

                    if (dir == 0) {
                        result[col] = -1;
                        break;
                    }

                    myCol += dir;
                }
            }
        }

        return result;
    }

    public int fall(int currRow, int currCol, int[][] grid) {
        if (grid[currRow][currCol] == 1) {
            if ((currCol == grid[0].length - 1) || grid[currRow][currCol + 1] == -1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if ((currCol == 0) || grid[currRow][currCol - 1] == 1) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
