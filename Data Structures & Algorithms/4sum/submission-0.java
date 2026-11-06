class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Base condition
        if (nums == null || n < 4) {
            return result;
        }
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Loop for the first element
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Step 3: Loop for the second element
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Step 4: Two-pointer approach for the remaining two elements
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Move pointers past duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Sum is too small, move left pointer rightward
                    } else {
                        right--; // Sum is too large, move right pointer leftward
                    }
                }
            }
        }
        
        return result;
    
    }
}