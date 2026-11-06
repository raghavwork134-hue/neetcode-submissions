class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        set(ans,res,nums,0);
        return ans;
    }

    private void set(List<List<Integer>> ans, List<Integer> res, 
    int[] nums, int index){

        if(index == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        set(ans,res,nums, index + 1);

        res.remove(res.size() - 1);
        set(ans,res,nums,index+1);
    }
}
