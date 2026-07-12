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
    int ans = Integer.MIN_VALUE;
    public int rob(TreeNode root) {
        helper(root);
        return ans;
    }
    public int[] helper(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }
        int[] leftAns = helper(root.left);
        int[] rightAns = helper(root.right); // dono sides se [rob,norob];

        int myRob = root.val + leftAns[1] + rightAns[1]; // i rob so both child can't
        int noRob = Math.max(leftAns[0],leftAns[1]) + Math.max(rightAns[0],rightAns[1]);

        ans = Math.max(ans,Math.max(noRob,myRob));

        return new int[]{myRob,noRob};
        
    }
}