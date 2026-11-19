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
    public int diameterOfBinaryTree(TreeNode root) {
        // best answer either goes through me by joining with two sides or passing my height to the parent 
        height(root);
        return ans;


    }
    public  int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int la = height(root.left);
        int ra = height(root.right);
        int diaMe = la + ra;
        ans = Math.max(ans,diaMe);

        return 1 + Math.max(la,ra);
    }
}
