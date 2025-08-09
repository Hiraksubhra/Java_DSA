class Solution {
    public String convert(String s, int numRows) {
        // Handle edge cases where no zigzag pattern is formed.
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Use an array of StringBuilder objects for better performance and readability.
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRowIndex = 0;
        int direction = 1; // 1 for moving down, -1 for moving up.

        // Iterate through each character of the string to fill the rows.
        for (char c : s.toCharArray()) {
            rows[currentRowIndex].append(c);

            // Change direction when reaching the top or bottom row.
            if (currentRowIndex == 0) {
                direction = 1;
            } else if (currentRowIndex == numRows - 1) {
                direction = -1;
            }
            
            currentRowIndex += direction;
        }

        // Concatenate all rows to form the final result string.
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}