class Solution {
    int rows;
    int cols;

    int[][] dp;

    int[][] directions = {
        {1, 0},   // down
        {-1, 0},  // up
        {0, 1},   // right
        {0, -1}   // left
    };

    public int longestIncreasingPath(int[][] matrix) {

        rows = matrix.length;
        cols = matrix[0].length;

        dp = new int[rows][cols];

        int answer = 0;

        // Try starting from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                answer = Math.max(
                    answer,
                    dfs(matrix, r, c)
                );
            }
        }

        return answer;
    }

    private int dfs(int[][] matrix, int r, int c) {

        // Already calculated
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        // Minimum path length is 1:
        // the current cell itself
        int best = 1;

        // Try all 4 directions
        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Check bounds
            if (nr < 0 || nr >= rows ||
                nc < 0 || nc >= cols) {
                continue;
            }

            // We can only move to a strictly larger value
            if (matrix[nr][nc] > matrix[r][c]) {

                best = Math.max(
                    best,
                    1 + dfs(matrix, nr, nc)
                );
            }
        }

        dp[r][c] = best;

        return best;
    }
}
