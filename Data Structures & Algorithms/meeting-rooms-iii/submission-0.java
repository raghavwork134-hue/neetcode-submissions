class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
         // Process meetings by original start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap of available room numbers
        PriorityQueue<Integer> available = new PriorityQueue<>();

        // Initially, all rooms are available
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // Busy rooms:
        // [endTime, roomNumber]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        // Number of meetings handled by each room
        int[] count = new int[n];

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];

            // Free every room whose meeting has already ended
            while (!busy.isEmpty() && busy.peek()[0] <= start) {

                long[] room = busy.poll();

                available.offer((int) room[1]);
            }

            // Case 1: At least one room is available
            if (!available.isEmpty()) {

                // Smallest numbered available room
                int room = available.poll();

                busy.offer(new long[]{end, room});

                count[room]++;
            }

            // Case 2: All rooms are busy
            else {

                // Room that becomes free earliest
                long[] room = busy.poll();

                long freeTime = room[0];
                int roomNumber = (int) room[1];

                // Original meeting duration
                long duration = end - start;

                // Meeting is delayed
                long newEnd = freeTime + duration;

                busy.offer(new long[]{newEnd, roomNumber});

                count[roomNumber]++;
            }
        }

        // Find room with maximum meetings
        // In case of tie, smaller room number wins
        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}