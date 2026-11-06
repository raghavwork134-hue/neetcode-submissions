class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length <= 1) return strs[0];

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];
        int n = Math.min(first.length(), last.length());
        int idx = 0;

        for(int i = 0;i<n;i++){
            if(first.charAt(i) != last.charAt(i)){
                return first.substring(0,i);
            }
            
            
        }

        return first;

    }
}