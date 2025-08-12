class Solution {
    int mod = (int)1e9 + 7;
    int[][] memo;

    public int numberOfWays(int n, int x) {
        int limit = (int) Math.pow(n, 1.0 / x);
        
        memo = new int[n + 1][limit + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(n, x, 1);
    }
    
    private int solve(int target, int x, int current_num) {
        int power_of_current_num = (int) Math.pow(current_num, x);
        if (target == 0) {
            return 1;
        }
        if (power_of_current_num > target || current_num >= memo[0].length) {
            return 0;
        }
        if (memo[target][current_num] != -1) {
            return memo[target][current_num];
        }

        int ways_with_current = solve(target - power_of_current_num, x, current_num + 1);

        int ways_without_current = solve(target, x, current_num + 1);

        int result = (ways_with_current + ways_without_current) % mod;

        memo[target][current_num] = result;

        return result;
    }
}