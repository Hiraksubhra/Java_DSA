class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int freshOranges = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
        int minutes = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty() && freshOranges>0){
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int row = rotten[0];
                int col = rotten[1];
                for(int[] dir: directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow >= 0 && newRow < m && newCol>=0 && newCol<n && grid[newRow][newCol]==1){
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return freshOranges == 0 ? minutes:-1;
    }
}