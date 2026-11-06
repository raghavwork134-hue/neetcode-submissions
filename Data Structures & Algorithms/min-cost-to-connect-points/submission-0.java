class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Minimum cost needed to connect each point
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // To check if a point is already included in MST
        boolean[] inMST = new boolean[n];

        // PriorityQueue: {cost, pointIndex}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Start from point 0
        pq.offer(new int[]{0, 0});
        minDist[0] = 0;

        int totalCost = 0;
        int pointsAdded = 0;

        while (pointsAdded < n) {
            int[] current = pq.poll();

            int cost = current[0];
            int point = current[1];

            // Ignore outdated entry
            if (inMST[point]) {
                continue;
            }

            // Add point to MST
            inMST[point] = true;
            totalCost += cost;
            pointsAdded++;

            // Check distance to every point not in MST
            for (int next = 0; next < n; next++) {

                if (!inMST[next]) {
                    int distance =
                        Math.abs(points[point][0] - points[next][0])
                        + Math.abs(points[point][1] - points[next][1]);

                    // If this is a cheaper way to connect next
                    if (distance < minDist[next]) {
                        minDist[next] = distance;
                        pq.offer(new int[]{distance, next});
                    }
                }
            }
        }

        return totalCost;
    }
}