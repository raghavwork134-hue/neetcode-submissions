/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // Sort meetings by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // Min heap stores end times of ongoing meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // First meeting
        minHeap.offer(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {

            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;

            // If the earliest room becomes free,
            // reuse that room
            if (currentStart >= minHeap.peek()) {
                minHeap.poll();
            }

            // Add current meeting's end time
            minHeap.offer(currentEnd);
        }

        return minHeap.size();
    }
}