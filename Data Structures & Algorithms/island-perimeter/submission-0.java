class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int perimeter = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){

                if(grid[i][j] == 1){
                    perimeter += 4;

                        // checking if top neighbour is also 1
                    if(i > 0 && grid[i-1][j] == 1){
                        perimeter -= 2;
                    }
                        // checking if left neighbour is also 1
                    if(j > 0 && grid[i][j-1] == 1){
                        perimeter -= 2;
                    }
                }
                
            }
        }

        return perimeter;

    }
}