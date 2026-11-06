// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
        
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> curr = new ArrayList<>();
//         Arrays.sort(nums);
//         backtrack(nums, result, curr, 0);

//         return result;
//     }

//     private void backtrack(int[] nums, List<List<Integer>> result, 
//     List<Integer> curr, int start){

//         result.add(new ArrayList<>(curr));


//         for(int i = start;i<nums.length;i++){

//             if(i >start && nums[i] == nums[i-1]){
//                 continue;
//             }

//             curr.add(nums[i]);
//             backtrack(nums,result, curr, i + 1);

//             curr.remove(curr.size() - 1);
//         }
//     }
// }


public class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, i + 1, subset);
        subset.remove(subset.size() - 1);
        backtrack(nums, i + 1, subset);
    }
}