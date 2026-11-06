class Solution {

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // dist[r][c] = minimum time needed to reach (r, c)
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {time, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int time = current[0];
            int row = current[1];
            int col = current[2];

            // Ignore outdated entry
            if (time > dist[row][col]) {
                continue;
            }

            // Reached destination
            if (row == n - 1 && col == n - 1) {
                return time;
            }

            // Explore 4 directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow < 0 || newRow >= n ||
                    newCol < 0 || newCol >= n) {
                    continue;
                }

                // Maximum elevation encountered on this path
                int newTime = Math.max(
                    time,
                    grid[newRow][newCol]
                );

                // Found a better path
                if (newTime < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newTime;

                    pq.offer(new int[]{
                        newTime,
                        newRow,
                        newCol
                    });
                }
            }
        }

        return -1;
    }
}