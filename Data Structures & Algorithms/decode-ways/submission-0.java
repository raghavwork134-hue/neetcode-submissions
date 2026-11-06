class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // If the string starts with 0, no valid decoding
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n + 1];

        // One way to decode an empty string
        dp[0] = 1;

        // First character is already known to be non-zero
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            // Check one digit
            int oneDigit = s.charAt(i - 1) - '0';

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check two digits
            int twoDigit =
                (s.charAt(i - 2) - '0') * 10 +
                (s.charAt(i - 1) - '0');

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
