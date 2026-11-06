class Solution {

    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries
    ) {

        // isPrerequisite[i][j] = true
        // means course i is a prerequisite of course j
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Step 1: Mark direct prerequisites
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[0];
            int course = prerequisite[1];

            isPrerequisite[pre][course] = true;
        }

        // Step 2: Find all indirect prerequisites
        for (int k = 0; k < numCourses; k++) {

            for (int i = 0; i < numCourses; i++) {

                for (int j = 0; j < numCourses; j++) {

                    // If i -> k and k -> j,
                    // then i -> j
                    if (isPrerequisite[i][k] &&
                        isPrerequisite[k][j]) {

                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }

        // Step 3: Answer queries
        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            answer.add(isPrerequisite[u][v]);
        }

        return answer;
    }
}