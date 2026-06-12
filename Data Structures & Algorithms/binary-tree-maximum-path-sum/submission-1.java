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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getTotalSum(root);
        return maxSum;
    }

    public int getTotalSum(TreeNode node) {
        if(node == null) return 0;

        int leftSum = Math.max(0, getTotalSum(node.left));
        int rightSum = Math.max(0, getTotalSum(node.right));

        int currentSum = node.val + leftSum + rightSum;

        maxSum = Math.max(currentSum, maxSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
