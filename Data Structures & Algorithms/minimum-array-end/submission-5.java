class Solution {
    public long minEnd(int n, int x) {
        
        long result = x;
        long k = n - 1L;

        int bit = 0;

        while (k > 0) {

            // Find the next zero bit in x
            while ((result & (1L << bit)) != 0) {
                bit++;
            }

            // If current bit of k is 1, set this zero bit
            if ((k & 1L) != 0) {
                result |= (1L << bit);
            }

            k >>= 1;
            bit++;
        }

        return result;
    }
}