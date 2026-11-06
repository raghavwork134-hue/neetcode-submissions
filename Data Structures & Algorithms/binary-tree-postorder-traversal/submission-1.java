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
    public List<Integer> postorderTraversal(TreeNode root) {
        
            // postorder == left, right, root

    //     List<Integer> ans = new ArrayList<>();

    //     postorder(root,ans);

    //     return ans;
    // }

    // private void postorder(TreeNode root, List<Integer> ans){

    //     if(root == null){
    //         return;
    //     }

    //     postorder(root.left,ans);
    //     postorder(root.right,ans);
    //     ans.add(root.val);
    // }



                        // iterative approach
                        // 1
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> st = new Stack<>();

    TreeNode curr = root;

    while(curr != null || !st.isEmpty()){
        if(curr != null){
            ans.add(curr.val);
            st.push(curr);
            curr = curr.right;
        }
        else{
            curr = st.pop();
            curr = curr.left;
        }
        
    }
    Collections.reverse(ans);
    return ans;

    }
}