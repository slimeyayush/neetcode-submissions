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
    int ans = 0;
    public static class Info {
         int height;
         int diameter;

         Info(int height,int diameter) {
            this.height = height;
            this.diameter = diameter;
         }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans;
    }
    public Info helper(TreeNode root) {
        if(root == null) {
            return new Info(0,0);
        }
        Info leftAns = helper(root.left);
        Info rightAns = helper(root.right);

        int diaThroughMe = leftAns.height + rightAns.height;
        ans = Math.max(ans,diaThroughMe);
        int height = 1 + Math.max(leftAns.height,rightAns.height);
        return new Info(height,diaThroughMe);
    }
}
