class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // left pointer for our sliding window
        int left = 0;
        // Stores the maximum fruits collected for any valid window
        int maxFruits = 0;
        // Stores the sum of fruits in the current window
        long currentFruits = 0;

        // Iterate through the fruits array with the 'right' pointer to expand the window
        for (int right = 0; right < fruits.length; right++) {
            // Add the fruits at the current 'right' position to our window sum
            currentFruits += fruits[right][1];

            // Get the positions of the left and right boundaries of our current window
            int leftPos = fruits[left][0];
            int rightPos = fruits[right][0];

            int steps = calculateSteps(startPos, leftPos, rightPos);

            // If the steps required for the current window exceed k, we need to shrink the window from the left.
            while (steps > k) {
                // Remove the fruit from the left of the window
                currentFruits -= fruits[left][1];
                // Move the left pointer to shrink the window
                left++;
                if (left > right) {
                    break;
                }

                // Recalculate the position of the new left boundary and the steps required.
                leftPos = fruits[left][0];
                steps = calculateSteps(startPos, leftPos, rightPos);
            }
            maxFruits = Math.max(maxFruits, (int)currentFruits);
        }

        return maxFruits;
    }

    private int calculateSteps(int startPos, int leftPos, int rightPos) {
        // Cost of going right first, then turning back to cover the left part
        int costGoRightFirst = Math.abs(startPos - rightPos) + (rightPos - leftPos);
        // Cost of going left first, then turning back to cover the right part
        int costGoLeftFirst = Math.abs(startPos - leftPos) + (rightPos - leftPos);

        // The total steps will be the minimum of the two strategies
        return Math.min(costGoRightFirst, costGoLeftFirst);
    }
}