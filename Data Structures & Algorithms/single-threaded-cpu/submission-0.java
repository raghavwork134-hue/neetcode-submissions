class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // [enqueueTime, processingTime, originalIndex]
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] answer = new int[n];

        int idx = 0;
        int ansIndex = 0;

        long currentTime = 0;

        while (idx < n || !minHeap.isEmpty()) {

            // If no task is available, jump to next arrival
            if (minHeap.isEmpty() && currentTime < arr[idx][0]) {
                currentTime = arr[idx][0];
            }

            // Add all available tasks
            while (idx < n && arr[idx][0] <= currentTime) {
                minHeap.offer(arr[idx]);
                idx++;
            }

            int[] task = minHeap.poll();

            answer[ansIndex++] = task[2];

            currentTime += task[1];
        }

        return answer;
    }
}