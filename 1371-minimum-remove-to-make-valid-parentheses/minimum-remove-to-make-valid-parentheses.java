class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); 
            if(ch == '('){
                stack.push(i);
            }else if(ch == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    toRemove.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            toRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!toRemove.contains(i)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}