import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Handle empty or null string gracefully
        if (data == null || data.isEmpty()) {
            return null;
        }
        
        // Use a Queue to process elements in the correct order
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        // Get the next value from the queue
        String val = queue.poll();
        
        // Base case: if the value is "null", return null
        if ("null".equals(val)) {
            return null;
        }

        // Create the current node
        TreeNode node = new TreeNode(Integer.parseInt(val));

        // Recursively build the left and right subtrees
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }
}