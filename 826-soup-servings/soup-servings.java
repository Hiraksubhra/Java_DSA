class Solution {
    double[][] memo = new double[200][200];
    public double soupServings(int n) {
        if(n>=4800){
            return 1;
        }
        return helper((n+24)/25, (n+24)/25);
    }
    double helper(int A, int B){
        if(A <= 0 && B <= 0){
            return 0.5;
        }
        if(A <= 0){
            return 1;
        }
        if(B <= 0){
            return 0;
        }
        if(memo[A][B] > 0){
            return memo[A][B];
        } 
        memo[A][B] = 0.25 * (helper(A-4, B) + helper(A-3, B-1) + helper(A-2, B-2) + helper(A-1, B-3));
        return memo[A][B];
    }
}