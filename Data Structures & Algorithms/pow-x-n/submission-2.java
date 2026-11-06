class Solution {
    public double myPow(double x, int n) {

                        // brute force
        // double result = 1;

        // for (int i = 0; i < n; i++) {
        //     result *= x;
        // }
        // return result;

        long exponent = n;

        // Handle negative exponent
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1.0;

        while (exponent > 0) {

            // If exponent is odd
            if (exponent % 2 == 1) {
                result *= x;
            }

            // Square the base
            x *= x;

            // Divide exponent by 2
            exponent /= 2;
        }

        return result;

    }
}
