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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // serialize helper function
    public void serializeHelper(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        // Pull the next token from the front of the line
        String token = queue.poll();

        // Base case:
        if(token.equals("N")) {
            return null;
        }

        // Reconstruct the current root node
        TreeNode root = new TreeNode(Integer.parseInt(token));

        // Recursively building the left and right subtrees
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }
}
