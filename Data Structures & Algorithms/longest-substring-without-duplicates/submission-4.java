class Solution {
    public int lengthOfLongestSubstring(String s) {

        // HashSet<Character> set = new HashSet<>();

        // int left = 0;
        // int maxLength = 0;

        // for (int right = 0; right < s.length(); right++) {

        //     while (set.contains(s.charAt(right))) {
        //         set.remove(s.charAt(left));
        //         left++;
        //     }

        //     set.add(s.charAt(right));

        //     maxLength = Math.max(maxLength,right - left + 1);
        // }

        // return maxLength;

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxlen = 0;
        for(int i = 0;i<s.length();i++){
            
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(i));
            maxlen = Math.max(maxlen,i-left+1);
        }
        return maxlen;


                        // using hashmap

        // HashMap<Character,Integer> map = new HashMap<>();

        // int left = 0;
        // int maxlen = 0;

        // for(int right = 0;right<s.length();right++){
        //     char ch = s.charAt(right);
        //     if(map.containsKey(ch)){
        //         left = Math.max(left,map.get(ch) + 1);
        //     }
        //     map.put(ch,right);
        //     maxlen = Math.max(maxlen,right - left + 1);
        // }

        // return maxlen;
    }
}
