class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n-1){
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        
        // Create Adjacency list
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
        
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Start DFS from node 0
        dfs(0, graph, visited);

        // Check whether all nodes were visited
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int node, List<List<Integer>> graph,
     boolean[] visited){

        visited[node] = true;

        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,graph,visited);
            }
        }
    }
}
