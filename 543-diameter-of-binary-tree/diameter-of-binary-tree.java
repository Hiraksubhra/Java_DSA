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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = height(node.left);
        int rightDepth = height(node.right);
        int currDia = leftDepth + rightDepth;
        diameter = Math.max(diameter, currDia);
        return Math.max(leftDepth, rightDepth)+1;
    }
}