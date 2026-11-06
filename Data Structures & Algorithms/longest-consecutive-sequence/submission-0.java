class Solution {
    public int longestConsecutive(int[] nums) {
        // Base case: If array is empty, longest sequence length is 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Add all numbers to a HashSet
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestStreak = 0;

        // Step 2: Traverse through the array using a normal loop
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            // Check if currentNum is the starting point of a sequence
            // It is a start only if (currentNum - 1) does not exist in the set
            if (!numSet.contains(currentNum - 1)) {
                int currentNumInStreak = currentNum;
                int currentStreak = 1;

                // Step 3: Incrementally look for consecutive numbers
                while (numSet.contains(currentNumInStreak + 1)) {
                    currentNumInStreak++;
                    currentStreak++;
                }

                // Update the maximum streak found so far
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            }
        }

        return longestStreak;
    }
}
