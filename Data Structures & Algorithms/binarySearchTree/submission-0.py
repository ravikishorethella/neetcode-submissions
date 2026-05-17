# create the Binary Search TreeNode
class TreeNode:
    def __init__(self, key:int, val:int):
        self.key = key
        self.val = val
        self.left = None
        self.right = None

class TreeMap:
    
    def __init__(self):
        self.root = None


    def insert(self, key: int, val: int) -> None:
        newNode = TreeNode(key, val)
        # no root
        if self.root == None:
            self.root = newNode
            return 

        current = self.root
        while True:
            if key < current.key:
                if current.left == None:
                    current.left = newNode
                    return
                current = current.left
            elif key > current.key:
                if current.right == None:
                    current.right = newNode
                    return
                current = current.right
            else:
                current.val = val
                return


    def get(self, key: int) -> int:
        current = self.root
        while current != None:
            if key < current.key:
                current = current.left
            elif key > current.key:
                current = current.right
            else:
                return current.val
        return -1


    def getMin(self) -> int:
        current = self.findMin(self.root)
        return current.val if current else -1

    
    def findMin(self, node: TreeNode) -> TreeNode:
        while node and node.left:
            node = node.left
        return node


    def getMax(self) -> int:
        current = self.root
        while current and current.right:
            current = current.right
        return current.val if current else -1


    def remove(self, key: int) -> None:
        self.root = self.removeHelper(self.root, key)

    # returns the new root after removing the key
    def removeHelper(self, current: TreeNode, key: int) -> TreeNode:
        if current == None:
            return None
        
        if key < current.key:
            current.left = self.removeHelper(current.left, key)
        elif key > current.key:
            current.right = self.removeHelper(current.right, key)
        else:
            if current.left == None:
                # replace current with right child
                return current.right
            elif current.right == None:
                return current.left
            else:
                # swap current with inorder successor
                minNode = self.findMin(current.right)
                current.key = minNode.key
                current.val = minNode.val
                current.right = self.removeHelper(current.right, minNode.key)
        return current


    def getInorderKeys(self) -> List[int]:
        result = []
        self.inorderTraversal(self.root, result)
        return result


    def inorderTraversal(self, root: TreeNode, result: List[int]) -> None:
        if root != None:
            self.inorderTraversal(root.left, result)
            result.append(root.key)
            self.inorderTraversal(root.right, result)

