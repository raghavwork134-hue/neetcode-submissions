class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree[i] = number of prerequisites of course i
        int[] indegree = new int[numCourses];


        // Step 2: Build graph
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int pre = prerequisite[1];

            // pre must be taken before course
            // So: pre -> course
            graph.get(pre).add(course);

            // course has one more prerequisite
            indegree[course]++;
        }


        // Step 3: Add all courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }


        // This will store our topological order
        int[] order = new int[numCourses];

        int index = 0;


        // Step 4: BFS / Kahn's Algorithm
        while (!queue.isEmpty()) {

            int current = queue.poll();

            // Add current course to answer
            order[index++] = current;


            // Process all courses depending on current
            for (int next : graph.get(current)) {

                // One prerequisite has been completed
                indegree[next]--;


                // All prerequisites completed
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }


        // If all courses were processed, valid order exists
        if (index == numCourses) {
            return order;
        }


        // Cycle exists, impossible to finish all courses
        return new int[0];
    }
}