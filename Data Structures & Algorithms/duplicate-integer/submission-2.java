class Solution {
    public boolean hasDuplicate(int[] nums) {

                    // brute force -- TC - O(n^2) SC- O(1)
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;

                        // TC -- O(nlogn) SC - O()
        // Arrays.sort(nums);
        // for(int i = 1;i<nums.length;i++){
        //     if(nums[i] == nums[i-1]){
        //         return true;
        //     }
        // }
        // return false;


                // optimised approach
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }
        return false;

    }
}