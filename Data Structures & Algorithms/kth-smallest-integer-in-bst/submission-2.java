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
    // global tracking variables
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    public void inOrder(TreeNode node, int k) {
        // base case
        if(node == null || count >= k) return;

        // go left
        inOrder(node.left, k);

        count++;
        if(count == k) {
            result = node.val;
            return;
        }


        // go right
        inOrder(node.right, k);

    }
}
