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
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // negative edge ko ignore karo it won't improve the answer negative answers are allowed but why add more negative on it 
        int la = Math.max(helper(root.left),0);
        int ra = Math.max(helper(root.right),0);

        int ansThrough = (la + ra + root.val);
        ans = Math.max(ans,ansThrough);
        return root.val + Math.max(la,ra);
    }
}
