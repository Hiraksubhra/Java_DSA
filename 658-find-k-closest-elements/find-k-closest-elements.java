class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // The search space for the binary search is the possible start indices of a valid window of size k.
        // The window can start from index 0 up to index arr.length - k.
        int low = 0;
        int high = arr.length - k;

        // Binary search to find the best starting index for the window of k elements.
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Compare the element at the start of the window (arr[mid]) with the
            // element just after the end of the window (arr[mid + k]).
            // We want to determine if x is closer to arr[mid] or arr[mid + k].
            // If x is farther from arr[mid] than it is from arr[mid + k],
            // it means our optimal window is likely to the right of mid.
            // The condition `x - arr[mid] > arr[mid + k] - x` checks this.
            // - `x - arr[mid]` is the distance from the left bound.
            // - `arr[mid + k] - x` is the distance from the right bound.
            //
            // If the left element (arr[mid]) is "more distant" from x than the
            // right element (arr[mid+k]), we should shift our window to the right.
            // Thus, we set low = mid + 1.
            // Otherwise, the current window starting at `mid` is a better or equally
            // good candidate, so we try to find an even better window to the left.
            // Thus, we set high = mid.
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Once the loop terminates, 'low' will be the starting index of the
        // k closest elements subarray.
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(arr[low + i]);
        }

        return result;
    }
}