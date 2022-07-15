package Day01.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        Mode currMode = Mode.RIGHT;
        int[] currPos = new int[]{0, 0};

        int totalElements = matrix.length * matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>(totalElements);

        int[] bounds = new int[]{
                0,
                matrix.length - 1,
                0,
                matrix[0].length - 1
        };

        for (int i = 0; i < totalElements; i++) {
            result.add(matrix[currPos[0]][currPos[1]]);
            currMode = traverse(currPos, currMode, bounds);
        }

        return result;
    }

    private Mode traverse(int[] currPos, Mode currMode, int[] bounds) {
        if (currMode == Mode.RIGHT) {
            if (currPos[1] == bounds[3]) {
                currMode = turn(currMode);
                bounds[0]++;
                traverse(currPos, currMode, bounds);
            } else {
                currPos[1]++;
            }
        } else if (currMode == Mode.DOWN) {
            if (currPos[0] == bounds[1]) {
                currMode = turn(currMode);
                bounds[3]--;
                traverse(currPos, currMode, bounds);
            } else {
                currPos[0]++;
            }
        } else if (currMode == Mode.LEFT) {
            if (currPos[1] == bounds[2]) {
                currMode = turn(currMode);
                bounds[1]--;
                traverse(currPos, currMode, bounds);
            } else {
                currPos[1]--;
            }
        } else {
            if (currPos[0] == bounds[0]) {
                currMode = turn(currMode);
                bounds[2]++;
                traverse(currPos, currMode, bounds);
            } else {
                currPos[0]--;
            }
        }

        return currMode;
    }

    private Mode turn(Mode currMode) {
        if (currMode == Mode.RIGHT) {
            return Mode.DOWN;
        } else if (currMode == Mode.DOWN) {
            return Mode.LEFT;
        } else if (currMode == Mode.LEFT) {
            return Mode.UP;
        } else {
            return Mode.RIGHT;
        }
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{
            new int[]{1, 2, 3, 4},
            new int[]{5, 6, 7, 8},
            new int[]{9, 10, 11, 12},
            new int[]{13, 14, 15, 16}
        };

        Solution s = new Solution();
        System.out.println(s.spiralOrder(test1));
    }
}

enum Mode {
    RIGHT,
    DOWN,
    LEFT,
    UP
}
