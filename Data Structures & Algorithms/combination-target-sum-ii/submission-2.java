class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,curr,candidates,target,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res,List<Integer> curr,
    int[] candidates,int target,int start){

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate values at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted, no later element can work
            if (candidates[i] > target) {
                break;
            }

            // Choose
            curr.add(candidates[i]);

            // i + 1 because each element can be used only once
            backtrack(res,curr,candidates,target-candidates[i],i + 1);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}
