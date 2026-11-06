class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // times[i] = [source, destination, time]
        for (int[] edge : times) {
            int source = edge[0];
            int destination = edge[1];
            int time = edge[2];

            graph.get(source).add(new int[]{destination, time});
        }

        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Min Heap: {time, node}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, k});

        // Step 3: Dijkstra
        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentTime = current[0];
            int node = current[1];

            // Skip outdated entry
            if (currentTime > dist[node]) {
                continue;
            }

            // Explore all neighbors
            for (int[] neighbor : graph.get(node)) {

                int nextNode = neighbor[0];
                int travelTime = neighbor[1];

                int newTime = currentTime + travelTime;

                // Relaxation
                if (newTime < dist[nextNode]) {

                    dist[nextNode] = newTime;

                    pq.offer(new int[]{newTime, nextNode});
                }
            }
        }

        // Step 4: Find maximum shortest distance
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            // If any node is unreachable
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}