class Solution {
    public boolean reorderedPowerOf2(int N) {
        String target = counter(N);
        for (int i = 0; i < 31; i++) {
            if(target.equals(counter(1<<i))){
                return true;
            }
        }
        return false;
    }
    private String counter(int N){
        int[] a = new int[11];
        while(N>0) {
            int d = N % 10;
            a[d]++;
            N/=10; 
        }
        return Arrays.toString(a);
    }
}