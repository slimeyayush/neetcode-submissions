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
        return helper(root,Integer.MAX_VALUE,Integer.MIN_VALUE); // so root doesn't say false
    }
    public boolean helper(TreeNode root,int maxYet,int minYet) {
        if(root == null) {
            return true;
        }
        boolean myAns = (root.val < maxYet) && (root.val > minYet);
        return myAns && helper(root.left,root.val,minYet) && helper(root.right,maxYet,root.val);
    }
}
