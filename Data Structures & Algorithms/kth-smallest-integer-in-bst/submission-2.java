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
    int pro;
    int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        pro = k;
        inorder(root);
        return answer;
    }
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(pro == 0) {
            return;
        }
        if(--pro == 0) {
            answer = root.val;
            return;
        }
        inorder(root.right);
    }
}
