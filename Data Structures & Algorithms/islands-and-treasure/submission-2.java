class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int INF = 2147483647;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for(int dir[] : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < rows && newCol >= 0 
                   && newCol < cols && grid[newRow][newCol]== INF){
                    
                    grid[newRow][newCol] = grid[row][col] + 1;
                    q.add(new int[]{newRow,newCol});
                }

                
            }
        }
    }
}
