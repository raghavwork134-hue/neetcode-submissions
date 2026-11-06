class Solution {
    public String foreignDictionary(String[] words) {
        // Adjacency list
        Map<Character, Set<Character>> graph = new HashMap<>();

        // Indegree of every character
        Map<Character, Integer> indegree = new HashMap<>();

        // Step 1: Add all unique characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Step 2: Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            // Invalid prefix case
            if (word1.length() > word2.length()
                    && word1.startsWith(word2)) {
                return "";
            }

            // Compare characters
            int minLength = Math.min(
                word1.length(),
                word2.length()
            );

            for (int j = 0; j < minLength; j++) {

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                // First different character gives the ordering
                if (c1 != c2) {

                    // Avoid duplicate edge
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }

                    // Only first difference matters
                    break;
                }
            }
        }

        // Step 3: Add all characters with indegree 0
        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        // Step 4: Topological Sort - Kahn's Algorithm
        while (!queue.isEmpty()) {

            char current = queue.poll();
            result.append(current);

            for (char neighbor : graph.get(current)) {

                indegree.put(
                    neighbor,
                    indegree.get(neighbor) - 1
                );

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 5: Cycle detection
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }

}

