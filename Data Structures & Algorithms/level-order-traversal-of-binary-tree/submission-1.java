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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // List<List<Integer>> ans = new ArrayList<>();

        // if(root == null){
        //     return ans;
        // }

        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);

        // while(!queue.isEmpty()){

        //     int size = queue.size();

        //     List<Integer> level = new ArrayList<>();

        //     for(int i = 0;i<size;i++){

        //         TreeNode curr = queue.poll();
        //         level.add(curr.val);

        //         if(curr.left != null){
        //             queue.offer(curr.left);
        //         }

        //         if(curr.right != null){
        //             queue.offer(curr.right);
        //         }
        //     }

        //     ans.add(level);
        // }

        // return ans;

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> level = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
