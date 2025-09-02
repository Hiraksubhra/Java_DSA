class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix[0].length<1 || matrix.length<1 || matrix == null){
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col>=0 && row<=matrix.length-1){
            if(target == matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}