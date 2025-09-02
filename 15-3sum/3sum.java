class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n-2; i++){
            //Use two pointers 'j' and 'k' for the rest of the array
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i+1, k = n-1;
            while(j<k){
                int sum = nums[j] + nums[k] + nums[i];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    //Skip duplicate elements for 'j' and 'k'
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }else if (sum < 0) {
            // The sum is too small, need a larger number, so move the left pointer 'j' up.
                    j++;
                } else { // sum > 0
                    // The sum is too large, need a smaller number, so move the right pointer 'k' down.
                    k--;
                }
            } 
        }
        return result;
    }
}