class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        // Nodes are from 1 to n
        int[] parent = new int[n + 1];

        // Initially, every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u, parent);
            int rootV = find(v, parent);

            // Already in the same component
            // Adding this edge creates a cycle
            if (rootU == rootV) {
                return edge;
            }

            // Otherwise, connect the two components
            parent[rootU] = rootV;
        }

        return new int[0];
    }

    private int find(int node, int[] parent) {

        // If node is not its own parent,
        // recursively find the root
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }

        return parent[node];
    
    }
}
