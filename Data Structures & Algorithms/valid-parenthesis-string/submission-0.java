class Solution {
    public boolean checkValidString(String s) {
        
         int low = 0;
        int high = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                low++;
                high++;
            }
            else if (ch == ')') {
                low--;
                high--;
            }
            else { // '*'
                low--;
                high++;
            }

            // Minimum possible balance cannot be negative
            low = Math.max(0, low);

            // Even maximum possible balance is negative
            if (high < 0) {
                return false;
            }
        }

        // We need possibility of exactly zero open brackets
        return low == 0;
    }
}
