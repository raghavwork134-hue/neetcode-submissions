// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
        
//         List<List<Integer>> res= new ArrayList<>();
//         List<Integer> current = new ArrayList<>();
        
//         backtrack(n,k,1,res,current);

//         return res;
//     }

//     private void backtrack(int n, int k, int start,
//      List<List<Integer>> res, List<Integer> current){

//         if(current.size() == k){
//             res.add(new ArrayList<>(current));
//             return;
//         }

//         for(int i = start; i<=n;i++){

//             current.add(i);

//             backtrack(n,k, i + 1, res, current);

//             current.remove(current.size() - 1);
//         }
//      }
// }


public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int n, int k, List<Integer> comb) {
        if (i > n) {
            if (comb.size() == k) {
                res.add(new ArrayList<>(comb));
            }
            return;
        }

        comb.add(i);
        backtrack(i + 1, n, k, comb);
        comb.remove(comb.size() - 1);
        backtrack(i + 1, n, k, comb);
    }
}