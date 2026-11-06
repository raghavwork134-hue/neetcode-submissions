class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        

        // Sort intervals by their left endpoint
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store queries with their original index
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i]; // query value
            sortedQueries[i][1] = i;          // original index
        }

        // Sort queries by value
        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap:
        // [interval length, right endpoint]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] result = new int[queries.length];

        int i = 0;

        for (int[] query : sortedQueries) {

            int q = query[0];
            int originalIndex = query[1];

            // Add all intervals that have started
            while (i < intervals.length &&
                   intervals[i][0] <= q) {

                int left = intervals[i][0];
                int right = intervals[i][1];

                int length = right - left + 1;

                minHeap.offer(new int[]{length, right});

                i++;
            }

            // Remove intervals that have already ended
            while (!minHeap.isEmpty() &&
                   minHeap.peek()[1] < q) {

                minHeap.poll();
            }

            // Smallest valid interval
            if (!minHeap.isEmpty()) {
                result[originalIndex] = minHeap.peek()[0];
            } else {
                result[originalIndex] = -1;
            }
        }

        return result;

    }
}
