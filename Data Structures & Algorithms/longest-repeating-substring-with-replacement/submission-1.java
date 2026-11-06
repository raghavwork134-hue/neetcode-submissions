class Solution {
    public int characterReplacement(String s, int k) {
        // // Array to store the frequency of each uppercase character (A-Z)
        // int[] frequencies = new int[26];
        
        // int maxLength = 0;
        // int maxFrequency = 0; // Tracks the highest frequency of any single character inside the current window
        // int left = 0;         // Left boundary of the window
        
        // for (int right = 0; right < s.length(); right++) {
        //     // Step 1: Add the current character to the frequency map
        //     char currentClass = s.charAt(right);
        //     frequencies[currentClass - 'A']++;
            
        //     // Step 2: Update the maximum frequency seen in the current window
        //     maxFrequency = Math.max(maxFrequency, frequencies[currentClass - 'A']);
            
        //     // Step 3: Check if the number of characters to replace exceeds k
        //     int windowLength = right - left + 1;
        //     int replacementsNeeded = windowLength - maxFrequency;
            
        //     if (replacementsNeeded > k) {
        //         // Shrink window from left: decrease frequency and move left pointer
        //         frequencies[s.charAt(left) - 'A']--;
        //         left++;
        //     }
            
        //     // Step 4: Track the maximum valid window size found
        //     maxLength = Math.max(maxLength, right - left + 1);
        // }
        
        // return maxLength;

        int[] freq = new int[26];

        int maxlen = 0;
        int left = 0;
        int maxfreq = 0;

        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxfreq = Math.max(maxfreq,freq[ch-'A']);

            int windowlen = right - left + 1;
            int replacementneed = windowlen - maxfreq;

            if(replacementneed > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}
