// class PrefixTree {

//     public class TrieNode {
//         TrieNode[] children = new TrieNode[26];
//         boolean endOfWord = false;
//     }

//     private TrieNode root;

//     public PrefixTree() {
//         root = new TrieNode();
//     }

//     public void insert(String word) {
//         TrieNode cur = root;
//         for (char c : word.toCharArray()) {
//             int i = c - 'a';
//             if (cur.children[i] == null) {
//                 cur.children[i] = new TrieNode();
//             }
//             cur = cur.children[i];
//         }
//         cur.endOfWord = true;
//     }

//     public boolean search(String word) {
//         TrieNode cur = root;
//         for (char c : word.toCharArray()) {
//             int i = c - 'a';
//             if (cur.children[i] == null) {
//                 return false;
//             }
//             cur = cur.children[i];
//         }
//         return cur.endOfWord;
//     }

//     public boolean startsWith(String prefix) {
//         TrieNode cur = root;
//         for (char c : prefix.toCharArray()) {
//             int i = c - 'a';
//             if (cur.children[i] == null) {
//                 return false;
//             }
//             cur = cur.children[i];
//         }
//         return true;
//     }
// }



class PrefixTree {

    // Node of the Trie
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    // Initialize Trie
    public PrefixTree() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            // Create node if it doesn't exist
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            // Move to the next node
            node = node.children[index];
        }

        // Mark the end of the complete word
        node.isEndOfWord = true;
    }

    // Search for a complete word
    public boolean search(String word) {
        TrieNode node = findNode(word);

        return node != null && node.isEndOfWord;
    }

    // Check whether any word starts with the given prefix
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // Helper method to traverse the Trie
    private TrieNode findNode(String str) {
        TrieNode node = root;

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';

            // Character path does not exist
            if (node.children[index] == null) {
                return null;
            }

            node = node.children[index];
        }

        return node;
    }
}


