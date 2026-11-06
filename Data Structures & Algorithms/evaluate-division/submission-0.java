class Solution {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Build weighted graph
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            // a / b = value
            graph.get(a).put(b, value);

            // b / a = 1 / value
            graph.get(b).put(a, 1.0 / value);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);

            // Variable does not exist
            if (!graph.containsKey(source) ||
                !graph.containsKey(destination)) {

                result[i] = -1.0;

            } else if (source.equals(destination)) {

                // Example: a / a = 1
                result[i] = 1.0;

            } else {

                Set<String> visited = new HashSet<>();

                result[i] = dfs(
                    source,
                    destination,
                    1.0,
                    graph,
                    visited
                );
            }
        }

        return result;
    }


    private double dfs(
            String current,
            String destination,
            double product,
            Map<String, Map<String, Double>> graph,
            Set<String> visited) {

        // Reached destination
        if (current.equals(destination)) {
            return product;
        }

        visited.add(current);

        // Explore all neighbors
        for (Map.Entry<String, Double> neighbor
                : graph.get(current).entrySet()) {

            String next = neighbor.getKey();
            double weight = neighbor.getValue();

            if (!visited.contains(next)) {

                double answer = dfs(
                    next,
                    destination,
                    product * weight,
                    graph,
                    visited
                );

                // Valid path found
                if (answer != -1.0) {
                    return answer;
                }
            }
        }

        return -1.0;
    }
}