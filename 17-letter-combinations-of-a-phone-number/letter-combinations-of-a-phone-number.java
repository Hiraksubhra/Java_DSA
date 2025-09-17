class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return list;
        }
        String[] keys = new String[]{"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(list, keys, digits, "", 0);
        return list;
    }
    private void helper(List<String> list, String[] keys, String digits, String curr, int offset){
        if(offset == digits.length()){
            list.add(curr);
            return;
        }
        String letters = keys[digits.charAt(offset)-'0'];

        for(int i = 0; i<letters.length(); i++){
            helper(list, keys, digits, curr+letters.charAt(i), offset+1);
        }
    }
}