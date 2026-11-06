class Solution {
    public boolean isPalindrome(String s) {
        
int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Convert both valid characters to lowercase and compare
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Mismatch found
            }
            
            // Move both pointers closer to the center
            left++;
            right--;
        }
        
        return true; // No mismatches found, it's a valid palindrome    }
}}
