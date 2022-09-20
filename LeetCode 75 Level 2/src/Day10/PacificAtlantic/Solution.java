package Day10.PacificAtlantic;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int maxRow = heights.length;
    int maxCol = heights[0].length;

    int[][] canPO = new int[maxRow][maxCol];
    int[][] canAO = new int[maxRow][maxCol];

    // populate elements adjacent to PO/AO
    for (int row = 0; row < maxRow; row++) {
        canPO[row][0] = 1;
        canAO[row][maxCol-1] = 1;
    }

    for (int col = 0; col < maxCol; col++) {
        canPO[0][col] = 1;
        canAO[maxRow-1][col] = 1;
    }

    for (int row = 1; row < maxRow; row++) {
        for (int col = 1; col < maxCol; col++) {
            checkFlowable(row, col, canPO, heights);
        }
    }

    for (int row = 0; row < maxRow - 1; row++) {
        for (int col = 0; col < maxCol - 1; col++) {
            checkFlowable(row, col, canAO, heights);
        }
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    for (int row = 0; row < maxRow; row++) {
        for (int col = 0; col < maxCol; col++) {
            if (canPO[row][col] == 1 && canAO[row][col] == 1) {
                List<Integer> coord = new ArrayList<Integer>();
                coord.add(row);
                coord.add(col);
                result.add(coord);
            }
        }
    }

    return result;
}

    private int checkFlowable(int row, int col, int[][] flowMap, int[][] heights) {
        // looping flag: used to prevent a self looping "dry" area
        // "-1 means don't ask me, I am still waiting for the answer"
        // but itself it not assigned -1, because it is pending the previous stack to return it to normal value
        if (flowMap[row][col] == 2) {
            return -1;
        }

        if (flowMap[row][col] == 1 || flowMap[row][col] == -1)
            return flowMap[row][col];

        // looping flag: this will eventually be marked as 1 or -1
        flowMap[row][col] = 2;

        if (row > 0 && heights[row - 1][col] <= heights[row][col]) {
            int queryTop = checkFlowable(row - 1, col, flowMap, heights);
            if (queryTop == 1) {
                flowMap[row][col] = 1;
                connNeighbor(row, col, flowMap, heights);
                return 1;
            }
        }

        if (row < flowMap.length - 1 && heights[row + 1][col] <= heights[row][col]) {
            int queryBtm = checkFlowable(row + 1, col, flowMap, heights);
            if (queryBtm == 1) {
                flowMap[row][col] = 1;
                connNeighbor(row, col, flowMap, heights);
                return 1;
            }
        }

        if (col > 0 && heights[row][col - 1] <= heights[row][col]) {
            int queryLeft = checkFlowable(row, col - 1, flowMap, heights);
            if (queryLeft == 1) {
                flowMap[row][col] = 1;
                connNeighbor(row, col, flowMap, heights);
                return 1;
            }
        }

        if (col < flowMap[0].length - 1 && heights[row][col + 1] <= heights[row][col]) {
            int queryRight = checkFlowable(row, col + 1, flowMap, heights);
            if (queryRight == 1) {
                flowMap[row][col] = 1;
                connNeighbor(row, col, flowMap, heights);
                return 1;
            }
        }

        flowMap[row][col] = -1;
        return -1;
    }

    private void connNeighbor(int row, int col, int[][] flowMap, int[][] heights) {
        // as the search might accidentally flag neighbor of the same height as -1
        // this method will patch that problem
        if (row > 0 && heights[row - 1][col] == heights[row][col]) {
            flowMap[row - 1][col] = 1;
        }

        if (row < flowMap.length - 1 && heights[row + 1][col] == heights[row][col]) {
            flowMap[row + 1][col] = 1;
        }

        if (col > 0 && heights[row][col - 1] == heights[row][col]) {
            flowMap[row][col - 1] = 1;
        }

        if (col < flowMap[0].length - 1 && heights[row][col + 1] == heights[row][col]) {
            flowMap[row][col + 1] = 1;
        }

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

        Solution s = new Solution();

        printList(s.pacificAtlantic(test));
    }
}
