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
    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return bstBuilder(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode bstBuilder(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRootIdx = inOrderMap.get(rootVal);
        int leftTreeSize = inRootIdx - inStart;

        root.left = bstBuilder(preorder, preStart + 1, preStart + leftTreeSize, inStart, inRootIdx - 1);
        root.right = bstBuilder(preorder, preStart + leftTreeSize + 1, preEnd, inRootIdx + 1, inEnd);

        return root;
    }
}
