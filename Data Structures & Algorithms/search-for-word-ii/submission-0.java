class Solution {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private final int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from every cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(board, row, col, root, result);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
            }

            // Store complete word at the last node
            cur.word = word;
        }

        return root;
    }

    private void dfs(char[][] board, int row, int col,
                     TrieNode node, List<String> result) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char c = board[row][col];

        // Already visited OR no matching prefix in Trie
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        // Move to corresponding Trie node
        node = node.children[c - 'a'];

        // Found a complete word
        if (node.word != null) {
            result.add(node.word);

            // Avoid adding the same word again
            node.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore all 4 directions
        for (int[] dir : directions) {
            dfs(board,
                row + dir[0],
                col + dir[1],
                node,
                result);
        }

        // Backtrack: restore the cell
        board[row][col] = c;
    }
}