class RandomizedCollection {

    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> map;
    java.util.Random rand = new java.util.Random();

    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
    }
    
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain){
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int deleteIndex = map.get(val).iterator().next();
        map.get(val).remove(deleteIndex);
        if(deleteIndex < nums.size()-1){
            int last = nums.get(nums.size()-1);
            nums.set(deleteIndex, last);
            map.get(last).remove(nums.size()-1);
            map.get(last).add(deleteIndex);
        }
        nums.remove(nums.size()-1);
        if(map.get(val).isEmpty()) map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */