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
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxDiameter;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);

        maxDiameter = Math.max((leftDepth + rightDepth), maxDiameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
