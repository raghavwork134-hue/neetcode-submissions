class Solution {
    public List<String> generateParenthesis(int n) {
        
    //     List<String> res = new ArrayList<>();

    //     backtrack(n,0,0,new StringBuilder(), res);

    //     return res;
    // }

    // private void backtrack(int n, int open, int close, 
    // StringBuilder current, List<String> res){

    //     if(open == n && close == n){
    //         res.add(current.toString());
    //         return;
    //     }

    //     if(open < n){
    //         current.append('(');
    //         backtrack(n,open + 1,close,current,res);
    //         current.deleteCharAt(current.length() - 1);
    //     }

    //     if(close < open){
    //         current.append(')');
    //         backtrack(n,open,close + 1,current,res);
    //         current.deleteCharAt(current.length() - 1);
    //     }
    // }

    List<String> res = new ArrayList<>();
    StringBuilder curr = new StringBuilder();
    backtrack(res,curr,n,0,0);
    return res;
    }
    private void backtrack(List<String> res,StringBuilder curr,int n,
    int open,int close){

        if(open == n && close == n){
            res.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append("(");
            backtrack(res,curr,n,open+1,close);
            curr.deleteCharAt(curr.length() - 1);
        }
        if(close < open){
            curr.append(")");
            backtrack(res,curr,n,open,close+1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
