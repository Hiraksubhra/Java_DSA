class Solution {
    public String intToRoman(int num)
    {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder roman = new StringBuilder();
        // Iterate through the values and symbols
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                // Append the corresponding symbol to the result
                roman.append(symbols[i]);
                // Subtract the value from num
                num -= values[i];
            }
        }
        return roman.toString();   
    }
}