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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null){
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        boolean rev = false;
        deque.offer(root);
        while (!deque.isEmpty()) { 
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            if(!rev){
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = deque.pollFirst();
                    currentLevel.add(currNode.val);
                    if(currNode.left != null){
                        deque.addLast(currNode.left);
                    }
                    if(currNode.right != null){
                        deque.addLast(currNode.right);
                    }
                }
            }else{
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = deque.pollLast();
                    currentLevel.add(currNode.val);
                    if(currNode.right != null){
                        deque.addFirst(currNode.right);
                    }
                    if(currNode.left != null){
                        deque.addFirst(currNode.left);
                    }
                }
            }
            
            rev = (!rev);
            list.add(currentLevel);
        }
        return list;
    }
}