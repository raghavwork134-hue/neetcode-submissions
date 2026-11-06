class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        // Get valid ordering for rows
        List<Integer> rowOrder = topologicalSort(k, rowConditions);

        // Get valid ordering for columns
        List<Integer> colOrder = topologicalSort(k, colConditions);

        // If either ordering has a cycle
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0];
        }

        // Store the row position of every number
        int[] rowPosition = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPosition[rowOrder.get(i)] = i;
        }

        // Store the column position of every number
        int[] colPosition = new int[k + 1];

        for (int i = 0; i < k; i++) {
            colPosition[colOrder.get(i)] = i;
        }

        // Create answer matrix
        int[][] result = new int[k][k];

        // Place each number in its correct row and column
        for (int num = 1; num <= k; num++) {
            result[rowPosition[num]][colPosition[num]] = num;
        }

        return result;
    }


    private List<Integer> topologicalSort(int k, int[][] conditions) {

        // Graph: 1 to k
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[k + 1];

        // Build graph
        for (int[] condition : conditions) {

            int from = condition[0];
            int to = condition[1];

            graph.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Nodes with no dependency
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        // Kahn's Algorithm
        while (!queue.isEmpty()) {

            int current = queue.poll();
            order.add(current);

            for (int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }
}