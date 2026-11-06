class Solution {
    public int findDuplicate(int[] nums) {
        
        // Arrays.sort(nums);
        // for(int i = 1;i<nums.length;i++){
        //     if(nums[i] == nums[i-1]){
        //         return nums[i];
        //     }
        // }
        // return -1;

        // HashSet<Integer> set = new HashSet<>();

        // for(int i = 0;i<nums.length;i++){
        //     if(set.contains(nums[i])){
        //         return nums[i];
        //     }
        //     set.add(nums[i]);
        // }
        // return -1;


        //  slow - fast pointer approach
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        slow = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast){
                return slow;
            }
        }


    }
}
