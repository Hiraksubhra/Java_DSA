class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        for(int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for(int i = 0; i<n;i++){
            int val = Math.abs(nums[i]);
            if(val > n) continue;
            if(nums[val - 1] > 0){ //prevents double negative operations
                nums[val-1]*=-1;
            }
        }
        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for(int i = 0; i<n; i++){
            if(nums[i] >= 0){
                return i+1;
            }
        }
        return n+1;
    }
}