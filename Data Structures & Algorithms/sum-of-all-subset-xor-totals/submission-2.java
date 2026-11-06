class Solution {

    private int sum = 0;

    public int subsetXORSum(int[] nums) {
        
    //     dfs(nums,0,0);
    //     return sum;
    // }

    // private void dfs(int[] nums, int index, int currentxor){

    //     if(index == nums.length){
    //         sum += currentxor;
    //         return;
    //     }

    //     // include current no.
    //     dfs(nums,index+1,currentxor ^ nums[index]);

    //     // exclude current no.
    //     dfs(nums,index+1,currentxor);
    // }
    //                 // optimised
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            res |= nums[i];
        }

        return res << (nums.length - 1);
    }
}