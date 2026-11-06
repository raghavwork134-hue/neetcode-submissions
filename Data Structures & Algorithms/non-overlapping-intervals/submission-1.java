class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals by ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] < prevEnd) {
                removals++;
            }

            // No overlap
            else {
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}