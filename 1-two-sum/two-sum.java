class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            hash.put(nums[i], i);
        }
        int complement = -1;
        for(int i = 0; i < n; i++){
            complement = target - nums[i];
            if(hash.containsKey(complement) && hash.get(complement)!=i){
                return new int[]{i,hash.get(complement)};
            }
        }
        return new int[]{};
    }
}