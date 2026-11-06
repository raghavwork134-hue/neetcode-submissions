/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        dfsSerialize(root, sb);

        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");

        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    
    }

    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");

        index = 0;

        return dfsDeserialize(arr);
    }

    private TreeNode dfsDeserialize(String[] arr) {

        if (arr[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;

        root.left = dfsDeserialize(arr);

        root.right = dfsDeserialize(arr);

        return root;
    
    }
}
