class Solution {
    public int countSubstrings(String s) {
    //     int count = 0;

    //     for (int i = 0; i < s.length(); i++) {

    //         // Odd length palindromes
    //         count += expandAroundCenter(s, i, i);

    //         // Even length palindromes
    //         count += expandAroundCenter(s, i, i + 1);
    //     }

    //     return count;
    // }

    // private int expandAroundCenter(String s, int left, int right) {
    //     int count = 0;

    //     while (left >= 0 &&
    //            right < s.length() &&
    //            s.charAt(left) == s.charAt(right)) {

    //         count++;

    //         left--;
    //         right++;
    //     }

    //     return count;
    // }

    int count = 0;
    for(int i = 0;i<s.length();i++){
        count += expand(s,i,i);
        count += expand(s,i,i+1);
    }
    return count;
    }
    private int expand(String s,int left,int right){
        int count = 0;
        while(left >= 0 && right < s.length() && 
                s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}


                        // brute force
// public class Solution {
//     public int countSubstrings(String s) {
//         int res = 0;

//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i; j < s.length(); j++) {
//                 int l = i, r = j;
//                 while (l < r && s.charAt(l) == s.charAt(r)) {
//                     l++;
//                     r--;
//                 }
//                 res += (l >= r) ? 1 : 0;
//             }
//         }

//         return res;
//     }
// }


                    // two pointer
// public class Solution {

//     public int countSubstrings(String s) {
//         int res = 0;
//         for (int i = 0; i < s.length(); i++) {
//             res += countPali(s, i, i);
//             res += countPali(s, i, i + 1);
//         }
//         return res;
//     }

//     private int countPali(String s, int l, int r) {
//         int res = 0;
//         while (l >= 0 && r < s.length() &&
//                s.charAt(l) == s.charAt(r)) {
//             res++;
//             l--;
//             r++;
//         }
//         return res;
//     }
// }