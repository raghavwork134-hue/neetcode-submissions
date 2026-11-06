class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
    //     List<List<Integer>> ans = new ArrayList<>();
    //     List<Integer> currentSubset = new ArrayList<>();
    //     set(ans,currentSubset,nums,0);
    //     return ans;
    // }

    // private void set(List<List<Integer>> ans, 
    // List<Integer> currentSubset, 
    // int[] nums, int index){

    //     if(index == nums.length){
    //         ans.add(new ArrayList<>(currentSubset));
    //         return;
    //     }

    //     currentSubset.add(nums[index]);
    //     set(ans,currentSubset,nums, index + 1);

    //     currentSubset.remove(currentSubset.size() - 1);
    //     set(ans,currentSubset,nums,index+1);
    // }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> currset = new ArrayList<>();
    set(nums,ans,currset,0);
    return ans;
    }
    private void set(int[] nums,List<List<Integer>> ans, 
                    List<Integer> currset,int index){
        
        if(index == nums.length){
            ans.add(new ArrayList<>(currset));
            return;
        }

        currset.add(nums[index]);
        set(nums,ans,currset,index+1);
        currset.remove(currset.size() - 1);
        set(nums,ans,currset,index+1);
    }
}
