class Solution {

    public int openLock(String[] deadends, String target) {

        // Store all deadends
        Set<String> dead = new HashSet<>();

        for (String code : deadends) {
            dead.add(code);
        }

        String start = "0000";

        // If starting state is blocked
        if (dead.contains(start)) {
            return -1;
        }

        // If target is already the starting state
        if (start.equals(target)) {
            return 0;
        }

        // BFS queue
        Queue<String> queue = new LinkedList<>();

        // Visited states
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int turns = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one complete BFS level
            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // Check all 8 possible next states
                for (String next : getNextStates(current)) {

                    // Skip deadend or already visited state
                    if (dead.contains(next) || visited.contains(next)) {
                        continue;
                    }

                    // Target found
                    if (next.equals(target)) {
                        return turns + 1;
                    }

                    visited.add(next);
                    queue.offer(next);
                }
            }

            // Completed one level = one turn
            turns++;
        }

        return -1;
    }


    private List<String> getNextStates(String code) {

        List<String> nextStates = new ArrayList<>();

        char[] chars = code.toCharArray();

        // Try rotating each of the 4 wheels
        for (int i = 0; i < 4; i++) {

            char original = chars[i];

            // Rotate forward
            chars[i] = original == '9'
                    ? '0'
                    : (char)(original + 1);

            nextStates.add(new String(chars));

            // Rotate backward
            chars[i] = original == '0'
                    ? '9'
                    : (char)(original - 1);

            nextStates.add(new String(chars));

            // Restore original digit
            chars[i] = original;
        }

        return nextStates;
    }
}