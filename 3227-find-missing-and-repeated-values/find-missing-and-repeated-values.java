class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalNumbers = n * n;
        int[] freq = new int[totalNumbers + 1]; // Using 1-based indexing
        int[] res = new int[2];
        
        // Count frequencies of each number
        for (int[] row : grid) {
            for (int num : row) {
                freq[num]++;
            }
        }
        for (int i = 1; i <= totalNumbers; i++) {
            if (freq[i] == 2) {
                res[0] = i; // Duplicate
            } else if (freq[i] == 0) {
                res[1] = i; // Missing
            }
        }
        
        return res;
    }
}