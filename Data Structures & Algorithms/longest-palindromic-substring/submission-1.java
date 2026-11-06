class Solution {
    public String longestPalindrome(String s) {
    //     int n = s.length();

    //     int start = 0;
    //     int end = 0;

    //     for (int i = 0; i < n; i++) {

    //         // Odd length palindrome
    //         int len1 = expandAroundCenter(s, i, i);

    //         // Even length palindrome
    //         int len2 = expandAroundCenter(s, i, i + 1);

    //         int len = Math.max(len1, len2);

    //         if (len > end - start + 1) {
    //             start = i - (len - 1) / 2;
    //             end = i + len / 2;
    //         }
    //     }

    //     return s.substring(start, end + 1);
    // }

    // private int expandAroundCenter(String s, int left, int right) {

    //     while (left >= 0 &&
    //            right < s.length() &&
    //            s.charAt(left) == s.charAt(right)) {

    //         left--;
    //         right++;
    //     }

    //     return right - left - 1;
    
    // }

    int n = s.length();
    int start = 0;
    int end = 0;
    for(int i = 0;i<n;i++){
        int len1 = expand(s,i,i);
        int len2 = expand(s,i,i+1);
        int len = Math.max(len1,len2);
        if(len > end - start + 1){
            start = i - (len-1)/2;
            end = i + len/2;
        }
    }
    return s.substring(start,end+1);
    }
    private int expand(String s,int left,int right){
        while(left >= 0 && right < s.length() && 
              s.charAt(left) == s.charAt(right)){
                left--;
                right++;
        }
        return right-left-1;
    }
}

                // brute force
// public class Solution {
//     public String longestPalindrome(String s) {
//         String res = "";
//         int resLen = 0;

//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i; j < s.length(); j++) {
//                 int l = i, r = j;
//                 while (l < r && s.charAt(l) == s.charAt(r)) {
//                     l++;
//                     r--;
//                 }

//                 if (l >= r && resLen < (j - i + 1)) {
//                     res = s.substring(i, j + 1);
//                     resLen = j - i + 1;
//                 }
//             }
//         }

//         return res;
//     }
// }
