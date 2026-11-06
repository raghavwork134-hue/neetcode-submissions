class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int col = 0;col<cols;col++){
            dfs(0,col,heights,pacific);
        }
        for(int row = 0;row<rows;row++){
            dfs(row,0,heights,pacific);
        }

        for(int col = 0;col<cols;col++){
            dfs(rows-1,col,heights,atlantic);
        }

        for(int row = 0;row<rows;row++){
            dfs(row,cols-1,heights,atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int row = 0;row<rows;row++){
            for(int col = 0;col<cols;col++){
                if(pacific[row][col] && atlantic[row][col]){
                    res.add(Arrays.asList(row,col));
                }
            }
        }

        return res;
    }
    private void dfs(int row,int col,int[][] heights,boolean[][] visited){

        visited[row][col] = true;

        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow < 0 || newRow >= heights.length || newCol < 0 
               || newCol >= heights[0].length){
                continue;
            }

            if(visited[newRow][newCol]){
                continue;
            }

            if(heights[newRow][newCol] < heights[row][col]){
                continue;
            }

            dfs(newRow,newCol,heights,visited);
        }
    }
}
