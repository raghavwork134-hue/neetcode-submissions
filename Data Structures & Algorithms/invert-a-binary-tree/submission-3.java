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

class Solution {
    public TreeNode invertTree(TreeNode root) {
        
                // DFS
                
        // if (root == null){
        //     return root;
        // }

        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;

        // invertTree(root.left);
        // invertTree(root.right);

        // return root;

    //}

            // also look at iterative approach for dfs


                    // BFS 
    // if(root == null){
    //     return root;
    // }

    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);

    // while(!queue.isEmpty()){
    //     TreeNode node = queue.poll();

    //     TreeNode temp = node.left;
    //     node.left = node.right;
    //     node.right = temp;

    //     if(node.left != null){
    //         queue.offer(node.left);
    //     }

    //     if(node.right != null){
    //         queue.offer(node.right);
    //     }
    // }

    // return root;

    //}

        if(root == null){
            return null;
        }    
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        return root;
    }
}
