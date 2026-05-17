# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        # base case: check if root is empty
        # if root is empty then create new TreeNode
        if not root:
            return TreeNode(val)

        # case 1: val > root.val
        if val > root.val:
            root.right = self.insertIntoBST(root.right, val)

        # case 2: val < root.val
        if val < root.val:
            root.left = self.insertIntoBST(root.left, val)

        return root
    

        
        