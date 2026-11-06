class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }

            cur = cur.children[i];
        }

        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {

        // Base case: processed all characters
        if (index == word.length()) {
            return node.endOfWord;
        }

        char c = word.charAt(index);

        // Case 1: Normal character
        if (c != '.') {
            int i = c - 'a';

            if (node.children[i] == null) {
                return false;
            }

            return dfs(word, index + 1, node.children[i]);
        }

        // Case 2: '.' can match any character
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null &&
                dfs(word, index + 1, node.children[i])) {
                return true;
            }
        }

        return false;
    }
}
