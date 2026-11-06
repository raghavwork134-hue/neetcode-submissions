class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }

        if(sum % k != 0){
            return false;
        }

        int target = sum / k;

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        // Largest element cannot fit
        if (nums[nums.length - 1] > target) {
            return false;
        }

        int[] subsets = new int[k];

        return backtrack(nums, nums.length - 1, subsets, target);
    }

    private boolean backtrack(int[] nums, int index,
                              int[] subsets, int target) {

        // All numbers have been placed successfully
        if (index < 0) {
            return true;
        }

        int num = nums[index];

        // Try placing current number into every subset
        for (int i = 0; i < subsets.length; i++) {

            // Skip equivalent states
            if (i > 0 && subsets[i] == subsets[i - 1]) {
                continue;
            }

            // Cannot exceed target
            if (subsets[i] + num > target) {
                continue;
            }

            // Choose
            subsets[i] += num;

            // Explore
            if (backtrack(nums, index - 1, subsets, target)) {
                return true;
            }

            // Undo
            subsets[i] -= num;
        }

        return false;

    }
}