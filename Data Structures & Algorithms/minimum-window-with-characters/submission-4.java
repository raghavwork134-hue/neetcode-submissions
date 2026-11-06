class Solution {
    public String minWindow(String s, String t) {
        
        // if(t.length() > s.length()){
        //     return "";
        // }

        // HashMap<Character,Integer> countT = new HashMap<>();
        // HashMap<Character,Integer> window = new HashMap<>();

        // for(int i = 0;i<t.length();i++){
        //     countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
        // }

        // int need = countT.size();
        // int have = 0;
        // int left = 0;
        // int minlength = Integer.MAX_VALUE;
        // int start = 0;

        // for(int right = 0;right<s.length();right++){
        //     char c = s.charAt(right);
        //     window.put(c,window.getOrDefault(c,0)+1);

        //     if(countT.containsKey(c) && 
        //     countT.get(c).intValue() == window.get(c).intValue()){
        //         have++;
        //     }

        //     while(have == need){
        //         if((right - left + 1) < minlength){
        //             minlength = right - left + 1;
        //             start = left;
        //         }

        //         char leftChar = s.charAt(left);

        //         window.put(leftChar,window.get(leftChar) - 1);

        //         left++;

        //         if(countT.containsKey(leftChar) && 
        //         window.get(leftChar) < countT.get(leftChar)){
        //             have--;
        //         }
        //     }
        // }

        // return minlength == Integer.MAX_VALUE ? "":
        // s.substring(start,start+minlength);


        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Using integer arrays for ASCII characters drastically optimizes execution speed
        int[] countT = new int[128];
        int[] window = new int[128];

        // 1. Correctly populate the frequency map using string t
        for (int i = 0; i < t.length(); i++) {
            countT[t.charAt(i)]++;
        }

        // Count unique characters in t that need to be matched
        int need = 0;
        for (int count : countT) {
            if (count > 0) need++;
        }

        int have = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        // 2. Expand the sliding window using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c]++;

            // If the character is required and its count matches target frequency
            if (countT[c] > 0 && window[c] == countT[c]) {
                have++;
            }

            // 3. Contract the window from the left when all criteria are met
            while (have == need) {
                // Update the minimum window metrics
                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                // If removing leftChar breaks the valid match criteria
                if (countT[leftChar] > 0 && window[leftChar] < countT[leftChar]) {
                    have--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
     }
}
