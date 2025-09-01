class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // Step 1: Find the first decreasing element from the right (the pivot).
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        // If no pivot is found, the array is in descending order (e.g., [3,2,1]).
        // This is the last permutation, so we reverse it to get the first one ([1,2,3]).
        if (pivot == -1) {
            reverse(nums, 0);
            return;
        }
        // Step 2: Find the rightmost element greater than the pivot (the successor).
        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                // Step 3: Swap the pivot and the successor.
                swap(nums, pivot, i);
                break;
            }
        }
        // Step 4: Reverse the suffix starting after the pivot's position.
        reverse(nums, pivot + 1);
    }

    // Helper to reverse a subarray from the start index to the end.
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    // Helper to swap two elements in an array.
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}