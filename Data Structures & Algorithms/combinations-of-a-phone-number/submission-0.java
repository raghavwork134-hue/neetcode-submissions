class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return res;
        }

        String[] phone = {
            "",         // 0
            "",         // 1
            "abc",      // 2
            "def",      // 3
            "ghi",      // 4
            "jkl",      // 5
            "mno",      // 6
            "pqrs",     // 7
            "tuv",      // 8
            "wxyz"      // 9
        };

        backtrack(0,digits,res,phone,new StringBuilder());

        return res;
    }

    private void backtrack(int index, String digits, List<String>res,
    String[] phone, StringBuilder curr){

        if(index == digits.length()){
            res.add(curr.toString());
            return;
        }


         // Current digit
        int digit = digits.charAt(index) - '0';

        // Letters mapped to the current digit
        String letters = phone[digit];

        // Try every letter
        for (char ch : letters.toCharArray()) {

            // Choose
            curr.append(ch);

            // Explore
            backtrack(index + 1, digits, res, phone, curr);

            // Backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
