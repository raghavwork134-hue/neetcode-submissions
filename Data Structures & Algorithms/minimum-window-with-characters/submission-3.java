class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()){
            return "";
        }

        HashMap<Character,Integer> countT = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i = 0;i<t.length();i++){
            countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
        }

        int need = countT.size();
        int have = 0;
        int left = 0;
        int minlength = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);

            if(countT.containsKey(c) && 
            countT.get(c).intValue() == window.get(c).intValue()){
                have++;
            }

            while(have == need){
                if((right - left + 1) < minlength){
                    minlength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar,window.get(leftChar) - 1);

                left++;

                if(countT.containsKey(leftChar) && 
                window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }
            }
        }

        return minlength == Integer.MAX_VALUE ? "":
        s.substring(start,start+minlength);
     }
}
