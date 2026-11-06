class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, curr, 0);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, 
    List<Integer> curr, int start){

        result.add(new ArrayList<>(curr));


        for(int i = start;i<nums.length;i++){

            if(i >start && nums[i] == nums[i-1]){
                continue;
            }

            curr.add(nums[i]);
            backtrack(nums,result, curr, i + 1);

            curr.remove(curr.size() - 1);
        }
    }
}
