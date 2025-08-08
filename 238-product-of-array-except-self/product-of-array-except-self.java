class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] ans=new int[nums.length];
        int suffix=1;
        for (int i=nums.length-1;i>=0;i--){
            ans[i]=suffix;
            suffix=suffix*nums[i];
        }
        int prefix=1;
        for (int i=0;i<nums.length;i++){
            ans[i]=prefix*ans[i];
            prefix=nums[i]*prefix;
        } 
        return ans;
    }
}