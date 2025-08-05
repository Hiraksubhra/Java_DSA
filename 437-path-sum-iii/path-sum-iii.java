public class Solution {
    public int pathSum(TreeNode node, int sum){ 
        List<Long> paths = new ArrayList<>();
        return helper(node, (long) sum, paths);
    }

    int helper(TreeNode node, long sum, List<Long> paths){
        if(node == null){
            return 0;
        }

        paths.add((long)node.val);
        int count = 0;
        long s = 0;

        ListIterator<Long> itr = paths.listIterator(paths.size());
        while(itr.hasPrevious()){
            s+=itr.previous();
            if(s == sum){
                count++;
            }
        }
        count+= helper(node.left, sum, paths) + helper(node.right, sum, paths);
        
        //backtrack
        paths.remove(paths.size()-1);
        return count;
    }
}