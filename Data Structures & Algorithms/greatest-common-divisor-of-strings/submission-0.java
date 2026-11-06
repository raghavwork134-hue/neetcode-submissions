class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        // If they don't have the same repeating pattern,
        // no common divisor exists.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());

        // The answer is the prefix of length gcdLength.
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}