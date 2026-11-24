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
        // if i move left it's limit is [low,root.val];
        // if i move right it's limit is [root.val,high];
        return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean validate(TreeNode root,int low,int high) {
        if(root == null) {
            return true;
        }
        if(root.val <= low || root.val >= high) {
            return false; // basic
        }
        return validate(root.left,low,root.val) && validate(root.right,root.val,high);
    }
}
