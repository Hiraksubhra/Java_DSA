class RandomizedSet {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> map;
    java.util.Random rand = new java.util.Random();

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int deleteIndex = map.get(val);
        if(deleteIndex < nums.size()-1){
            int last = nums.get(nums.size()-1);
            nums.set(deleteIndex, last);
            map.put(last, deleteIndex);
        }
        map.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */