class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
int len1 = s1.length();
        int len2 = s2.length();
        
        // Base case: If s1 is longer than s2, s2 cannot contain a permutation of s1
        if (len1 > len2) {
            return false;
        }
        
        // Frequency arrays for s1 and the sliding window of s2
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        
        // Initialize the first window
        for (int i = 0; i < len1; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        
        // If the initial window matches, we found a permutation
        if (Arrays.equals(s1Freq, s2Freq)) {
            return true;
        }
        
        // Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Add the new character entering the window from the right
            s2Freq[s2.charAt(i) - 'a']++;
            
            // Remove the old character leaving the window from the left
            s2Freq[s2.charAt(i - len1) - 'a']--;
            
            // Check if the updated window matches s1's frequencies
            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }
        }
        
        return false;

    }
}
