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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;

        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy));
    }
    private TreeNode findNode(TreeNode root, int x){
        if(root == null) return null;
        if(root.val == x) return root;

        TreeNode l = findNode(root.left, x);
        if(l != null) return l;

        return findNode(root.right, x);
    }
    private int level(TreeNode root, TreeNode node, int level){
        if(root == null) return 0;
        if(root == node) return level;

        int l = level(root.left, node, level+1);

        if(l != 0) return l;

        return level(root.right, node, level+1);
    }
    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if(node == null) return false;

        return (
            (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }
}