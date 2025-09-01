class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    public int search(int[] arr, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int m = start + (end - start)/2;
        if(arr[m] == target){
            return m;
        }
        if(arr[start]<=arr[m]){
            if(target>=arr[start] && target<=arr[m]){
                return search(arr, target, start,m-1);
            }else{
                return search(arr, target, m+1, end);
            }
        }
        if(target>=arr[m] && target<=arr[end]){
            return search(arr, target, m+1,end);
        }
        return search(arr, target, start, m-1);
    }
}