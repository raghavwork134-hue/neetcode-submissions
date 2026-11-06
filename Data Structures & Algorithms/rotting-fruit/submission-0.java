class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int freshFruitCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    freshFruitCount++;
                }
            }
        }

        int[][] directions = {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };

        int minutes = 0;

        while(!queue.isEmpty() && freshFruitCount != 0){
            
            int size = queue.size();

            for(int i = 0;i<size;i++){
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for(int[] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 && newRow < rows && 
                       newCol >= 0 && newCol < cols &&
                       grid[newRow][newCol] == 1){

                        // Rot the fresh fruit
                        grid[newRow][newCol] = 2;

                        // One less fresh fruit
                        freshFruitCount--;

                        // Add newly rotten fruit for next minute
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }

        return freshFruitCount == 0 ? minutes : -1;

    }
}
