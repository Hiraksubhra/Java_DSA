class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return 0;
        }
        int maxReach = 0, count = 0;
        
        int jumpEnd = 0;
        for(int i = 0; i < n; i++){
            maxReach = Math.max(maxReach, i+nums[i]);
            if(i == jumpEnd){
                count++;
                jumpEnd = maxReach;
                if(maxReach >=n-1){
                    break;
                }
            }
        }
        return count;
    }
}