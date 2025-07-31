class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] primes = findPrimes(left, right);
        if (primes.length < 2) {
            return new int[]{-1, -1};
        }
        
        int[] res = new int[]{0, Integer.MAX_VALUE};
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < primes.length; i++) {
            int currDiff = primes[i] - primes[i-1];
            if (currDiff < minDiff || 
                (currDiff == minDiff && primes[i-1] < res[0])) {
                minDiff = currDiff;
                res[0] = primes[i-1];
                res[1] = primes[i];
            }
        }
        
        return res;
    }
    private int[] findPrimes(int left, int right) {
        if (right < 2) {
            return new int[0];
        }
        left = Math.max(2, left);
        
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= right; p++) {
            if (isPrime[p]) {
                for (int j = p * p; j <= right; j += p) {
                    isPrime[j] = false;
                }
            }
        }
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        int[] primes = new int[count];
        int index = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes[index++] = i;
            }
        }
        
        return primes;
    }
}