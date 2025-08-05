class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1; // Pointer for nums1's elements
    int p2 = n - 1; // Pointer for nums2's elements
    int p = m + n - 1; // Pointer for the merged array

        while (p2 >= 0) {
            // If p1 is a valid index and nums1's element is greater
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                // Otherwise, take the element from nums2
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }
}