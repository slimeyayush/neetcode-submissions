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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1 - 2 3 4   2 1 3 4  root 1 find root in inorder now left subtree needs a prein and inin presi presi + len
        int n = preorder.length;
        return build(preorder,0,n-1,inorder,0,n-1);
    }
    public TreeNode build(int[] pre,int presi,int preei,int[] in,int insi,int inei) {
        if(presi > preei || insi > inei) {
            return null;
        }
        TreeNode root = new TreeNode(pre[presi]);
        int temp = insi;
        int leftCount = 0;
        while(in[temp] != pre[presi]) {
            temp++;
            leftCount++;
        }
        root.left = build(pre,presi+1,presi+leftCount,in,insi,temp-1);
        root.right = build(pre,presi+leftCount+1,preei,in,temp+1,inei);

        return root;
    }
}
