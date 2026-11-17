class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res,curr,nums,used);
        return res;
    }

    private void backtrack(List<List<Integer>> res,List<Integer> curr,
    int[] nums, boolean[] used){

        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        // Try every number
        for (int i = 0; i < nums.length; i++) {

            // Skip numbers already used
            if (used[i]) {
                continue;
            }

            // Choose
            curr.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(res,curr,nums,used);

            // Backtrack
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
