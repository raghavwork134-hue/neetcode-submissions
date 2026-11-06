class Solution {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
            int n, int[][] edges) {

        int m = edges.length;

        // [u, v, weight, originalIndex]
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        // Sort edges according to weight
        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        // Find original MST weight
        int originalMST = kruskal(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            // Test 1: Exclude edge i
            int excludeWeight = kruskal(n, newEdges, i, -1);

            if (excludeWeight > originalMST) {
                critical.add(newEdges[i][3]);
            } else {

                // Test 2: Force include edge i
                int includeWeight = kruskal(n, newEdges, -1, i);

                if (includeWeight == originalMST) {
                    pseudoCritical.add(newEdges[i][3]);
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(critical);
        answer.add(pseudoCritical);

        return answer;
    }

    private int kruskal(int n, int[][] edges,
                        int skipEdge, int forceEdge) {

        DSU dsu = new DSU(n);

        int weight = 0;
        int edgesUsed = 0;

        // Force include an edge first
        if (forceEdge != -1) {
            int[] edge = edges[forceEdge];

            dsu.union(edge[0], edge[1]);
            weight += edge[2];
            edgesUsed++;
        }

        // Normal Kruskal
        for (int i = 0; i < edges.length; i++) {

            // Skip excluded edge
            if (i == skipEdge) {
                continue;
            }

            // Already forced this edge
            if (i == forceEdge) {
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (dsu.union(u, v)) {
                weight += w;
                edgesUsed++;
            }
        }

        // MST must have n - 1 edges
        if (edgesUsed != n - 1) {
            return Integer.MAX_VALUE;
        }

        return weight;
    }

    static class DSU {

        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        boolean union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            // Same component -> cycle
            if (rootA == rootB) {
                return false;
            }

            // Union by rank
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            return true;
        }
    }
}