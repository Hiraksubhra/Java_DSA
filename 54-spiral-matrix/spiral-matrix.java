class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i = colStart; i <= colEnd; i++){
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            for(int j = rowStart; j <= rowEnd; j++){
                list.add(matrix[j][colEnd]);
            }
            colEnd--;
            if(rowStart <= rowEnd) { // Check if there's a row to traverse
                for(int i = colEnd; i >= colStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if(colStart <= colEnd) { // Check if there's a column to traverse
                for(int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return list;
    }
}