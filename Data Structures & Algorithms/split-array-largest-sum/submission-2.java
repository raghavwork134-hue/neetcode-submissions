class Solution {
    public int splitArray(int[] nums, int k) {
        
        int left = 0;
        int right = 0;

        // 1. Establish the search boundaries (max element and total sum)
        for (int i = 0;i<nums.length;i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }

        int ans = right;

        // 2. Binary Search Loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // --- Merged canSplit Logic ---
            int subarrayCount = 1;
            int currentSubarraySum = 0;
            boolean isValidLimit = true;

            for (int i = 0;i<nums.length;i++) {
                if (currentSubarraySum + nums[i] > mid) {
                    subarrayCount++;        // Start a new partition
                    currentSubarraySum = nums[i]; 
                } else {
                    currentSubarraySum += nums[i]; // Add to current partition
                }
            }
            
            // Check if the total partitions required exceed k
            if (subarrayCount > k) {
                isValidLimit = false;
            }
            // ------------------------------

            // 3. Adjust Binary Search boundaries based on the result
            if (isValidLimit) {
                ans = mid;        // 'mid' is valid, save it
                right = mid - 1;  // Try to find a smaller maximum sum limit
            } else {
                left = mid + 1;   // 'mid' is too tight/small, increase it
            }
        }

        return ans;
    }
}