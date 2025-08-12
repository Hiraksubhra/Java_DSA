import java.util.Arrays;

class Solution {
    Integer[][] memo;
    
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        memo = new Integer[nums.length][2 * totalSum + 1];

        return solve(nums, target, 0, 0, totalSum);
    }
    
    private int solve(int[] nums, int target, int index, int current_sum, int offset) {
        // Base Case: We have processed all numbers
        if (index == nums.length) {
            return (current_sum == target) ? 1 : 0;
        }
        
        // Memoization Check: Use the offset to get a valid array index
        if (memo[index][current_sum + offset] != null) {
            return memo[index][current_sum + offset];
        }
        
        // Recursive Step: Explore both possibilities (add and subtract)
        int add_solve = solve(nums, target, index + 1, current_sum + nums[index], offset);
        int subtract_solve = solve(nums, target, index + 1, current_sum - nums[index], offset);
        
        int result = add_solve + subtract_solve;
        
        memo[index][current_sum + offset] = result;
        
        return result;
    }
}