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
        if(root == null) {
            return null;
        }
        TreeNode leftAns = invertTree(root.left);
        TreeNode rightAns = invertTree(root.right);
        // swapping at my level
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        return root;
    }
}
