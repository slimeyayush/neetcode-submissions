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
    public int kthSmallest(TreeNode root, int k) {
        // leftmost element smallest we can't travel back stack helps us do it;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            while(node!= null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(--k == 0) {
                return node.val;
            }
            node = node.right;

        }
        return -1;
    }
}
