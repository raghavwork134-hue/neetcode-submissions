class Solution {
    public int numIslands(char[][] grid) {

    //     int island = 0;

    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     for(int i = 0;i<rows;i++){
    //         for(int j = 0;j<cols;j++){

    //             if(grid[i][j] == '1'){
    //                 island++;
    //                 dfs(grid,i,j);
    //             }
    //         }
    //     }
    //     return island;
    // }

    // private void dfs(char[][] grid, int row, int col){

    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     if(row < 0 || row >= rows || col < 0 || col >= cols ||
    //        grid[row][col] == '0' ){
    //         return;
    //     }

    //     grid[row][col] = '0';

    //     dfs(grid, row - 1, col);
    //     dfs(grid, row + 1, col);
    //     dfs(grid, row, col - 1);
    //     dfs(grid, row, col + 1);
    // }

    int island = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    for(int i = 0;i<rows;i++){
        for(int j = 0;j<cols;j++){
            if(grid[i][j] == '1'){
                island++;
                dfs(grid,i,j);
            }
        }
    }
    return island;
    }
    private void dfs(char[][] grid,int row,int col){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols || 
           grid[row][col] == '0' ){
            return;
        }
        grid[row][col] = '0';
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
