class Solution {

    private Map<String, PriorityQueue<String>> graph;
    private List<String> itinerary;

    public List<String> findItinerary(List<List<String>> tickets) {

        graph = new HashMap<>();
        itinerary = new ArrayList<>();

        // Step 1: Build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph
                .computeIfAbsent(from, key -> new PriorityQueue<>())
                .offer(to);
        }

        // Step 2: Start from JFK
        dfs("JFK");

        // Step 3: Reverse because nodes were added during backtracking
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(String airport) {

        // Use all outgoing tickets
        while (graph.containsKey(airport) &&
               !graph.get(airport).isEmpty()) {

            String nextAirport = graph.get(airport).poll();

            dfs(nextAirport);
        }

        // Add airport only after using all its tickets
        itinerary.add(airport);
    }
}