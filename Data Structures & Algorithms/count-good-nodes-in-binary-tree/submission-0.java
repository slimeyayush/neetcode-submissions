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
    int goodNodes = 0;
    
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int maxYet = Integer.MIN_VALUE;
        if(root.val > maxYet) {
            goodNodes++;
            maxYet = Math.max(maxYet,root.val);
        }
        helper(root.left,maxYet);
        helper(root.right,maxYet);

        return goodNodes;

    }
    public void helper(TreeNode root,int maxYet) {
           if(root == null) {
            return;
           }
           if(root.val >= maxYet) {
             goodNodes++;
             maxYet = root.val;
           }
           helper(root.left,maxYet);
           helper(root.right,maxYet);
    }

}
