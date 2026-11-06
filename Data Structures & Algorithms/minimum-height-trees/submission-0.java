class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // Edge case: only one node
        if (n == 1) {
            return Arrays.asList(0);
        }

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Degree of every node
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        // Add all leaves to the queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        // Remove leaves layer by layer
        while (remainingNodes > 2) {

            int leaves = queue.size();

            remainingNodes -= leaves;

            // Remove the complete current layer
            for (int i = 0; i < leaves; i++) {

                int leaf = queue.poll();

                for (int neighbor : graph.get(leaf)) {

                    // Remove edge between leaf and neighbor
                    degree[neighbor]--;

                    // Neighbor becomes a new leaf
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Remaining 1 or 2 nodes are the answer
        return new ArrayList<>(queue);
    }
}