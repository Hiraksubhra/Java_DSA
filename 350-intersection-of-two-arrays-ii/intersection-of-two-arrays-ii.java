class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums1){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        List<Integer> res = new ArrayList<>();
        for(int num : nums2){
            if(freq.containsKey(num) && freq.get(num)>0){
                res.add(num);
                freq.put(num, freq.get(num)-1);
            }
        }
        int[] resultArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resultArr[i] = res.get(i);
        }
        return resultArr;
    }
}