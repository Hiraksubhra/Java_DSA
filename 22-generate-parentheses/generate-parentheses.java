class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        recurse(parentheses, 0 , 0, "", n);
        return parentheses;
    }
    private void recurse(List<String> parentheses, int open, int close, String curr, int n){
        if(curr.length() == n*2){
            parentheses.add(curr);
            return;
        }
        if(open < n){
            recurse(parentheses, open+1, close, curr+"(", n);
        }
        if(close < open){
            recurse(parentheses, open, close+1, curr+")", n);
        }
    }
}