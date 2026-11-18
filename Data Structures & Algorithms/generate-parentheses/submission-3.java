class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb,res,n,0,0);

        return res;
    }

    private void helper(StringBuilder sb,List<String> res,int n,
    int open,int close){

        if(open == n && close == n ){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            helper(sb,res,n,open+1,close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(")");
            helper(sb,res,n,open,close+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
