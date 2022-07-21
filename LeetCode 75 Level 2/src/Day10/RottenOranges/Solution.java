public class Solution {
    public int orangesRotting(int[][] grid) {
        int mMax = grid.length;
        int nMax = grid[0].length;
        
        int day = 0;
        int freshCount = 0;
        boolean change = true;
        
        for (int m = 0; m < mMax; m++) {
            for (int n = 0; n < nMax; n++) {
				if (grid[m][n] == 1) freshCount++;
            }
        }
        
        while (freshCount > 0 && change == true) {
            change = false;
            
            for (int m = 0; m < mMax; m++) {
				for (int n = 0; n < nMax; n++) {
                    if (grid[m][n] == 1) {
                        if (
                            (m > 0 && grid[m-1][n] == 2) ||
                            (n > 0 && grid[m][n-1] == 2) ||
                            (m < mMax - 1 && grid[m+1][n] == 2) ||
                            (n < nMax - 1 && grid[m][n+1] == 2)
                           ) {
                            change = true;
                            freshCount--;
                            grid[m][n] = 3;
                        }
                    }
                }
            }
            
            if (change) {
                day++;
                
                for (int m = 0; m < mMax; m++) {
                    for (int n = 0; n < nMax; n++) {
                        if (grid[m][n] == 3) grid[m][n] = 2;
                    }
                }
            }
        }
        
        if (freshCount > 0) {
            return -1;
        } else {
	        return day;
        }
    }
}