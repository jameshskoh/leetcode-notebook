package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SurroundedRegion {
    private boolean flip;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'O' || visited[i][j]) continue;

                List<Integer[]> tracks = new ArrayList<>();
                flip = true;

                dfs(board, i, j, visited, tracks);

                if (flip) {
                    for (Integer[] pair : tracks) {
                        board[pair[0]][pair[1]] = 'X';
                    }
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, List<Integer[]> tracks) {
        if (visited[i][j]) return;

        visited[i][j] = true;
        Integer[] pair = new Integer[]{i, j};
        tracks.add(pair);

        int m = board.length;
        int n = board[0].length;

        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) flip = false;

        if (i > 0 && board[i - 1][j] == 'O') dfs(board, i - 1, j, visited, tracks);
        if (i < m - 1 && board[i + 1][j] == 'O') dfs(board, i + 1, j, visited, tracks);
        if (j > 0 && board[i][j - 1] == 'O') dfs(board, i, j - 1, visited, tracks);
        if (j < n - 1 && board[i][j + 1] == 'O') dfs(board, i, j + 1, visited, tracks);
    }
}
