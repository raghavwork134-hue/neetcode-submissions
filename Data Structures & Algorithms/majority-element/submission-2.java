class Solution {
    public int majorityElement(int[] nums) {

                    // using sorting
        // Arrays.sort(nums);
        // return nums[nums.length/2];

                // 
        // int candidate = 0;
        // int count = 0;

        // for(int i = 0;i<nums.length;i++){
        //     if(count == 0){
        //         candidate = nums[i];
        //     }

        //     if(candidate == nums[i]){
        //         count++;
        //     }else{
        //         count--;
        //     }
        // }

        // return candidate;

        int cand = 0;
        int cnt = 0;
        for(int i = 0;i<nums.length;i++){
            if(cnt == 0){
                cand = nums[i];
            }
            if(nums[i] == cand){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        return cand;
    }
}