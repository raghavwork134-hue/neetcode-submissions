class Solution {

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        // effort[r][c] = minimum effort needed to reach cell (r, c)
        int[][] effort = new int[rows][cols];

        // Initially, every cell has infinite effort
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Starting cell requires 0 effort
        effort[0][0] = 0;

        // {effort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, 0, 0});

        // Four directions
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentEffort = current[0];
            int row = current[1];
            int col = current[2];

            // Destination reached with minimum possible effort
            if (row == rows - 1 && col == cols - 1) {
                return currentEffort;
            }

            // Ignore outdated entries
            if (currentEffort > effort[row][col]) {
                continue;
            }

            // Explore all 4 neighbors
            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols) {

                    // Effort needed for this edge
                    int edgeDifference = Math.abs(
                        heights[row][col] - heights[newRow][newCol]
                    );

                    // Maximum effort on the complete path
                    int newEffort = Math.max(
                        currentEffort,
                        edgeDifference
                    );

                    // Found a better path
                    if (newEffort < effort[newRow][newCol]) {

                        effort[newRow][newCol] = newEffort;

                        pq.offer(new int[]{
                            newEffort,
                            newRow,
                            newCol
                        });
                    }
                }
            }
        }

        return 0;
    }
}