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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) {
            return null;
        }

        TreeNode leftAns = removeLeafNodes(root.left,target);
        TreeNode rightAns = removeLeafNodes(root.right,target);
        root.left = leftAns;
        root.right =rightAns;
        if(root.val == target && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }
}