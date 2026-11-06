class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int component = 0;

        boolean[] visited = new boolean[n];

        for(int node = 0;node < n;node++){
            if(!visited[node]){
                component++;
                dfs(node,graph,visited);
            }
        }
        return component;
    }

    private void dfs(int node,List<List<Integer>> graph, 
        boolean[] visited){
            visited[node] = true;

            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    dfs(neighbor,graph,visited);
                }
            }
    }
}
