class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: Top and Left borders
        for (int col = 0; col < cols; col++) {
            dfs(0, col, heights, pacific);
        }

        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights, pacific);
        }

        // Atlantic: Bottom and Right borders
        for (int col = 0; col < cols; col++) {
            dfs(rows - 1, col, heights, atlantic);
        }

        for (int row = 0; row < rows; row++) {
            dfs(row, cols - 1, heights, atlantic);
        }

        // Find cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }


    private void dfs(int row, int col, int[][] heights,
                     boolean[][] visited) {

        visited[row][col] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check boundaries
            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            // Already visited
            if (visited[newRow][newCol]) {
                continue;
            }

            // Reverse flow:
            // Move only to equal or higher height
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, heights, visited);
        }
    }
}