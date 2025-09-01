class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if(height == null || n == 0){
            return 0;
        }
        int maxArea = 0,left = 0, right = n-1;

        while(left<right){
            int currHeight = Math.min(height[left], height[right]);
            int currWidth = right - left;
            int currArea = currHeight*currWidth;
            maxArea = Math.max(currArea, maxArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}