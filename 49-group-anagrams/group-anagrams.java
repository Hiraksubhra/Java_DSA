class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] ca = word.toCharArray();
            Arrays.sort(ca);
            String sortedWord = new String(ca);
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}