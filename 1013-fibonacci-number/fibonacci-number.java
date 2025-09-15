class Solution {
    public int fib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fib(n, memo);
    }
    private int fib(int n, Map<Integer, Integer> memo){
        if(n == 0 || n == 1){
            return n;
        }
        if(!memo.containsKey(n)){
            memo.put(n, fib(n-1, memo)+fib(n-2, memo));
        }
        return memo.get(n);
    }
}