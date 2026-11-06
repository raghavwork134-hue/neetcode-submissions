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
    public boolean isValidBST(TreeNode root) {
        
    //     return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }

    // private boolean validate(TreeNode root, long min, long max){

    //     if(root == null){
    //         return true;
    //     }

    //     if(root.val <= min || root.val >= max){
    //         return false;
    //     }

    //     return validate(root.left, min, root.val) && validate(root.right, root.val, max);
        List<Integer> list = new ArrayList<>();
        isValid(root, list);
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i)>=list.get(i+1))
            {
                return false;
            }
        }
        return true;
    }

    private void isValid(TreeNode root, List list)
    {
        //find inorder of tree;

        if(root == null)
        {
            return;
        }
        //left
        isValid(root.left, list);
        //middle -> address current node
        list.add(root.val);
        //right
        isValid(root.right, list);
    
    }
}
