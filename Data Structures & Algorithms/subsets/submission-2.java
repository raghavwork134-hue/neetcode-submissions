class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(res,curr,nums,0);

        return res;
    }

    private void dfs(List<List<Integer>> res,List<Integer> curr, 
                    int[] nums,int index){
        
        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        dfs(res,curr,nums,index+1);
        curr.remove(curr.size() - 1);
        dfs(res,curr,nums,index + 1);

    }
}
