class Solution {
    public String minWindow(String s, String t) {
    
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] map = new int[128]; // 128 covers all ASCII characters
        for (char c : t.toCharArray()) map[c]++;

        int count = t.length(); // Number of characters yet to be matched
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, head = 0;

        while (end < s.length()) {
            // If character at 'end' is in t, decrement count
            if (map[s.charAt(end++)]-- > 0) count--;

            // When window is valid, try to shrink from left
            while (count == 0) {
                if (end - start < minLen) {
                    head = start;
                    minLen = end - start;
                }
                // If character at 'start' was in t, increment count
                if (map[s.charAt(start++)]++ == 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
    }
}
    