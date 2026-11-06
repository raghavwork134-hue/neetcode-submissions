class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(n,k,1,res,current);

        return res;
    }

    private void backtrack(int n, int k, int start,
     List<List<Integer>> res, List<Integer> current){

        if(current.size() == k){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i<=n;i++){

            current.add(i);

            backtrack(n,k, i + 1, res, current);

            current.remove(current.size() - 1);
        }
     }
}