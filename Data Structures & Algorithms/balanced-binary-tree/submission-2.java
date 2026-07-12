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
    public class Pair {
        int height;
        boolean isBal;

        Pair(int height,boolean isBal) {
            this.height = height;
            this.isBal = isBal;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBal;
    }
    public Pair helper(TreeNode root) {
        if(root == null) {
            // null means balanced 
            return new Pair(0,true);
        }
        Pair leftAns = helper(root.left);
        Pair rightAns = helper(root.right);

        boolean amIBalanced = (Math.abs(leftAns.height-rightAns.height) <= 1) && leftAns.isBal && rightAns.isBal;
        int myHeight = 1 + Math.max(leftAns.height,rightAns.height);

        return new Pair(myHeight,amIBalanced);
    }

}
