class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int n = arr.length;

        if (n == 1) {
            return 1;
        }

        int currentLength = 1;
        int maxLength = 1;

        int previousSign = 0;

        for (int i = 1; i < n; i++) {

            int currentSign = Integer.compare(arr[i], arr[i - 1]);

            // Current comparison is opposite to previous comparison
            if (currentSign != 0 && currentSign == -previousSign) {
                currentLength++;
            }

            // Current comparison is different from previous
            else if (currentSign != 0) {
                currentLength = 2;
            }

            // Equal elements -> turbulence breaks
            else {
                currentLength = 1;
            }

            previousSign = currentSign;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;

    }
}