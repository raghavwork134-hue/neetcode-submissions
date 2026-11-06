class Solution {
    public String minWindow(String s, String t) {

                        // without hashmap

        // if (s == null || t == null || s.length() < t.length()) return "";

        // int[] map = new int[128]; // 128 covers all ASCII characters
        // for (char c : t.toCharArray()) map[c]++;

        // int count = t.length(); // Number of characters yet to be matched
        // int start = 0, end = 0, minLen = Integer.MAX_VALUE, head = 0;

        // while (end < s.length()) {
        //     // If character at 'end' is in t, decrement count
        //     if (map[s.charAt(end++)]-- > 0) count--;

        //     // When window is valid, try to shrink from left
        //     while (count == 0) {
        //         if (end - start < minLen) {
        //             head = start;
        //             minLen = end - start;
        //         }
        //         // If character at 'start' was in t, increment count
        //         if (map[s.charAt(start++)]++ == 0) count++;
        //     }
        // }
        // return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
    


                    // with hashmap
                    
        //  if (t.length() > s.length()) {
        //     return "";
        // }

        // HashMap<Character, Integer> countT = new HashMap<>();
        // HashMap<Character, Integer> window = new HashMap<>();

        // for (char c : t.toCharArray()) {
        //     countT.put(c,
        //         countT.getOrDefault(c, 0) + 1);
        // }

        // int have = 0;
        // int need = countT.size();

        // int left = 0;

        // int minLen = Integer.MAX_VALUE;
        // int start = 0;

        // for (int right = 0; right < s.length(); right++) {

        //     char c = s.charAt(right);

        //     window.put(c,
        //         window.getOrDefault(c, 0) + 1);

        //     if (countT.containsKey(c) &&
        //         window.get(c).intValue() == countT.get(c).intValue()){

        //         have++;
        //     }

        //     while (have == need) {

        //         if ((right - left + 1) < minLen) {

        //             minLen = right - left + 1;
        //             start = left;
        //         }

        //         char leftChar = s.charAt(left);

        //         window.put(leftChar,
        //             window.get(leftChar) - 1);

        //         if (countT.containsKey(leftChar) &&
        //             window.get(leftChar) <
        //             countT.get(leftChar)) {

        //             have--;
        //         }

        //         left++;
        //     }
        // }

        // return minLen == Integer.MAX_VALUE
        //         ? ""
        //         : s.substring(start,
        //                       start + minLen);
    

        if(t.length() > s.length()){
            return "";
        }

        HashMap<Character,Integer> countT = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(char ch : t.toCharArray()){
            countT.put(ch,countT.getOrDefault(ch,0) + 1);
        } 

        int left = 0;
        int have = 0;
        int need = countT.size();
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0;right<s.length();right++){

            char c = s.charAt(right);

            window.put(c,window.getOrDefault(c,0)+1);

            if(countT.containsKey(c) && 
               window.get(c).intValue() == countT.get(c).intValue()){
                have++;
            }

            while(have == need){

                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar,window.get(leftChar)-1);

                if (countT.containsKey(leftChar) &&
                    window.get(leftChar) <
                    countT.get(leftChar)) {

                    have--;
                }

                left++;

            }
            
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start + minLen);


    }

                        
    
}
    