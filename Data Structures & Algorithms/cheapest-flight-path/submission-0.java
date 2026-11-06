class Solution {

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        int INF = Integer.MAX_VALUE / 2;

        // dist[i] = minimum cost to reach airport i
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        // Cost to reach source is 0
        dist[src] = 0;

        // k stops means at most k + 1 flights
        for (int i = 0; i <= k; i++) {

            // Important: use a copy
            int[] temp = dist.clone();

            // Relax every flight
            for (int[] flight : flights) {

                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // If 'from' is reachable
                if (dist[from] != INF) {

                    temp[to] = Math.min(
                        temp[to],
                        dist[from] + price
                    );
                }
            }

            dist = temp;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}