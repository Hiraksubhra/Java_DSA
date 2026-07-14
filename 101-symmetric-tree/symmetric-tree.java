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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode leftChild = queue.poll();
            TreeNode rightChild = queue.poll();
            if(leftChild == null && rightChild == null) continue;
            if(leftChild == null || rightChild == null) return false;
            if(leftChild.val != rightChild.val) return false;
            queue.offer(leftChild.left);
            queue.offer(rightChild.right);
            queue.offer(leftChild.right);
            queue.offer(rightChild.left);
        }
        return true;
    }
}