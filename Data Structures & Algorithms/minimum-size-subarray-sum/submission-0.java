class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0; // Left boundary of the sliding window
        
        for (int right = 0; right < nums.length; right++) {
            // Step 1: Add the current element to expand our window
            currentSum += nums[right];
            
            // Step 2: Shrink the window from the left as long as the condition holds true
            while (currentSum >= target) {
                // Update the minimal length found so far
                minLength = Math.min(minLength, right - left + 1);
                
                // Subtract the element leaving the window and move left pointer forward
                currentSum -= nums[left];
                left++;
            }
        }
        
        // If minLength was never updated, it means no valid subarray exists
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}