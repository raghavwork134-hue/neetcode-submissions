class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<>();

        Set<String> dictionary = new HashSet<>(wordDict);
        List<String> currentSentence = new ArrayList<>();

        backtrack(0, s, dictionary, currentSentence, result);

        return result;
    }

    private void backtrack(
            int start,
            String s,
            Set<String> dictionary,
            List<String> currentSentence,
            List<String> result) {

        // Base case: poori string process ho gayi
        if (start == s.length()) {
            result.add(String.join(" ", currentSentence));
            return;
        }

        // Current index se har possible substring try karo
        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            // Agar dictionary mein nahi hai, skip
            if (!dictionary.contains(word)) {
                continue;
            }

            // CHOOSE
            currentSentence.add(word);

            // EXPLORE
            backtrack(end, s, dictionary, currentSentence, result);

            // UNDO
            currentSentence.remove(currentSentence.size() - 1);
        }
    }
}