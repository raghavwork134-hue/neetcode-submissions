class Solution {
    public List<List<String>> solveNQueens(int n) {
        
    //     List<List<String>> result = new ArrayList<>();

    //     char[][] board = new char[n][n];

    //     for(int i = 0;i<n;i++){
    //         Arrays.fill(board[i],'.');
    //     }

    //     // Track occupied columns and diagonals
    //     boolean[] columns = new boolean[n];
    //     boolean[] diagonal1 = new boolean[2 * n - 1];
    //     boolean[] diagonal2 = new boolean[2 * n - 1];

    //     backtrack(0, n, board, columns, diagonal1, diagonal2, result);

    //     return result;
    // }

    // private void backtrack(int row, int n, char[][] board,
    //  boolean[] columns, boolean[] diagonal1, boolean[] diagonal2,
    //  List<List<String>> result){

    //     if(row == n){
    //         result.add(createBoard(board));
    //         return;
    //     }

    //     // Try every column in the current row
    //     for (int col = 0; col < n; col++) {

    //         int diag1 = row - col + n - 1;
    //         int diag2 = row + col;

    //         // Check if position is unsafe
    //         if (columns[col] || diagonal1[diag1] || diagonal2[diag2]) {
    //             continue;
    //         }

    //         // Choose
    //         board[row][col] = 'Q';
    //         columns[col] = true;
    //         diagonal1[diag1] = true;
    //         diagonal2[diag2] = true;

    //         // Explore
    //         backtrack(row + 1, n, board,
    //                   columns, diagonal1, diagonal2, result);

    //         // Backtrack / Undo
    //         board[row][col] = '.';
    //         columns[col] = false;
    //         diagonal1[diag1] = false;
    //         diagonal2[diag2] = false;
    //     }
    // }

    // private List<String> createBoard(char[][] board) {

    //     List<String> currentBoard = new ArrayList<>();

    //     for (char[] row : board) {
    //         currentBoard.add(new String(row));
    //     }

    //     return currentBoard;
    
    // }

    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];

    for(int i = 0;i<n;i++){
        Arrays.fill(board[i],'.');
    }

    boolean[] column = new boolean[n];
    boolean[] diagonal1 = new boolean[2 * n - 1];
    boolean[] diagonal2 = new boolean[2 * n - 1];

    backtrack(res,board,column,diagonal1,diagonal2,n,0);
    return res;
    }
    private void backtrack(List<List<String>> res,char[][] board,
    boolean[] column,boolean[] diagonal1,boolean[] diagonal2,
    int n,int row){

        if(row == n){
            res.add(createboard(board));
            return;
        }

        for(int col = 0;col < n;col++){
            int diag1 = row - col + n - 1;
            int diag2 = row + col;

            if(column[col] || diagonal1[diag1] || diagonal2[diag2]){
                continue;
            }

            board[row][col] = 'Q';
            column[col] = true;
            diagonal1[diag1] = true;
            diagonal2[diag2] = true;

            backtrack(res,board,column,diagonal1,diagonal2,n,row+1);

            board[row][col] = '.';
            column[col] = false;
            diagonal1[diag1] = false;
            diagonal2[diag2] = false;
        }
    }
    private List<String> createboard(char[][] board){
        List<String> currBoard = new ArrayList<>();
        for(char[] row : board){
            currBoard.add(new String(row));
        }
        return currBoard;
    }

    // try backtracking(with visited array)
}
