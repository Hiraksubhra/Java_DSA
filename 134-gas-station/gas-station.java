class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startingPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank+=diff;
            currentTank+=diff;
            if(currentTank < 0){
                startingPoint = i+1;
                currentTank = 0;
            }
        }
        if(totalTank < 0){
            return -1;
        }else{
            return startingPoint;
        }
    }
}