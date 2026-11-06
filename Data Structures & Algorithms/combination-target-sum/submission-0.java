class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();

        backtrack(nums, res, currCombination, target, 0);

        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res,
    List<Integer> currCombination, int target, int index){

        if(target == 0){
            res.add(new ArrayList<>(currCombination));
            return;
        }

        if(target < 0 || index == nums.length){
            return;
        }

        currCombination.add(nums[index]);
        backtrack(nums,res,currCombination,target - nums[index],index);

        currCombination.remove(currCombination.size() - 1);

        backtrack(nums,res,currCombination,target, index + 1);
    }
}
