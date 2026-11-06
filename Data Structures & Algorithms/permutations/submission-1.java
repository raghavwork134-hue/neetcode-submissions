class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
    //     List<List<Integer>> result = new ArrayList<>();
    //     List<Integer> current = new ArrayList<>();
    //     boolean[] used = new boolean[nums.length];

    //     backtrack(nums, result, current, used);

    //     return result;

    // }

    // private void backtrack(int[] nums, List<List<Integer>> result,
    // List<Integer> current, boolean[] used){

    //     if(current.size() == nums.length){
    //         result.add(new ArrayList<>(current));
    //         return;
    //     }
        
    //     for(int i = 0;i<nums.length;i++){
            
    //         if(used[i]){
    //             continue;
    //         }
            
            
    //         current.add(nums[i]);
    //         used[i] = true;
    //         backtrack(nums, result, current, used);

    //         used[i] = false;
    //         current.remove(current.size() - 1);
    //     }
    // }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(res,curr,used,nums);
    return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> curr, boolean[] used, int[] nums){

        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(used[i]){
                continue;
            }

            curr.add(nums[i]);
            used[i] = true;
            backtrack(res,curr,used,nums);

            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
