class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(i < s.length() -1 && roman.get(ch) < roman.get(s.charAt(i+1))){
                ans-=roman.get(ch);
            }else{
                ans+=roman.get(ch);
            }
        }
        return ans;
    }
}