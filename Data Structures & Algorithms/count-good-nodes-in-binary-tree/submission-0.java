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
    int totalCount = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val);
        return totalCount;
    }

    public void dfs(TreeNode node, int maxSoFar) {
        if(node == null) return;

        if(node.val >= maxSoFar) {
            totalCount++;
        }

        maxSoFar = Math.max(maxSoFar, node.val);

        dfs(node.left, maxSoFar);
        dfs(node.right, maxSoFar);
    }
}
