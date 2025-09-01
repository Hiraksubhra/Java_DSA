class Solution {
    public boolean isPalindrome(String s) {
        String forward = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }
}