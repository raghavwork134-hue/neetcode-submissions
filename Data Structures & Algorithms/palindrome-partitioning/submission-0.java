class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(res,curr,s,0);

        return res;
    }

    private void backtrack(List<List<String>> res, List<String> curr,
    String s, int start){

        if(start == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start;i<s.length();i++){

            if(isPalindrome(s,start,i)){

                curr.add(s.substring(start,i+1));

                backtrack(res,curr,s,i + 1);

                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
