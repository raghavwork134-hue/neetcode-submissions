class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] freq = new int[26];

        int left = 0;
        int maxlength = 0;
        int maxfreq = 0;

        for(int right = 0;right<s.length();right++){
            char curr = s.charAt(right);

            freq[curr - 'A']++;

            maxfreq = Math.max(maxfreq,freq[curr - 'A']);

            int windowlength = right - left + 1;
            int replacementneed = windowlength - maxfreq;

            if(replacementneed > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxlength = Math.max(maxlength, right - left + 1);

        }
        return maxlength;
    }
}
