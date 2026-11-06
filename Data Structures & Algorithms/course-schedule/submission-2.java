class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int pre = prerequisite[1];

            // pre -> course
            graph.get(pre).add(course);
        }

        // 0 = unvisited
        // 1 = currently visiting
        // 2 = completely processed
        int[] state = new int[numCourses];

        // Check every course
        for (int course = 0; course < numCourses; course++) {

            if (state[course] == 0) {
                if (hasCycle(course, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }


    private boolean hasCycle(int course, List<List<Integer>> graph,
     int[] state) {

        // Already in current DFS path -> cycle
        if (state[course] == 1) {
            return true;
        }

        // Already completely processed -> no need to process again
        if (state[course] == 2) {
            return false;
        }

        // Mark as currently visiting
        state[course] = 1;

        // Visit all next courses
        for (int nextCourse : graph.get(course)) {

            if (hasCycle(nextCourse, graph, state)) {
                return true;
            }
        }

        // DFS finished for this course
        state[course] = 2;

        return false;
    }

    // PRACTICE topological sort also , it can be used to detect cycles
    // in graph
}
