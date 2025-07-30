class Solution {
    public int longestSubarray(int[] nums) {
        int maxNum = 0, ans = 0, currentStreak = 0;

        for(int num : nums){
            if(num > maxNum){
                maxNum = num;
                ans = currentStreak = 0;
            }

            if(maxNum == num){
                currentStreak++;
            }else{
                currentStreak = 0; 
            }
            ans = Math.max(ans, currentStreak);
        }
        return ans;
    }
}