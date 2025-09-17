class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> palins = new ArrayList<>();
        helper(s, palins, new ArrayList<>());
        return palins;
    }
    private void helper(String s, List<List<String>> palins, List<String> curr){
        if(s == null || s.length() == 0){
            palins.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue;
            curr.add(temp);
            helper(s.substring(i,s.length()), palins, curr);
            curr.remove(curr.size()-1); 
        }
        return;
    }
    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}